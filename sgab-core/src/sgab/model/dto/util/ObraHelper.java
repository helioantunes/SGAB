package sgab.model.dto.util;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Obra;

public class ObraHelper {
    
    public static List<String> validarObra(Obra obra){
        List<String> erros = new LinkedList<>();
        
        if(obra == null){
            erros.add("Obra não pode ser null.");
        }
        else{
            if ((obra.getCategoria() == null) || obra.getCategoria().isEmpty())
                erros.add("Obrigatório informar a categoria.");
            else if (obra.getCategoria().length() <=1){
                erros.add("Número de caracteres da categoria deve ser maior que 1.");
            }

            if ((obra.getTitulo() == null) || obra.getTitulo().isEmpty())
                erros.add("Obrigatório informar o título.");
            else if (obra.getTitulo().length() <=1){
                erros.add("Número de caracteres do título deve ser maior que 1.");
            }

            if ((obra.getEditora() == null) || obra.getEditora().isEmpty())
                erros.add("Obrigatório informar a editora.");
            else if (obra.getEditora().length() <=1){
                erros.add("Número de caracteres da editora deve ser maior que 1.");
            }

            if ((obra.getCidadeEditora() == null) || obra.getCidadeEditora().isEmpty())
                erros.add("Obrigatório informar a cidade da editora.");
            else if (obra.getCidadeEditora().length() <=1){
                erros.add("Número de caracteres da cidade da editora deve ser maior que 1.");
            }
            
            if ((obra.getEdicao() == null))
                erros.add("Obrigatório informar a edição.");
            else if (obra.getEdicao().intValue() <= 0){
                erros.add("A edicao da obra deve ser maior que 0.");
            }
            
            if ((obra.getVolume() == null))
                erros.add("Obrigatório informar o volume.");
            else if (obra.getVolume().intValue() <= 0){
                erros.add("O volume da obra deve ser maior que 0.");
            }

            if (obra.getAutor().isEmpty()){//implementar o metodo length em autores
                erros.add("A Obra deve ter algum Autor");
            }
            
            if (obra.getAssunto().isEmpty()){
                erros.add("A Obra deve ter algum Assunto");
            }
        }
        
        return erros;
    }
    
}