package sgab.model.dto.util;
import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Fornecedor;

public class FornecedorHelper{   
    public static List<String> validar(Fornecedor fornecedor) {
        List<String> exMsgs = new LinkedList<>();
        
        
        if (fornecedor.getCnpj() == null)
            exMsgs.add("Cnpj não pode ser null");
        else {
            if ((fornecedor.getNomeFornecedor() == null) || fornecedor.getNomeFornecedor().isEmpty())
                exMsgs.add("Obrigatório informar o nome completo do usuário.");
            else if (fornecedor.getNomeFornecedor().split(" ").length < 2)
                exMsgs.add("Nome completo do usuario deve ter pelo menos duas palavras.");

            if ((fornecedor.getEmail() == null) || fornecedor.getEmail().isEmpty())
                exMsgs.add("Obrigatório informar o email do usuário.");
            else if (!(fornecedor.getEmail().contains("@") && fornecedor.getEmail().contains(".")))
                exMsgs.add("Email não é válido.");  

            if ((fornecedor.getEmail() == null) || fornecedor.getEmail().isEmpty())
                exMsgs.add("Obrigatório informar o email do usuário.");
            else if (!(fornecedor.getEmail().contains("@") && fornecedor.getEmail().contains(".")))
                exMsgs.add("Email não é válido.");   

            if ((fornecedor.getEmail() == null) || fornecedor.getEmail().isEmpty())
                exMsgs.add("Obrigatório informar o email do usuário.");
            else if (!(fornecedor.getEmail().contains("@") && fornecedor.getEmail().contains(".")))
                exMsgs.add("Email não é válido.");   
        }
           
        return exMsgs;
    }
}