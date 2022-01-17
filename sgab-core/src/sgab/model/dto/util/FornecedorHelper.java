package sgab.model.dto.util;

import sgab.model.dto.Fornecedor;

public class FornecedorHelper{
    public static int validarFornecedor(Fornecedor fornecedor){
        
        if(fornecedor.getCnpj() == 0){

            return 1;

        }
        
        if(fornecedor.getNomeFornecedor() == null){

            return 2;

        }

        if(fornecedor.getEmail() == null){

            return 3;

        }

        if(fornecedor.getTelefone() == 0){

            return 4;

        }

        if(fornecedor.getCep() == 0){

            return 5;

        }
        
        if(fornecedor.getEndereco() == null){

            return 6;

        }

        return 0;
        
    }
}