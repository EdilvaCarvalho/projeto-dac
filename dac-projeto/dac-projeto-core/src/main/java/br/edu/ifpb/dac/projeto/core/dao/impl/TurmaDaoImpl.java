
package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.TurmaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
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
@Local(TurmaDAO.class)
public class TurmaDaoImpl implements TurmaDAO{
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Turma turma) {
        manager.persist(turma);
    }

    @Override
    public void atualizar(Turma turma) {
        manager.merge(turma);
    }

    @Override
    public void remover(Turma turma) {
        manager.remove(turma);
    }

    @Override
    public Turma getTurma(int codigo) {
        return manager.find(Turma.class, codigo);
    }

    @Override
    public List<Turma> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT t FROM Turma t");

            List<Turma> list = query.getResultList();

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
    public List<Aula> listarAulas(Turma turma) {
        try {
            TypedQuery<Aula> query = manager.createQuery("SELECT a FROM Aula a WHERE a.turma.codigo = :codigo", Aula.class);
            query.setParameter("codigo", turma.getCodigo());
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
