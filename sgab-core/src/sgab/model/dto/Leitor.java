package sgab.model.dto;

/**
 * GRUPO F
 * @author luisf
 */

import sgab.model.dto.util.PessoaTipo;
public class Leitor extends Pessoa {

    private LeitorTipo tipo;
    
    public LeitorTipo getTipo() {
        return tipo;
    }

    public void setTipo(LeitorTipo tipo) {
        this.tipo = tipo;
    }

}
