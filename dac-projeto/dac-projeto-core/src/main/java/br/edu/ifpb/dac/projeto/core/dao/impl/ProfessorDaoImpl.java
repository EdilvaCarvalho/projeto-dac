
package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.ProfessorDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
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
@Local(ProfessorDAO.class)
public class ProfessorDaoImpl implements ProfessorDAO{
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Professor professor) {
        manager.persist(professor);
    }

    @Override
    public void atualizar(Professor professor) {
        manager.merge(professor);
    }

    @Override
    public void remover(Professor professor) {
        manager.remove(professor);
    }

    @Override
    public Professor getProfessor(int codigo) {
        return manager.find(Professor.class, codigo);
    }

    @Override
    public List<Professor> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT p FROM Professor p");

            List<Professor> list = query.getResultList();

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
