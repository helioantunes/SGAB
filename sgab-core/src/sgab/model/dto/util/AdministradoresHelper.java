package sgab.model.dto.util;

import sgab.model.dao.PessoasDAO;
import sgab.model.dto.Pessoa;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdministradoresHelper {
    public static List<String> validarAdministrador(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarPessoa(pessoa,pessoas);
        if(pessoa.getTipo()!=PessoaTipo.ADMINISTRADOR){
            mensagens.add("Pessoa não é um administrador!");
        }
        return mensagens;
    }
    public static List<String> validarAdministradorAlteracao(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarAlteracao(pessoa,pessoas);
        if(pessoa.getTipo()!=PessoaTipo.ADMINISTRADOR){
            mensagens.add("Pessoa não é um administrador!");
        }
        return mensagens;
    }
    public static List<String> validarGestor(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarPessoa(pessoa,pessoas);
        if(pessoa.getTipo()!=PessoaTipo.GESTOR){
            mensagens.add("Pessoa não é um gestor!");
        }
        return mensagens;
    }
    public static List<String> validarGestorAlteracao(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarAlteracao(pessoa,pessoas);
        if(pessoa.getTipo()!=PessoaTipo.GESTOR){
            mensagens.add("Pessoa não é um gestor!");
        }
        return mensagens;
    }
}
