package sgab.model.dto;

import sgab.model.dto.util.ExemplarStatus;
import sgab.model.dto.util.ExemplarTipo;


public class Exemplar {
    private Obra obra;
    private Long id;
    private ExemplarStatus status;
    private ExemplarTipo tipo;

    public Exemplar(Obra obra, Long id) {
        this.obra = obra;
        this.id = id;
    }

    public Obra getObra() {
        return obra;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public ExemplarStatus getStatus() {
        return status;
    }

    public ExemplarTipo getTipo() {
        return tipo;
    }

    public void setStatus(ExemplarStatus status) {
        this.status = status;
    }

    public void setTipo(ExemplarTipo tipo) {
        this.tipo = tipo;
    }
}
