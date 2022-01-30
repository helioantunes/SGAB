package sgab.model.dao;

/**
 *
 * @author iulli
 */


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Exemplar;
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.dto.util.ExemplarTipo;
import sgab.model.exception.PersistenciaException;
import java.util.ArrayList;

public class ExemplarDAO implements GenericDAO<Exemplar, Long>{
    private Map<Long, Exemplar> exemplares = new HashMap<>();
    
    private static ExemplarDAO exemplarDAO;
    static{
        ExemplarDAO.exemplarDAO = null;
    }
    
    private static Long ids;
    static{
        ExemplarDAO.ids = 0L;
    }
    
    public static Long getNextId() {
        return ExemplarDAO.ids++;
    }
    
    private ExemplarDAO() {}
    
    public static ExemplarDAO getInstance() {
        if (exemplarDAO == null) {
            exemplarDAO = new ExemplarDAO();
        }
        return exemplarDAO;
    }
    
    
    @Override
    public void inserir(Exemplar exemplar) {
        exemplar.setId(ExemplarDAO.getNextId());
        exemplares.put(exemplar.getId(), exemplar);
    }
    
     @Override
    public void alterar(Exemplar exemplar) {
        Exemplar exemplarAlvo = exemplares.remove(exemplar.getId());
        if(exemplarAlvo == null){
            throw new PersistenciaException("Nenhum exemplar");
        }
        
        inserir(exemplar);
    }    
    
    public void alterar(Exemplar exemplar, ExemplarStatus status) {
        if(exemplar == null){
            throw new PersistenciaException("Nenhum exemplar");
        }
        
        exemplar.setStatus(status);
    }
    
    @Override
    public Exemplar pesquisar(Long key) {
        return exemplares.get(key);
    }
        
    
    @Override
    public List pesquisar(List parameterList) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public List<Exemplar> listarRestauracao() {
        List<Exemplar> listExemplares = new ArrayList<>();
        
        for (Exemplar exe: exemplares.values())
            if (exe.getStatus() == ExemplarStatus.REPARO)
                listExemplares.add(exe);
        
        return listExemplares;
    }
    
    public List<Exemplar> listarConsulta() {
        List<Exemplar> listExemplar = new ArrayList<>();
        
        for (Exemplar exe: exemplares.values())
            if (exe.getTipo() == ExemplarTipo.CONSULTA)
                listExemplar.add(exe);
        
        return listExemplar;
    }
    
    public List<Exemplar> listarTransferencia() {
        List<Exemplar> listExemplar = new ArrayList<>();
        
        for (Exemplar exe: exemplares.values())
            if (exe.getStatus() == ExemplarStatus.TRANSFERENCIA)
                listExemplar.add(exe);
        
        return listExemplar;
    }
    
}
