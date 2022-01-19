package sgab.model.dto.util;

import sgab.model.dao.PessoasDAO;
import sgab.model.dto.Pessoa;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeitorHelper extends PessoaHelper {

  public static List<String> validarLeitor(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarPessoa(pessoa,pessoas);
        if(pessoa.getTipo()!=PessoaTipo.LEITOR){
            mensagens.add("Pessoa não é um leitor!");
        }
        return mensagens;
  }
}

