package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import sgab.model.dto.Aquisicao;
import sgab.model.dto.Fornecedor;
import sgab.model.dto.Obra;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.AquisicaoStatus;
import sgab.model.service.GestaoAquisicao;
import sgab.model.service.GestaoFornecedoresService;
import sgab.model.service.GestaoObras;
import sgab.model.service.GestaoPessoasService;
import java.util.List;
import sgab.model.dto.Biblioteca;
import sgab.model.exception.NegocioException;
import sgab.model.exception.PersistenciaException;
import sgab.model.service.GestaoBibliotecaService;

public class AquisicaoController {
    public static String pedir(HttpServletRequest request) {
        String jsp = "";
        try {
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            request.getSession().setAttribute("idAquisicaoAtual", aquisicaoId);
            
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            if(aquisicao != null){
                jsp = "/core/aquisicoes/pedir-passo3.jsp";
            } else {
                String erro = "Ocorreu erro ao Pedir Aquisicao!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String listarTodos(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            List<Aquisicao> listAquisicoes = gestaoAquisicao.listarAquisicoes();
            if(listAquisicoes != null){
                request.setAttribute("listAquisicoes", listAquisicoes);
                jsp = "/core/aquisicoes/pedidos-aquisicoes.jsp";
            } else {
                String erro = "Nao existe registro de Aquisicoes!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String listarAtivos(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            List<Aquisicao> listAquisicoesAtivas = gestaoAquisicao.aquisicoesAtivas();
            if(listAquisicoesAtivas != null){
                request.setAttribute("listAquisicoesAtivas", listAquisicoesAtivas);
                jsp = "/core/aquisicoes/pedidos-ativos.jsp";
            } else {
                String erro = "Nao existe registro de Aquisicoes Ativas!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String listarPendentes(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            List<Aquisicao> listAquisicoesPendentes = gestaoAquisicao.aquisicoesPendente();
            if(listAquisicoesPendentes != null){
                request.setAttribute("listAquisicoesPendentes", listAquisicoesPendentes);
                jsp = "/core/aquisicoes/pedidos-pendentes.jsp";
            } else {
                String erro = "Nao existe registro de Aquisicoes Pendentes!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String listarFinalizados(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            List<Aquisicao> listAquisicoesFinalizadas = gestaoAquisicao.aquisicoesFinalizada();
            if(listAquisicoesFinalizadas != null){
                request.setAttribute("listAquisicoesFinalizadas", listAquisicoesFinalizadas);
                jsp = "/core/aquisicoes/pedidos-finalizados.jsp";
            } else {
                String erro = "Nao existe registro de Aquisicoes Finalizadas!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String gravarPendente(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoObras gestaoObra = new GestaoObras();
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            GestaoPessoasService gestaoPessoas = new GestaoPessoasService();
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            
            String etapa = request.getParameter("etapa");
            
            switch(etapa){
                case "primeiro":
                    String nomeObra = request.getParameter("nomeObra");
                    List<Obra> obraAlvo = gestaoObra.pesquisarObraNome(nomeObra);

                    String nomeBiblioteca = request.getParameter("biblioteca");
                    nomeBiblioteca = nomeBiblioteca.split("::")[0];
                    Biblioteca bibliotecaAlvo = gestaoBiblioteca.pesquisarProNome(nomeBiblioteca);

                    request.getSession().setAttribute("bibliotecaAlvo", bibliotecaAlvo);
                    
                    Long pessoaId = (Long) request.getSession().getAttribute("pessoaId");
                    Pessoa pessoaAlvo = gestaoPessoas.pesquisarPorId(pessoaId);
                    request.getSession().setAttribute("pessoaDona", pessoaAlvo);
                    
                    if(obraAlvo.isEmpty()){
                        request.setAttribute("nomeObra", nomeObra);
                        jsp = "/core/aquisicoes/criarAquisicaoLeitor.jsp";
                    }
                    else{
                        request.setAttribute("obras", obraAlvo);
                        jsp="/core/aquisicoes/pedir-passo2.jsp";
                    }
                    
                    break;
                    
                case "segundo":
                    Pessoa pessoa = (Pessoa) request.getSession().getAttribute("pessoaDona");
                    Biblioteca biblioteca = (Biblioteca) request.getSession().getAttribute("bibliotecaAlvo");
                    Obra obra = (Obra) request.getSession().getAttribute("obraAlvo");
                    Aquisicao aquisicao = new Aquisicao(biblioteca, pessoa, null, null, AquisicaoStatus.PENDENTE, obra);
                    gestaoAquisicao.cadastrarAquisicao(aquisicao);
                    jsp = "";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String gravarAquisicaoBibliotecario(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoPessoasService gestaoPessoa = new GestaoPessoasService();
            GestaoObras gestaoObra = new GestaoObras();
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            GestaoFornecedoresService gestaoFornecedor = new GestaoFornecedoresService();
            
            String etapa = request.getParameter("etapa");
            
            switch(etapa){
                case "primeiro":
                    String nomeObra = request.getParameter("nomeObra");
                    List<Obra> obrasAlvo = gestaoObra.pesquisarObraNome(nomeObra);
                    if(obrasAlvo.isEmpty()){
                        jsp = "/core/aquisicoes/pedir-passo2-none.jsp";
                    }
                    else{
                        request.setAttribute("obras", obrasAlvo);
                        request.getSession().setAttribute("pessoaDona", null);
                        request.getSession().setAttribute("idAquisicaoAtual", null);
                        jsp= "/core/aquisicoes/pedir-passo2.jsp";
                    }
                    break;
                case "segundo":
                    Long idObra = Long.parseLong(request.getParameter("obraId"));
                    Obra obraAlvo = gestaoObra.pesquisarObraID(idObra);
                    request.getSession().setAttribute("obraAlvo", obraAlvo);
                    
                    Pessoa pessoaAlvo = (Pessoa) request.getSession().getAttribute("pessoaDona");
                    
                    if(pessoaAlvo != null){
                        jsp = gravarPendente(request);
                        break;
                    }
                    
                    jsp= "/core/aquisicoes/pedir-passo3.jsp";
                    break;
                    
                case "terceiro":
                    Long id = (Long) request.getSession().getAttribute("idAquisicaoAtual");
                    if(id==null){
                        Obra obraAlvo1 = (Obra) request.getSession().getAttribute("obraAlvo");
                        Long quantidade = Long.parseLong(request.getParameter("quantidade"));
                        
                        String nomeFornecedor = request.getParameter("fornecedor");
                        
                        Fornecedor fornecedorAlvo = gestaoFornecedor.pesquisarPorNome(nomeFornecedor);
                        
                        Long pessoaId = (Long) request.getSession().getAttribute("pessoaId");
                        Pessoa pessoaAlvo1 = gestaoPessoa.pesquisarPorId(pessoaId);
                        
                        //todo usar biblioteca do bibliotecário
                        Biblioteca biblioteca = null;
                        
                        Aquisicao novaAquisicao = new Aquisicao(biblioteca, pessoaAlvo1, quantidade, fornecedorAlvo, AquisicaoStatus.ATIVO, obraAlvo1);
                        gestaoAquisicao.cadastrarAquisicao(novaAquisicao);
                    }
                    else{
                        Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(id);
                        
                        String fornecedorNome = request.getParameter("fornecedor");
                        Fornecedor fornecedor = gestaoFornecedor.pesquisarPorNome(fornecedorNome);
                        
                        if(fornecedor == null){
                            String erro = "O Fornecedor indicado não foi encontrado.";
                            request.setAttribute("erro", erro);
                            jsp = "/core/erro.jsp";
                        }
                        else{
                            Long quantidade = Long.parseLong(request.getParameter("quantidade"));

                            aquisicao.setFornecedor(fornecedor);
                            aquisicao.setQuantidade(quantidade);
                            aquisicao.setStatus(AquisicaoStatus.ATIVO);
                            try{
                                gestaoAquisicao.alterarAquisicao(aquisicao);
                                jsp = listarPendentes(request);
                            } catch(PersistenciaException ex){
                                String erro = "Nao foi possivel efetuar o pedido dessa aquisição!";
                                request.setAttribute("erro", erro);
                                jsp = "/core/erro.jsp";
                            }
                        }
                    }
                    break;
            }
        } catch (NegocioException ne){
            for(String erro : ne.getMessages()){
                System.out.println("ERRO:" + erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String gravarFinalizado(HttpServletRequest request) {
        String jsp = "";
        try {
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            aquisicao.setStatus(AquisicaoStatus.FINALIZADA);

            try{
                gestaoAquisicao.alterarAquisicao(aquisicao);
                jsp = listarAtivos(request);
            } catch(PersistenciaException ex){
                String erro = "Nao foi possivel efetuar o finalização dessa aquisição!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String recusar(HttpServletRequest request) {
        String jsp = "";
        try {
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            try{
                gestaoAquisicao.excluirAquisicao(aquisicao);
                jsp = listarPendentes(request);
            } catch(PersistenciaException ex){
                String erro = "Ocorreu erro ao Recusar Aquisicao!";
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
