/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sgab.model.dao;

/**
 *
 * @author luisa
 */
public interface FornecedoresDAO {
    void CadastrarFornecedor(Long cnpj, String nomeFornecedor, String email, Long telefone, Long cep, String endereco);
    void AlterarDados(Long cnpj, String nomeFornecedor, String email, Long telefone, Long cep, String endereco);
    void CancelarFornecedor(Long cnpj);
    
}
