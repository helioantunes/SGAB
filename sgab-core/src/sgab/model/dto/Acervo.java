package sgab.model.dto;

public class Acervo {
    private String nome;
    private Long id;
    private boolean obraRestaurada;
    private boolean obraDanificada;
    private boolean obraDesativada;
    private Obra obraConsultada;
    private boolean obraEmprestada;

    public boolean isObraRestaurada() {
        return obraRestaurada;
    }

    public void setObraRestaurada(boolean obraRestaurada) {
        this.obraRestaurada = obraRestaurada;
    }

    public boolean isObraDanificada() {
        return obraDanificada;
    }

    public void setObraDanificada(boolean obraDanificada) {
        this.obraDanificada = obraDanificada;
    }

    public boolean isObraDesativada() {
        return obraDesativada;
    }

    public void setObraDesativada(boolean obraDesativada) {
        this.obraDesativada = obraDesativada;
    }

    public Obra getObraConsultada() {
        return obraConsultada;
    }

    public void setObraConsultada(Obra obraConsultada) {
        this.obraConsultada = obraConsultada;
    }

    public boolean isObraEmprestada() {
        return obraEmprestada;
    }

    public void setObraEmprestada(boolean obraEmprestada) {
        this.obraEmprestada = obraEmprestada;
    }
    
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

}
