package sgab.model.dto;

import sgab.model.dto.util.AquisicaoStatus;
import sgab.model.dto.Pessoa;
import sgab.model.dto.Fornecedor;
import sgab.model.dto.Obra;


public class Aquisicao {
    private Pessoa pessoa;
    private Long quantidade;
    private Fornecedor fornecedor;
    private AquisicaoStatus status;
    private Obra obra;
    private Long id;

    //construtor 
    public Aquisicao(Pessoa pessoa, Long quantidade, Fornecedor fornecedor, AquisicaoStatus status, Obra obra){
        this.pessoa = pessoa;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.status = status;
        this.obra = obra;
    }

    //get e set id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //get e set pessoa
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    //get e set quantidade
    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    //get e set fornecedor
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    //get e set status
    public AquisicaoStatus getStatus() {
        return status;
    }

    public void setStatus(AquisicaoStatus status) {
        this.status = status;
    }
    //get e set obra
    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }
}
