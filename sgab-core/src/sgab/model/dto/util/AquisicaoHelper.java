package sgab.model.dto.util;

import sgab.model.dto.Aquisicao;
import java.util.List;
import java.util.LinkedList;

public class AquisicaoHelper {
    
    public static List<String> validarAquisicao(Aquisicao aquisicao){
        List<String> erros = new LinkedList<>();

        if(aquisicao == null){
            erros.add("Aquisição não pode ser null");
        }
        else{
            if ((aquisicao.getPessoa() == null))
                erros.add("Obrigatório informar a pessoa.");
            if ((aquisicao.getQuantidade() == null))
                erros.add("Obrigatório informar a quantidade.");
            else if(aquisicao.getQuantidade().intValue()<=0)
                erros.add("A quantidade deve ser maior que 0.");                  
            if ((aquisicao.getFornecedor() == null))
                erros.add("Obrigatório informar o fornecedor.");
            if ((aquisicao.getStatus() == null))
                erros.add("Obrigatório informar o status.");
            if ((aquisicao.getObra() == null))
                erros.add("Obrigatório informar a obra.");
            if ((aquisicao.getId() == null))
                erros.add("Obrigatório informar o id.");
            else if(aquisicao.getId().intValue()<=0)
                erros.add("O id deve ser maior que 0.");
        }
        return erros;
    }
}
