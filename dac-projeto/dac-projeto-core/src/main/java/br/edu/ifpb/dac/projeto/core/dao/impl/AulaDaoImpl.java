package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.AulaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
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
@Local(AulaDAO.class)
public class AulaDaoImpl implements AulaDAO {

    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Aula aula) {
        manager.persist(aula);
    }

    @Override
    public void atualizar(Aula aula) {
        manager.merge(aula);
    }

    @Override
    public void remover(Aula aula) {
        manager.remove(aula);
    }

    @Override
    public Aula getAula(int codigo) {
        return manager.find(Aula.class, codigo);
    }

    @Override
    public List<Aula> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT a FROM Aula a");

            List<Aula> list = query.getResultList();

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
