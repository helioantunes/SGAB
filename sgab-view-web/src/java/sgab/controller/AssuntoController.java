package sgab.controller;

import sgab.model.dto.Assunto;
import sgab.model.service.GestaoAssuntosService;
import sgab.model.exception.PersistenciaException; 
import jakarta.servlet.http.HttpServletRequest;

public class AssuntoController {

    public static String cadastrar(HttpServletRequest request) { 
        String jsp = "";
        try {
            
            String tagAssunto = request.getParameter("assuntoCadastro");

            Assunto assunto = new Assunto(tagAssunto);
            assunto.setNome(tagAssunto);

            GestaoAssuntosService gestaoAssunto = new GestaoAssuntosService();
            
            try {
                gestaoAssunto.cadastrar(assunto);
                jsp = "/sgab/core/assuntos/resultadocadastrar.jsp";
            }
            
            catch (IllegalArgumentException ilegal){
                String erro = "Nao foi possível gravar esse registro!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
            
        } 
        catch (Exception e) {   

            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String editar(HttpServletRequest request) {
        String jsp = "";
        try {
            // Lendo o nome do assunto que usuário deseja alterar e o novo assunto
            String assuntoAntigo = request.getParameter("assuntoAntigo");
            String assuntoNovo = request.getParameter("assuntoNovo");

            GestaoAssuntosService gestaoAssunto = new GestaoAssuntosService();
            Assunto assunto = gestaoAssunto.pesquisarAssunto(assuntoAntigo);
            
            if (assunto != null){
                request.setAttribute("assunto", assunto);
                jsp = "/sgab/core/assuntos/resultadoeditar.jsp"; // "/core/assunto/alterar.jsp"; 
            } else {
                String erro = "Ocorreu erro ao Editar Assunto!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String excluir(HttpServletRequest request) {
        String jsp = "";
        try {
            // Lendo o nome do assunto que usuário deseja excluir
            String tagAssuntoExcluido = request.getParameter("assuntoExcluir");
            GestaoAssuntosService gestaoAssunto = new GestaoAssuntosService();
            Assunto assunto = gestaoAssunto.pesquisarAssunto(tagAssuntoExcluido);
            try {
                gestaoAssunto.excluir(assunto);
                jsp = "/sgab/core/assuntos/resultadoexcluir.jsp"; //AssuntosController.listar(request);
            }
            catch(PersistenciaException ex) {
                String erro = "Ocorreu erro ao Excluir Assunto!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch(Exception e){
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}