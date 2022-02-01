
package sgab.model.service;

import java.util.List;
import sgab.model.exception.NegocioException;
import sgab.model.dto.Reserva;
import sgab.model.dao.ReservaDAO;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.Obra;
import sgab.model.dto.util.ReservaHelper;

public class GestaoReservaService {
    
    private ReservaDAO reservaDAO;
    
    public Long cadastrar(Reserva reserva) {
        List<String> exMsgs = ReservaHelper.validarReserva(reserva);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        reservaDAO.inserir(reserva);
        return reserva.getId();
    }
   
    public void atualizar(Reserva reserva) {
        
        List<String> exMsgs = ReservaHelper.validarReserva(reserva);
        
        if(!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        reservaDAO.alterar(reserva);
    }
   
    public void excluir(Reserva reserva){
        reservaDAO.delete(reserva.getId());
    }
   
    public Reserva pesquisarPorId(Long id){
        return reservaDAO.pesquisar(id);
    } 
    
    public List<Reserva> listarReservas(){
        return reservaDAO.listarTodos();
    }
    
    public List<Reserva> listarReservasPorObraBiblioteca(Obra obra, Biblioteca biblioteca){
        return reservaDAO.listarPorObraBiblioteca(obra, biblioteca);
    }
}
