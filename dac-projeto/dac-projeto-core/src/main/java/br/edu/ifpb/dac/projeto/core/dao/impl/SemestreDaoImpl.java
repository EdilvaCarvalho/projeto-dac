
package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.SemestreDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Semestre;
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
@Local(SemestreDAO.class)
public class SemestreDaoImpl implements SemestreDAO{
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Semestre semestre) {
        manager.persist(semestre);
    }

    @Override
    public void atualizar(Semestre semestre) {
        manager.merge(semestre);
    }

    @Override
    public void remover(Semestre semestre) {
        manager.remove(semestre);
    }

    @Override
    public Semestre getSemestre(int codigo) {
        return manager.find(Semestre.class, codigo);
    }

    @Override
    public List<Semestre> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT s FROM Semestre s");

            List<Semestre> list = query.getResultList();

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
