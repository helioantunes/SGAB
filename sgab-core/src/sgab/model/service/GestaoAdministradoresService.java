package sgab.model.service;

import java.util.List;
import sgab.model.dao.PessoasDAO;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.PessoaTipo;
import sgab.model.dto.util.PessoaHelper;
import sgab.model.dto.util.AdministradoresHelper;
import java.util.LinkedList;
import sgab.model.exception.NegocioException;

public class GestaoAdministradoresService {
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
    
    public List<Pessoa> pesquisarAdministradoresAtivos() {
        List<Pessoa> pessoas = pessoasDAO.listarAtivos();
        List<Pessoa> administradores = new LinkedList<>();
        for(int i=0;i<pessoas.size();i++){
            Pessoa pessoa = pessoas.remove(i);
            if(pessoa.getTipo()!=PessoaTipo.ADMINISTRADOR){
                administradores.add(pessoa);
            }
        }
        return administradores;
    }
    
    public Pessoa pesquisarAdministradoresPorId(Long id){
        Pessoa pessoa = pessoasDAO.pesquisar(id);
        if(pessoa.getTipo()!=PessoaTipo.ADMINISTRADOR){
            return pessoa;
        }
        else{
            return null;
        }
    }
    
    public Pessoa pesquisarAdministradoresPorConta(String login, String senha){
        
        Pessoa result = pessoasDAO.pesquisarLoginSenha(login, senha);
        if(result.getTipo()!=PessoaTipo.ADMINISTRADOR){
            return result;
        }
        else{
            return null;
        }             
    }

    public Pessoa pesquisarAdministradoresPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        if(result.getTipo()!=PessoaTipo.ADMINISTRADOR){
            return result;
        }
        else{
            return null;
        } 
    }
    
    public List<Pessoa> pesquisarGestorAtivos() {
        List<Pessoa> pessoas = pessoasDAO.listarAtivos();
        List<Pessoa> gestores = new LinkedList<>();
        for(int i=0; i<pessoas.size(); i++){
            Pessoa pessoa = pessoas.remove(i);
            if(pessoa.getTipo()!=PessoaTipo.GESTOR){
                gestores.add(pessoa);
            }
        }
        return gestores;
    }

    public Pessoa pesquisarGestorPorId(Long id){
        Pessoa pessoa = pessoasDAO.pesquisar(id);
        if(pessoa.getTipo()!=PessoaTipo.GESTOR){
            return pessoa;
        }
        else{
            return null;
        }
    }   

    public Pessoa pesquisarGestorConta(String login, String senha){
        
        Pessoa result = pessoasDAO.pesquisarLoginSenha(login, senha);
        if(result.getTipo()!=PessoaTipo.GESTOR){
            return result;
        }
        else{
            return null;
        }                   
    }

    public Pessoa pesquisarGestorPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        if(result.getTipo()!=PessoaTipo.GESTOR){
            return result;
        }
        else{
            return null;
        } 
    }

    public void alterarGestor(Pessoa pessoa){
        List<String> exMsgs = AdministradorHelper.validarGestorAlteracao(pessoa, pessoasDAO);
        
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

