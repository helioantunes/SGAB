package sgab.model.dao;

import sgab.model.dto.Assunto;

public interface GestaoDeAssuntosDAO {
    Assunto getAssunto(String nome); // pesquisa por nome
    Assunto getAssunto(long id); // pesquisa por id
    //
    void adcionarAssunto(String nome);
    void removerAssunto(long id); // remover pelo id
    void removerAssunto(String nome); // remover pelo nome
    void editarAssunto(String assunto, String assuntoNovo); // editar o assunto
}