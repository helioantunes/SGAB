package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import sgab.model.exception.NegocioException;
import sgab.model.exception.PersistenciaException;


public class ReservaController {
    public static String reservar(HttpServletRequest request){
        String jsp = "";
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
