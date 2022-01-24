package sgab.model.dto;

import sgab.model.dto.util.PessoaTipo;
public class Pessoa {
    
    private Long id;
    private final String Login;
    private final Long cpf;
    private String nome;
    private String email;
    private String senha;
    private boolean habilitado;
    private PessoaTipo tipo;

    public Pessoa(String login, Long cpf){
        this.Login = login;
        this.cpf = cpf;
        this.habilitado = true;
        this.tipo = null; 
    }

    public Pessoa(Long cpf, String login, String nome, String email, String senha){
        this.cpf = cpf;
        this.Login = login;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.habilitado = true;
        this.tipo = null;
    }
    
    public PessoaTipo getTipo() {
        return tipo;
    }

    public void setTipo(PessoaTipo tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
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
