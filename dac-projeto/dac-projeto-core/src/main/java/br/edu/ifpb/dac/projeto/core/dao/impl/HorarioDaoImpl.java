
package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.HorarioDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
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
@Local(HorarioDAO.class)
public class HorarioDaoImpl implements HorarioDAO{
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Horario horario) {
        manager.persist(horario);
    }

    @Override
    public void atualizar(Horario horario) {
        manager.merge(horario);
    }

    @Override
    public void remover(Horario horario) {
        manager.remove(horario);
    }

    @Override
    public Horario getHorario(int codigo) {
        return manager.find(Horario.class, codigo);
    }

    @Override
    public List<Horario> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT h FROM Horario h");

            List<Horario> list = query.getResultList();

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
