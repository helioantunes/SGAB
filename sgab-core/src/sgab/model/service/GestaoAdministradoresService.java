package sgab.model.service;

import java.util.List;
import sgab.model.dao.PessoasDAO;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.PessoaTipo;
import sgab.model.dto.util.PessoaHelper;
import sgab.model.dto.util.AdministradoresHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import sgab.model.exception.NegocioException;

public class GestaoAdministradoresService{
    private final PessoasDAO pessoasDAO;

    public GestaoAdministradoresService() {
        pessoasDAO = PessoasDAO.getInstance();
    }

    public Long cadastrarAdministrador(Pessoa pessoa) {
        pessoa.setTipo(PessoaTipo.ADMINISTRADOR);
        List<String> exMsgs = PessoaHelper.validarPessoa(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        pessoasDAO.inserir(pessoa);
        return pessoa.getId();
    }
    
    public Long cadastrarGestor(Pessoa pessoa) {
        pessoa.setTipo(PessoaTipo.GESTOR);
        List<String> exMsgs = PessoaHelper.validarPessoa(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        pessoasDAO.inserir(pessoa);
        return pessoa.getId();
    }
    
    public List<Pessoa> pesquisarGestorAtivos() {
        List<Pessoa> pessoas = pessoasDAO.listarAtivos();
        List<Pessoa> gestores = new LinkedList<>();
        for(long i = 1; i <= pessoas.size(); i++){
            Pessoa pessoa = pessoasDAO.pesquisar(i);
            ArrayList<PessoaTipo> tipos = pessoa.getTipo();
            for(PessoaTipo tipo : tipos){
              if(tipo == PessoaTipo.GESTOR){
                gestores.add(pessoa);
             }  
          }
        }
        return gestores;
    }
    
     public List<Pessoa> pesquisarAdministradoresAtivos() {
        List<Pessoa> pessoas = pessoasDAO.listarAtivos();
        List<Pessoa> administradores = new LinkedList<>();
        for(long i = 1; i <= pessoas.size(); i++){
            Pessoa pessoa = pessoasDAO.pesquisar(i);
            ArrayList<PessoaTipo> tipos = pessoa.getTipo();
            for(PessoaTipo tipo : tipos){
              if(tipo == PessoaTipo.ADMINISTRADOR){
                administradores.add(pessoa);
             }  
          }
        }
        return administradores;
    }
     
    public Pessoa pesquisarAdministradoresPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        ArrayList<PessoaTipo> tipos = result.getTipo();
        for(PessoaTipo tipo : tipos ){
          if(tipo == PessoaTipo.ADMINISTRADOR){
            return result;            
          }
          else{
            return null;
          } 
        }
        return null;
    }
    
    public Pessoa pesquisarGestorPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        ArrayList<PessoaTipo> tipos = result.getTipo();
        for(PessoaTipo tipo : tipos ){
          if(tipo == PessoaTipo.GESTOR){
            return result;            
          }
          else{
            return null;
          } 
        }
        return null;
    }

    public void alterarGestor(Pessoa pessoa){
        List<String> exMsgs = AdministradoresHelper.validarGestorAlteracao(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        pessoasDAO.alterar(pessoa);
    }
    
    public void alterarAdministrador(Pessoa pessoa){
        List<String> exMsgs =  AdministradoresHelper.validarAdministradorAlteracao(pessoa, pessoasDAO);
            
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        pessoasDAO.alterar(pessoa);
    }

    public void excluir(Pessoa pessoa){
        pessoasDAO.delete(pessoa.getId());    
    }   
    
   

}

