package sgab.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/main"})
public class Main extends HttpServlet {
    private String jsp = "";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");

        switch (acao) {
            case "Logar":
                jsp = LoginController.logar(request);
                break;
            case "AssuntoListar":
                jsp = AssuntoController.listar(request);
                break;
            case "AssuntoAlterar":
                jsp = AssuntoController.alterar(request);
                break;
            case "AssuntoGravarAlteracao":
                jsp = AssuntoController.gravarAlteracao(request);
                break;
            case "AssuntoGravarInsercao":
                jsp = AssuntoController.gravarInsercao(request);
                break;           
            case "AssuntoExcluir":
                jsp = AssuntoController.excluir(request);
                break;
            case "UsuarioListar":
                jsp = UsuarioController.listar(request);
                break;
            case "UsuarioAlterar":
                jsp = UsuarioController.alterar(request);
                break;
            case "UsuarioGravarAlteracao":
                jsp = UsuarioController.gravarAlteracao(request);
                break;
            case "UsuarioGravarInsercao":
                jsp = UsuarioController.gravarInsercao(request);
                break;           
            case "UsuarioExcluir":
                jsp = UsuarioController.excluir(request);
                break;
            case "ObraListar":
                jsp = ObraController.listar(request);
                break;
            case "ObraPesquisar":
                jsp = ObraController.pesquisar(request);
                break;
            case "ObraGravarInsercao":
                jsp = ObraController.gravarInsercao(request);
                break;
            case "ObraAlterar":
                jsp = ObraController.alterar(request);
                break;
            case "ObraGravarAlteracao":
                jsp = ObraController.gravarAlteracao(request);
                break;
            case "ObraExcluir":
                jsp = ObraController.excluir(request);
                break;                               
            case "PessoaPesquisar":
                jsp = PessoaController.pesquisarLogin(request);
                break;
            case "PessoaListar":
                jsp = PessoaController.listar(request);
                break;
            case "PessoaAlterar":
                jsp = PessoaController.alterar(request);
                break;
            case "PessoaGravarAlteracao":
                jsp = PessoaController.gravarAlteracao(request);
                break;
            case "PessoaGravarInsercao":
                jsp = PessoaController.gravarInsercao(request);
                break;
            case "PessoaExcluir":
                jsp = PessoaController.excluir(request);
            case "UnidadeOrganizacionalListar":
                jsp = UnidadeOrganizacionalController.listar(request);
                break;
            case "UnidadeOrganizacionalAlterar":
                jsp = UnidadeOrganizacionalController.alterar(request);
                break;
            case "UnidadeOrganizacionalGravarAlteracao":
                jsp = UnidadeOrganizacionalController.gravarAlteracao(request);
                break;
            case "UnidadeOrganizacionalGravarInsercao":
                jsp = UnidadeOrganizacionalController.gravarInsercao(request);
                break;           
            case "UnidadeOrganizacionalExcluir":
                jsp = UnidadeOrganizacionalController.excluir(request);
                break;
            case "AutorCadastrar":
                jsp = AutorController.insercao(request);
                break;
            case "AutorAlterar":
                jsp = AutorController.alterar(request);
                break;
             case "AutorPesquisar":
                jsp = AutorController.pesquisar(request);
                break;
            case "AutorExcluir":
                jsp = AutorController.excluir(request);
                break;  
            case "FornecedorListar":
                jsp = FornecedorController.listar(request);
                break;
            case "FornecedorAlterar":
                jsp = FornecedorController.alterar(request);
                break;
            case "FornecedorGravarAlteracao":
                jsp = FornecedorController.gravarAlteracao(request);
                break;
            case "FornecedorGravarInsercao":
                jsp = FornecedorController.gravarInsercao(request);
                break;
            case "FornecedorExcluir":
                jsp = FornecedorController.excluir(request);
                break;
            case "BibliotecaListar":
                jsp = BibliotecaController.listar(request);
                break;
            case "BibliotecaAlterar":
                jsp = BibliotecaController.alterar(request);
                break;
            case "BibliotecaGravarAlteracao":
                jsp = BibliotecaController.gravarAlteracao(request);
                break;
            case "BibliotecaGravarInsercao":
                jsp = BibliotecaController.gravarInsercao(request);
                break;
            case "BibliotecaExcluir":
                jsp = BibliotecaController.excluir(request);
                break;                
        }

        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }    
}
