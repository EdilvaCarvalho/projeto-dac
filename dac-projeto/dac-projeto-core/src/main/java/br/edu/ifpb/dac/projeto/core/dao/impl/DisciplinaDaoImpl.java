package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.DisciplinaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
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
@Local(DisciplinaDAO.class)
public class DisciplinaDaoImpl implements DisciplinaDAO {

    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Disciplina disciplina) {
        manager.persist(disciplina);
    }

    @Override
    public void atualizar(Disciplina disciplina) {
        manager.merge(disciplina);
    }

    @Override
    public void remover(Disciplina disciplina) {
        manager.remove(disciplina);
    }

    @Override
    public Disciplina getDisciplina(int codigo) {
        return manager.find(Disciplina.class, codigo);
    }

    @Override
    public List<Disciplina> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT d FROM Disciplina d");

            List<Disciplina> list = query.getResultList();

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
