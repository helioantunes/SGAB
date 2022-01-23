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
import sgab.model.exception.PersistenciaException;

public class AquisicaoController {
    public static String pedir(HttpServletRequest request) {
        String jsp = "";
        try {
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            if(aquisicao != null){
                request.setAttribute("aquisicao", aquisicao);
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

    public static String gravarAtivo(HttpServletRequest request) {
        String jsp = "";
        try {
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            Long quantidade = Long.parseLong(request.getParameter("quantidade"));
            String fornecedorNome = request.getParameter("nomeFornecedor");
            GestaoFornecedoresService gestaoFornecedoresService = new GestaoFornecedoresService();
            Fornecedor fornecedor = gestaoFornecedoresService.pesquisarPorNome(fornecedorNome);

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
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String gravarPendente(HttpServletRequest request) {
        String jsp = "";
        try {
            Long pessoaId = Long.parseLong(request.getParameter("pessoaId"));
            GestaoPessoasService gestaoPessoasService = new GestaoPessoasService();
            Pessoa pessoa = gestaoPessoasService.pesquisarPorId(pessoaId);
            Long obraId = Long.parseLong(request.getParameter("obraId"));
            GestaoObras manterObra = new GestaoObras();
            Obra obra = manterObra.pesquisarObraID(obraId);
            if(pessoa != null && obra != null){
                Aquisicao aquisicao = new Aquisicao(pessoa, null, null, AquisicaoStatus.PENDENTE, obra);
                GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
                gestaoAquisicao.cadastrarAquisicao(aquisicao);
                jsp = "/core/menu.jsp";
            } else {
                String erro = "Nao foi possível gravar esse pedido de aquisicao!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
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
