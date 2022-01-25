package sgab.model.dto;

import sgab.model.dto.util.PessoaTipo;
import java.util.ArrayList;
public class Pessoa {
    
    private Long id;
    private final String login;
    private final Long cpf;
    private String nome;
    private String email;
    private String senha;
    private boolean habilitado;
    private ArrayList<PessoaTipo> tipo = new ArrayList<PessoaTipo>();

    public Pessoa(String login, Long cpf){
        this.login = login;
        this.cpf = cpf;
        this.habilitado = true;
    }

    public Pessoa(Long cpf, String login, String nome, String email, String senha){
        this.cpf = cpf;
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.habilitado = true;
    }
    
    public ArrayList getTipo(){
        return this.tipo;
    }

    public void setTipo(PessoaTipo tipo) {
        this.tipo.add(tipo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }    

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    public boolean getHabilitado() {
        return habilitado;
    }

}
