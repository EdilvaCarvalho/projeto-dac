package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.ReposicaoDeAulaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.ReposicaoDeAula;
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
@Local(ReposicaoDeAulaDAO.class)
public class ReposicaoDeAulaDaoImpl implements ReposicaoDeAulaDAO {

    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(ReposicaoDeAula reposicao) {
        manager.persist(reposicao);
    }

    @Override
    public void atualizar(ReposicaoDeAula reposicao) {
        manager.merge(reposicao);
    }

    @Override
    public void remover(ReposicaoDeAula reposicao) {
        manager.remove(reposicao);
    }

    @Override
    public ReposicaoDeAula getReposicaoDeAula(int codigo) {
        return manager.find(ReposicaoDeAula.class, codigo);
    }

    @Override
    public List<ReposicaoDeAula> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT r FROM ReposicaoDeAula r");

            List<ReposicaoDeAula> list = query.getResultList();

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
