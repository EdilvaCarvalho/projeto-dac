
package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.LaboratorioDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Laboratorio;
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
@Local(LaboratorioDAO.class)
public class LaboratorioDaoImpl implements LaboratorioDAO{
    
    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Laboratorio laboratorio) {
        manager.persist(laboratorio);
    }

    @Override
    public void atualizar(Laboratorio laboratorio) {
        manager.merge(laboratorio);
    }

    @Override
    public void remover(Laboratorio laboratorio) {
        manager.remove(laboratorio);
    }

    @Override
    public Laboratorio getLaboratorio(int codigo) {
        return manager.find(Laboratorio.class, codigo);
    }

    @Override
    public List<Laboratorio> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT l FROM Laboratorio l");

            List<Laboratorio> list = query.getResultList();

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
    public List<Aula> listarAulas(Laboratorio laboratorio) {
        try {
            TypedQuery<Aula> query = manager.createQuery("SELECT a FROM Aula a WHERE a.laboratorio.codigo = :codigo", Aula.class);
            query.setParameter("codigo", laboratorio.getCodigo());
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
