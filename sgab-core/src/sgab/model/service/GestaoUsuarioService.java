package sgab.model.service;

import java.util.List;
import sgab.model.dao.UsuarioDAO;
import sgab.model.dto.Usuario;
import sgab.model.dto.util.UsuarioHelper;
import sgab.model.dto.util.UsuarioStatus;
import sgab.model.exception.NegocioException;

public class GestaoUsuarioService {

    private UsuarioDAO usuarioDAO;
    
    public GestaoUsuarioService() {
        usuarioDAO = UsuarioDAO.getInstance();
    }
    
    public Long cadastrar(Usuario usuario) {
        
        List<String> exMsgs = UsuarioHelper.validar(usuario);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
       
        usuarioDAO.inserir(usuario);
        return usuario.getId();
    }

    public void atualizar(Usuario usuario) {
        
        List<String> exMsgs = UsuarioHelper.validar(usuario);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        usuarioDAO.alterar(usuario);
    }

    public void excluir(Usuario usuario) {
        
        Usuario usr = usuarioDAO.pesquisar(usuario.getId());
        if (usr == null)
            throw new NegocioException("Usuário 'id=" + usuario.getId() + "'não encontrado!");
        
        usr.setStatus(UsuarioStatus.SUSPENSO);
    }

    public List<Usuario> pesquisarAtivos() {
        return usuarioDAO.listarAtivos();
    }

    public Usuario pesquisarPorId(Long id){
        return usuarioDAO.pesquisar(id);
    }    

    public Usuario pesquisarUsuario(String login, String senha){
        
        Usuario result = usuarioDAO.pesquisarLoginSenha(login, senha);
        return result;               
    }
}
