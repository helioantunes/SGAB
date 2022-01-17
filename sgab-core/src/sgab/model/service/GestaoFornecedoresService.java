/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.model.service;

import java.util.ArrayList;
import sgab.model.dto.Fornecedor;
import sgab.model.dao.FornecedoresDAO;
import sgab.model.dto.util.FornecedorHelper;

/**
 *
 * @author T-Gamer
 */
public class GestaoFornecedoresService implements FornecedoresDAO {
    ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    
    @Override
    public void CadastrarFornecedor(Long cnpj, String nomeFornecedor, String email, Long telefone, Long cep, String endereco) {
        Fornecedor novoFornecedor = new Fornecedor(cnpj, nomeFornecedor, email, telefone, cep, endereco);
        
        switch(FornecedorHelper.validarFornecedor(novoFornecedor)){
            case 0:
                break;
            case 1:
                throw new RuntimeException("O cnpj do fornecedor está vazio.");
            case 2:
                throw new RuntimeException("O nome do fornecedor está vazio.");
            case 3:
                throw new RuntimeException("O email do fornecedor está vazio.");
            case 4:
                throw new RuntimeException("O telefone do fornecedor está vazio.");
            case 5:
                throw new RuntimeException("O cep do fornecedor está vazio.");
            case 6:
                throw new RuntimeException("O endereço do fornecedor está vazio.");
        }
        
        fornecedores.add(novoFornecedor);
    }
    
    public Fornecedor pesquisar(Long cnpj){
        for(Fornecedor fornecedor: fornecedores) {
            if(cnpj == fornecedor.getCnpj()) {
                return fornecedor;
            }
        }

        return null;
    }
    
    @Override
    public void AlterarDados(Long cnpj, String nomeFornecedor, String email, Long telefone, Long cep, String endereco) {
        Fornecedor fornecedor = pesquisar(cnpj);
        
        if(fornecedor == null){
            throw new RuntimeException("Esse cnpj não está cadastrado.");
        }
        
        fornecedor.setCep(cep);
        fornecedor.setEndereco(endereco);
        fornecedor.setNomeFornecedor(nomeFornecedor);
        fornecedor.setTelefone(telefone);
        fornecedor.setEmail(email);
        
    }
    
    @Override
    public void CancelarFornecedor(Long cnpj){
        Fornecedor fornecedor = pesquisar(cnpj);
        
        if(fornecedor == null){
            throw new RuntimeException("Esse cpf não está cadastrado.");
        }
        
        fornecedores.remove(fornecedor);
    }

}
