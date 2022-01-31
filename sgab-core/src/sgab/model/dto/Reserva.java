package sgab.model.dto;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import sgab.model.dto.Exemplar;
import java.util.ArrayList;

public class Reserva {
    private Long id;
    private Pessoa pessoa;
    private Obra obra;
    private Biblioteca localReserva; 
    private ArrayList<Exemplar> exemplares;
    private final String horario;
    
    
    //construtor 
    public Reserva(Pessoa pessoa, Obra obra, Biblioteca localReserva, ArrayList<Exemplar> exemplares){
        this.pessoa = pessoa;
        this.obra = obra;
        this.localReserva = localReserva;
        this.exemplares =  new ArrayList<>(exemplares);

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        
        this.horario = dateFormat.format(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Obra getObra() {
        return obra;
    }
    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Biblioteca getLocalReserva() {
        return localReserva;
    }
    public void setLocalReserva(Biblioteca localReserva) {
        this.localReserva = localReserva;
    }

    public ArrayList getExemplares() {
        return this.exemplares;
    }
    public void setExemplar(Exemplar exemplar) {
        if (!exemplares.contains(exemplar))
            this.exemplares.add(exemplar);
    }

    public void setExemplares(ArrayList<Exemplar> exemplares) {
        this.exemplares =  new ArrayList<>(exemplares);
    }

    public String getHorario() {
        return horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
