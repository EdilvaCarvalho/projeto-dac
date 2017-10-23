
package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.DuvidaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Duvida;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import java.util.Collections;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Edilva
 */
@Stateless
@Local(DuvidaDAO.class)
public class DuvidaDaoImpl implements DuvidaDAO{
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Duvida duvida) {
        manager.persist(duvida);
    }

    @Override
    public void atualizar(Duvida duvida) {
        manager.merge(duvida);
    }

    @Override
    public void remover(Duvida duvida) {
        manager.remove(duvida);
    }

    @Override
    public Duvida getDuvida(int id) {
        return manager.find(Duvida.class, id);
    }

    @Override
    public List<Duvida> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT d FROM Duvida d");

            List<Duvida> list = query.getResultList();

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
    public List<Duvida> duvidasProfessor(Professor professor) {
        try {
            TypedQuery<Duvida> query = manager
                    .createQuery("SELECT d FROM Duvida d WHERE d.professor = :professor", Duvida.class);
            query.setParameter("professor", professor);
            
            List<Duvida> list = query.getResultList();

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
