
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.UsuarioService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(UsuarioService.class)
public class UsuarioServiceImpl implements UsuarioService{
    
    @EJB
    private UsuarioDAO usuarioDAO;

    @Override
    public void salvar(Usuario usuario) {
        usuarioDAO.salvar(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    @Override
    public void remover(int id) {
        Usuario usuario = usuarioDAO.getUsuario(id);
        usuarioDAO.remover(usuario);
    }

    @Override
    public Usuario getUsuario(int id) {
        return usuarioDAO.getUsuario(id);
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return usuarioDAO.autenticar(email, senha);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioDAO.listarTodos();
    }

    @Override
    public List<Usuario> listarAcessoLiberado() {
        return usuarioDAO.listarAcessoLiberado();
    }

    @Override
    public List<Usuario> listarAcessoPendente() {
        return usuarioDAO.listarAcessoPendente();
    }
    
}
