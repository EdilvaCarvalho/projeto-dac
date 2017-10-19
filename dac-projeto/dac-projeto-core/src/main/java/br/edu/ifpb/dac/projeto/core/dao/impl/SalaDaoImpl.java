package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.SalaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Sala;
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
@Local(SalaDAO.class)
public class SalaDaoImpl implements SalaDAO {

    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Sala sala) {
        manager.persist(sala);
    }

    @Override
    public void atualizar(Sala sala) {
        manager.merge(sala);
    }

    @Override
    public void remover(Sala sala) {
        manager.remove(sala);
    }

    @Override
    public Sala getSala(int codigo) {
        return manager.find(Sala.class, codigo);
    }

    @Override
    public List<Sala> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT s FROM Sala s");

            List<Sala> list = query.getResultList();

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
    public List<Aula> listarAulas(Sala sala) {
        try {
            TypedQuery<Aula> query = manager.createQuery("SELECT a FROM Aula a WHERE a.sala.codigo = :codigo", Aula.class);
            query.setParameter("codigo", sala.getCodigo());
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
