package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import static sgab.controller.PessoaController.listar;

import sgab.model.dto.Pessoa;
import sgab.model.exception.NegocioException;
import sgab.model.service.GestaoLeitor;

public class LeitorController {
    public static String cadastrar(HttpServletRequest request) {
        String jsp = "";
        try {
            String login = request.getParameter("login");
            Long cpf = Long.parseLong(request.getParameter("cpf"));
            String nomeCompleto = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            Pessoa pessoa = new Pessoa(cpf, login, nomeCompleto, email, senha);

            GestaoLeitor gestaoPessoasService = new GestaoLeitor();
            Long pessoaId = gestaoPessoasService.cadastrar(pessoa);

            if (pessoaId != null) {
                jsp = listar(request);
            } else {
                String erro = "Nao foi possível gravar esse registro!";
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

