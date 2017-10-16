
package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import java.util.Collections;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edilva
 */
@Stateless
@Local(UsuarioDAO.class)
public class UsuarioDaoImpl implements UsuarioDAO{
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Usuario usuario) {
        manager.persist(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        manager.merge(usuario);
    }

    @Override
    public void remover(Usuario usuario) {
        manager.remove(usuario);
    }

    @Override
    public Usuario getUsuario(int id) {
        return manager.find(Usuario.class, id);
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarTodos() {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM Usuario u");

            List<Usuario> list = query.getResultList();

            if (list == null || list.isEmpty()) {
                return Collections.EMPTY_LIST;
            } else {
                return list;
            }

        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<Usuario> listarAcessoLiberado() {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM Usuario u WHERE u.acesso = TRUE");

            List<Usuario> list = query.getResultList();

            if (list == null || list.isEmpty()) {
                return Collections.EMPTY_LIST;
            } else {
                return list;
            }

        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<Usuario> listarAcessoPendente() {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM Usuario u WHERE u.acesso = FALSE");

            List<Usuario> list = query.getResultList();

            if (list == null || list.isEmpty()) {
                return Collections.EMPTY_LIST;
            } else {
                return list;
            }

        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
    
}
