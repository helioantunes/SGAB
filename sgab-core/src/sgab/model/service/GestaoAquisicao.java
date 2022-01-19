package sgab.model.service;

import java.util.List;
import java.util.List;
import sgab.model.dto.util.AquisicaoHelper;
import sgab.model.dto.Aquisicao;
import sgab.model.dao.AquisicaoDAO;
import sgab.model.dto.util.AquisicaoStatus;
import sgab.model.exception.NegocioException;

/**
 *
 * @author iulli
 */
public class GestaoAquisicao {
    private AquisicaoDAO aquisicaoDAO;
    
    public GestaoAquisicao (){
        aquisicaoDAO = aquisicaoDAO.getInstance();
    }
    
    public Long cadastrarAquisicao(Aquisicao aquisicao){
        List<String> erros = AquisicaoHelper.validarAquisicao(aquisicao);
        if(!erros.isEmpty()){
            throw new NegocioException(erros);
        }
        
        aquisicaoDAO.inserir(aquisicao);
        return aquisicao.getId();
    }
    
    public void alterarAquisicao(Aquisicao aquisicao){
        List<String> erros = AquisicaoHelper.validarAquisicao(aquisicao);
        if(!erros.isEmpty()){
            throw new NegocioException(erros);
        }
        
        aquisicaoDAO.alterar(aquisicao);
    }
    
    public Aquisicao pesquisarAquisicao(Long key){
        return aquisicaoDAO.pesquisar(key);
    }
    
    public List<Aquisicao> listarAquisicoes(){
        return aquisicaoDAO.listarAquisicoes();
    }
    
    public List<Aquisicao> aquisicoesFinalizada(){
        return aquisicaoDAO.aquisicoesAtivas(); 
    }
    
    public List<Aquisicao> aquisicoesAtivas(){
        return aquisicaoDAO.aquisicoesAtivas();
    }
    
    public List<Aquisicao> aquisicoesPendente(){
        return aquisicaoDAO.aquisicoesPendentes();
    }
    
    public void excluirAquisicao(Aquisicao aquisicao){
        Aquisicao aqui = aquisicaoDAO.pesquisar(aquisicao.getId());
        if(aqui.getStatus() != AquisicaoStatus.PENDENTE){
            throw new NegocioException("Aquisição não pendente");
        }
        
        else{
            if(aqui == null){
                throw new NegocioException("Aquisicao 'id=" + aqui.getId() + "'não encontrado!");
            }
            
            aqui.setStatus(AquisicaoStatus.CANCELADO);
        }
    }
    
    public List pesquisarAquisicao(List parameterList){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
