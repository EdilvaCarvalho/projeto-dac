package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.CursoDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Curso;
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
@Local(CursoDAO.class)
public class CursoDaoImpl implements CursoDAO {
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Curso curso) {
        manager.persist(curso);
    }

    @Override
    public void atualizar(Curso curso) {
        manager.merge(curso);
    }

    @Override
    public void remover(Curso curso) {
        manager.remove(curso);
    }

    @Override
    public Curso getCurso(int codigo) {
        return manager.find(Curso.class, codigo);
    }

    @Override
    public List<Curso> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT c FROM Curso c");

            List<Curso> list = query.getResultList();

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
