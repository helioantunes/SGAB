package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import sgab.model.dto.Autor;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;
import sgab.model.dto.Pessoa;
import sgab.model.dto.Reserva;
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.exception.NegocioException;
import sgab.model.exception.PersistenciaException;
import sgab.model.service.GestaoAcervo;
import sgab.model.service.GestaoAutor;
import sgab.model.service.GestaoBibliotecaService;
import sgab.model.service.GestaoPessoasService;
import sgab.model.service.GestaoReservaService;


public class ReservaController {
    public static String reservar(HttpServletRequest request){
        String jsp = "";
        try {
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            Exemplar exemplarAlvo = gestaoAcervo.pesquisarExemplar(Long.parseLong(request.getParameter("exemplarId")));
            
            GestaoPessoasService gestaoPessoas = new GestaoPessoasService();
            Pessoa pessoaAlvo = gestaoPessoas.pesquisarPorId((Long) request.getSession().getAttribute("pessoaId"));
            
            exemplarAlvo.setStatus(ExemplarStatus.RESERVADO);
            Reserva reservaNova = new Reserva(pessoaAlvo, exemplarAlvo);
            
            GestaoReservaService gestaoReserva = new GestaoReservaService();
            gestaoReserva.cadastrar(reservaNova);
            
            jsp= "/core/reservas/operacao-sucesso.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String listarExemplares(HttpServletRequest request){
        String jsp = "";
        try {
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            List<Exemplar> listExemplares = gestaoAcervo.listaParaReserva();
            
            if(listExemplares != null && listExemplares.size() > 0){
                request.setAttribute("listExemplares", listExemplares);
                jsp = "/core/reservas/listar-exemplares.jsp";
            } else {
                String erro = "Nao existe registro de Exemplares!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String listarReservas(HttpServletRequest request){
        String jsp = "";
        try {
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            List<Exemplar> listExemplares = gestaoAcervo.listaParaReserva();
            
            if(listExemplares != null && listExemplares.size() > 0){
                request.setAttribute("listExemplares", listExemplares);
                jsp = "/core/reservas/listar-exemplares.jsp";
            } else {
                String erro = "Nao existe registro de Reservas!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String pesquisarListaExemplares(HttpServletRequest request){
        String jsp = "";
        try {
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            
            String tipo = request.getParameter("tipo");
            String nome = request.getParameter("nome");
            switch(tipo){
                case "titulo":
                    List<Exemplar> listExemplares = gestaoAcervo.listaParaReserva(nome);
                    request.setAttribute("listExemplares", listExemplares);
                    jsp = "/core/reservas/listar-exemplares.jsp";
                    break;
                    
                case "autor":
                    GestaoAutor gestaoAutor = new GestaoAutor();
                    Autor autor = gestaoAutor.pesquisarNome(nome);
                    List<Exemplar> listExemplares1 = gestaoAcervo.listaParaReserva(autor);
                    request.setAttribute("listExemplares", listExemplares1);
                    jsp = "/core/reservas/listar-exemplares.jsp";
                    break;
                
                case "biblioteca":
                    GestaoBibliotecaService gestaoBiblio = new GestaoBibliotecaService();
                    Biblioteca biblioteca = gestaoBiblio.pesquisarProNome(nome);
                    List<Exemplar> listExemplares2 = gestaoAcervo.listaParaReserva(biblioteca);
                    request.setAttribute("listExemplares", listExemplares2);
                    jsp = "/core/reservas/listar-exemplares.jsp";
                    break;    
                    
                default:
                    String erro = "Erro na entrada do tipo!";
                    request.setAttribute("erro", erro);
                    jsp = "/core/erro.jsp";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String pesquisarListaReservas(HttpServletRequest request){
        String jsp = "";
        try {
            GestaoReservaService gestaoReservaService = new GestaoReservaService();
            
            String tipo = request.getParameter("tipo");
            String nome = request.getParameter("nome");
            switch(tipo){
                case "titulo":
                    List<Reserva> listReservas = gestaoReservaService.listarReservas(nome);
                    request.setAttribute("listReservas", listReservas);
                    jsp = "/core/reservas/listar-reservas.jsp";
                    break;
                    
                case "leitor":
                    GestaoPessoasService gestaoPessoas = new GestaoPessoasService();
                    Pessoa leitor = gestaoPessoas.pesquisarPorLogin(nome);
                    List<Reserva> listReservas1 = gestaoReservaService.listarReservas(leitor);
                    request.setAttribute("listReservas", listReservas1);
                    jsp = "/core/reservas/listar-reservas.jsp";
                    break;  
                    
                default:
                    String erro = "Erro na entrada do tipo!";
                    request.setAttribute("erro", erro);
                    jsp = "/core/erro.jsp";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String finalizar(HttpServletRequest request){
        String jsp = "";
        try {
            GestaoReservaService gestaoReservaService = new GestaoReservaService();
            Reserva reservaAlvo = gestaoReservaService.pesquisarPorId(Long.parseLong(request.getParameter("reservaId")));
            
            try{
                // gestao emprestimo
                
                if(gestaoReservaService.listarReservas(reservaAlvo.getExemplar()).size() == 1 /* listar emprestimo por exemplar vazio*/ ){
                    reservaAlvo.getExemplar().setStatus(ExemplarStatus.DISPONIVEL);
                }
                
                gestaoReservaService.excluir(reservaAlvo);
                jsp = listarReservas(request);
            } catch(PersistenciaException ex){
                String erro = "Ocorreu erro ao Finalizar Reserva!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
