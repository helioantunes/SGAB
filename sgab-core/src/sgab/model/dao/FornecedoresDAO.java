/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sgab.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Fornecedor;
import sgab.model.dto.util.FornecedorHelper;
import sgab.model.exception.PersistenciaException;

/**
 *
 * @author luisa
 */
public class FornecedoresDAO implements GenericDAO<Fornecedor, Long> {
    
    private Map<Long, Fornecedor> table = new HashMap<>();
    
    private FornecedoresDAO() { }
    
    private static FornecedoresDAO fornecedorDAO;
    static {
        FornecedoresDAO.fornecedorDAO = null;
    }
    
    public static FornecedoresDAO getInstance() {
        
        if (fornecedorDAO == null)
            fornecedorDAO = new FornecedoresDAO();
        
        return fornecedorDAO;
    }
    
    @Override
    public void inserir(Fornecedor entidade) {
        if (this.pesquisar(entidade.getCnpj()) != null)
            throw new PersistenciaException("'" + entidade.getCnpj() + "' é único.");
        
        table.put(entidade.getCnpj(), entidade);
    }

    @Override
    public void alterar(Fornecedor entidade) {
        Fornecedor fornecedor = table.remove(entidade.getCnpj());
        if (fornecedor == null)
            throw new PersistenciaException("Nenhum fornecedor com " + "o cnpj '" + entidade.getCnpj() + "'.");
        
        inserir(entidade);
    }

    @Override
    public Fornecedor pesquisar(Long cnpj) {
        return table.get(cnpj);
    }
    
    public Fornecedor pesquisar(String nome) {
        for (Long key : table.keySet()) {
            if(nome.equals(table.get(key).getNomeFornecedor()))
                return table.get(key);
        }
        return null;
    }

    @Override
    public List<Fornecedor> pesquisar(List<BasicPair<Long, Fornecedor>> parameterList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
