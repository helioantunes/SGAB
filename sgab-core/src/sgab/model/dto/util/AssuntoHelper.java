package sgab.model.dto.util;//validação dos dados inseridos pelo usuário

import java.util.ArrayList;
import sgab.model.dto.Assunto;

/**
 *
 * @author Yuri
 */

public class AssuntoHelper {

    public static int validarAssunto(Assunto assunto, ArrayList<Assunto> assuntoLista) {
        if (assuntoLista.contains(assunto)) {
            return 1;
        }
        if(assunto == null) {
            return 2;
        }
        return 0;
    }
}