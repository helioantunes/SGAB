package sgab.model.service;

import sgab.model.dto.Pessoa;
import sgab.model.dto.util.LeitorHelper;
import sgab.model.dto.util.PessoaHelper;
import sgab.model.dto.util.PessoaTipo;
import sgab.model.exception.NegocioException;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dao.PessoasDAO;


public class GestaoLeitor extends GestaoPessoasService { 
    private PessoasDAO pessoasDAO = PessoasDAO.getInstance();

    public Long cadastrarLeitor(Pessoa pessoa){
        pessoa.setTipo(PessoaTipo.LEITOR);
        List<String> exMsgs = LeitorHelper.validarLeitor(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        pessoasDAO.inserir(pessoa);
        return pessoa.getId();
    }
    public void cadastrou(){
      List<Pessoa> a = pessoasDAO.listarTodos();
      for (int i = 0; i < a.size(); i++) {
        if(a.get(i).getTipo() == PessoaTipo.LEITOR){
          System.out.println(a.get(i).getEmail());
        }
      }
    }


}