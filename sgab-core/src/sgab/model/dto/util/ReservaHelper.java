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
                erros.add("Pessoa vaiza.");
            if ((reserva.getExemplar() == null))
                erros.add("Obrigatorio informar o exemplar.");
        }
        return erros;
    }
}
