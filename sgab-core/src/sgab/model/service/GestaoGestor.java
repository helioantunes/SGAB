package sgab.model.service;

import sgab.model.dto.Pessoa;
import sgab.model.dto.util.GestorHelper;
import sgab.model.dto.util.PessoaHelper;
import sgab.model.dto.util.PessoaTipo;
import sgab.model.exception.NegocioException;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dao.PessoasDAO;

public class GestaoGestor extends GestaoPessoasService {

    private PessoasDAO pessoasDAO;

    public Long cadastrarBibliotecario(Pessoa pessoa) {
        pessoa.setTipo(PessoaTipo.BIBLIOTECARIO);
        List<String> exMsgs = GestorHelper.validarBibliotecario(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        pessoasDAO.inserir(pessoa);
        return pessoa.getId();
    }
    
    public Long cadastrarAtendente(Pessoa pessoa) {
        pessoa.setTipo(PessoaTipo.ATENDENTE);
        List<String> exMsgs = GestorHelper.validarAtendente(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        pessoasDAO.inserir(pessoa);
        return pessoa.getId();
    }

    
    public List<Pessoa> pesquisarBibliotecariosAtivos() {
        List<Pessoa> pessoas = pessoasDAO.listarAtivos();
        List<Pessoa> bibliotecarios = new LinkedList<>();
        for(int i=0;i<pessoas.size();i++){
            Pessoa pessoa = pessoas.remove(i);
            if(pessoa.getTipo().contains(PessoaTipo.BIBLIOTECARIO)){
                bibliotecarios.add(pessoa);
            }
        }
        return bibliotecarios;
    }

    public Pessoa pesquisarBibliotecariosPorId(Long id){
        Pessoa pessoa = pessoasDAO.pesquisar(id);
        if(pessoa.getTipo().contains(PessoaTipo.BIBLIOTECARIO)){
            return pessoa;
        }
        else{
            return null;
        }
    }   

    public Pessoa pesquisarBibliotecariosConta(String login, String senha){
        
        Pessoa result = pessoasDAO.pesquisarLoginSenha(login, senha);
        if(result.getTipo().contains(PessoaTipo.BIBLIOTECARIO)){
            return result;
        }
        else{
            return null;
        }             
    }

    public Pessoa pesquisarBibliotecariosPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        if(result.getTipo().contains(PessoaTipo.BIBLIOTECARIO)){
            return result;
        }
        else{
            return null;
        } 
    }


    public List<Pessoa> pesquisarAtendentesAtivos() {
        List<Pessoa> pessoas = pessoasDAO.listarAtivos();
        List<Pessoa> atendentes = new LinkedList<>();
        for(int i=0; i<pessoas.size(); i++){
            Pessoa pessoa = pessoas.remove(i);
            if(pessoa.getTipo().contains(PessoaTipo.ATENDENTE)){
                atendentes.add(pessoa);
            }
        }
        return atendentes;
    }

    public Pessoa pesquisarAtendentesPorId(Long id){
        Pessoa pessoa = pessoasDAO.pesquisar(id);
        if(pessoa.getTipo().contains(PessoaTipo.ATENDENTE)){
            return pessoa;
        }
        else{
            return null;
        }
    }   

    public Pessoa pesquisarAtendentesConta(String login, String senha){
        
        Pessoa result = pessoasDAO.pesquisarLoginSenha(login, senha);
        if(result.getTipo().contains(PessoaTipo.ATENDENTE)){
            return result;
        }
        else{
            return null;
        }                   
    }

    public Pessoa pesquisarAtendentesPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        if(result.getTipo().contains(PessoaTipo.ATENDENTE)){
            return result;
        }
        else{
            return null;
        } 
    }


    public void alterarAtendente(Pessoa pessoa){
        List<String> exMsgs =  GestorHelper.validarAtendenteAlteracao(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        pessoasDAO.alterar(pessoa);
    }

    public void alterarBibliotecario(Pessoa pessoa){
        List<String> exMsgs =  GestorHelper.validarBibliotecarioAlteracao(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        pessoasDAO.alterar(pessoa);
    }
}    

