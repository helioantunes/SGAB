
package sgab.model.dto.util;

import sgab.model.dto.UnidadeOrganizacional;

public class UnidadeOrganizacionalHelper {
    
    public static boolean validar(UnidadeOrganizacional uOrg){

        if (uOrg == null)
            return false;
        
        if (uOrg.getNome() == null || uOrg.getNome().length() == 0)
            return false; 
        
        if (uOrg.getEndereco() == null || uOrg.getEndereco().length() == 0)
            return false;         

        return true;
    }
}