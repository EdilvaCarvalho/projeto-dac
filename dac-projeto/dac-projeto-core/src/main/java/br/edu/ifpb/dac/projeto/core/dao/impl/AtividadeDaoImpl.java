/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.AtividadeDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Atividade;
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
 * @author joseph
 */
@Stateless
@Local(AtividadeDAO.class)
public class AtividadeDaoImpl implements AtividadeDAO{
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Atividade atividade) {
        manager.persist(atividade);
    }

    @Override
    public void atualizar(Atividade atividade) {
        manager.merge(atividade);
    }

    @Override
    public void remover(Atividade atividade) {
        manager.remove(atividade);
    }

    @Override
    public Atividade getAtividade(int codigo) {
        return manager.find(Atividade.class, codigo);
    }

    @Override
    public List<Atividade> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT a FROM Atividade a");

            List<Atividade> list = query.getResultList();

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
