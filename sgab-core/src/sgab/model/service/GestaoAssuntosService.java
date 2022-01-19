package sgab.model.service;

import sgab.model.dto.Assunto;
import java.util.ArrayList;

public class GestaoAssuntosService {
    ArrayList<Assunto> assuntoLista = new ArrayList<>();

    public void adicionarAssunto(String nome){
        Assunto assunto = new Assunto(nome);
        if (assuntoLista.contains(getAssunto(nome))){
            throw new IllegalArgumentException("Erro: assunto já existente");
        }
        assuntoLista.add(assunto);
    }

    public Assunto getAssunto(String nome) {
        if (nome != null) {
            for (Assunto assunto : assuntoLista) {
                if (assunto.getNome().equals(nome)) {
                    return assunto;
                }
            }
            return null;
        }
        return null;
    }

    public Assunto getAssunto(long id) {
        if (id >= 0) {
            for (Assunto assunto : assuntoLista) {
                if (assunto.getId() == id) {
                    return assunto;
                }
            }
            return null;
        }
        return null;
    }

    public void removerAssunto (String nome) {
          if(assuntoLista == null) {
              throw new IllegalArgumentException("Não há nada registrado no banco de dados.");
          }
          else if(getAssunto(nome).equals(nome)){
              assuntoLista.remove(getAssunto(nome));
          }
            else {
              throw new IllegalArgumentException("Esse assunto já foi removido");
            }
         }

    public void editarAssunto(String oldNome, String newNome){
        Assunto assunto = this.getAssunto(oldNome);
        if(assunto != null){
            assunto.setNome(newNome);
        }
    }
}
