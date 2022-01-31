package sgab.model.dto.util;

import sgab.model.dto.Reserva;
import java.util.List;
import java.util.LinkedList;

public class ReservaHelper {
    
    public static List<String> validarReserva(Reserva reserva){
        List<String> erros = new LinkedList<>();

        if(reserva == null){
            erros.add("Reserva não pode ser null");
        }
        else{
            if ((reserva.getPessoa() == null))
                erros.add("Obrigatório informar a pessoa.");
            if ((reserva.getLocalReserva() == null))
                erros.add("Obrigatório informar o local.");
            if ((reserva.getExemplar() == null) || reserva.getExemplar().size < 0)
                erros.add("Obrigatorio informar o exemplar.");
            if((reserva.getId() == null) || reserva.getId() < 0)
                erros.add("Obrigatorio informar o id.");
        }
        return erros;
    }
}
