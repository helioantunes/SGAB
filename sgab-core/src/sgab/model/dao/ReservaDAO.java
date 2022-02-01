/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.model.dao;
import sgab.model.dto.Reserva;
import sgab.model.exception.PersistenciaException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;
import sgab.model.dto.Obra;
/**
 *
 * @author T-Gamer
 */
public class ReservaDAO implements GenericDAO<Reserva, Long> {
    private Map<Long, Reserva> table = new HashMap<>();
    
    private static ReservaDAO reservaDAO;
    static {
        ReservaDAO.reservaDAO = null;
    }
    
    private static Long idSequence;
    static {
        ReservaDAO.idSequence = 0L;
    }
    
    public static Long getNextId() {
        return ReservaDAO.idSequence++;
    } 
    
    private ReservaDAO() { }
    
    @Override
    public void inserir(Reserva entidade) {
        if (pesquisar(entidade.getId()) != null)
            throw new PersistenciaException("'" + entidade.getId() 
                                                            + "' precisa ser único.");
        
        Long reservaId = ReservaDAO.getNextId();
        entidade.setId(reservaId);
        
        
        table.put(reservaId, entidade);
    }

    @Override
    public void alterar(Reserva entidade) {
        Reserva reserva = table.remove(entidade.getId());
        if (reserva == null)
            throw new PersistenciaException("Nenhuma reserva com " + "o id '" + entidade.getId() + "'.");
        
        inserir(entidade);
    }

    @Override
    public Reserva pesquisar(Long id) {
         return table.get(id);
    }

    @Override
    public List<Reserva> pesquisar(List<BasicPair<Long, Reserva>> parameterList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Reserva> listarTodos() {
        List<Reserva> listReservas = new ArrayList<>();
        
        listReservas.addAll(table.values());
        
        return listReservas;
    }
    
    public List<Reserva> listarPorObraBiblioteca(Obra obra, Biblioteca biblioteca) {
        List<Reserva> listReservas = new ArrayList<>();
        
        for(Reserva reserva : table.values()) {
            Exemplar exemplarAtual = (Exemplar) reserva.getExemplares().get(0);
            if(exemplarAtual.getObra() == obra && reserva.getLocalReserva() == biblioteca)
                listReservas.add(reserva);
        }
        
        return listReservas;
    }
    
    public void delete(Long id){
        table.remove(id);
    }
}
