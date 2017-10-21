package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.HorarioDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import java.util.ArrayList;
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
@Local(HorarioDAO.class)
public class HorarioDaoImpl implements HorarioDAO {

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

    @Override
    public List<Object[]> horarioDisponivelReposicao(Aula aula) {
        try {
//            Query query = manager.createQuery("SELECT DISTINCT a.horario, a.dia_abrev, a.dia_desc FROM Aula a WHERE "
//                    + "a.disciplina.periodo <> :periodo AND "
//                    + "a.professor <> :professor");

            Query query = manager.createQuery("SELECT DISTINCT a.horario, a.dia_abrev, a.dia_desc FROM Aula a WHERE a.disciplina.periodo <> :periodo AND a.professor <> :professor");

            query.setParameter("professor", aula.getProfessor());
            query.setParameter("periodo", aula.getDisciplina().getPeriodo());

            List<Object[]> resultList = query.getResultList();

            //List<Aula> list = query.getResultList();
            if (resultList == null || resultList.isEmpty()) {
                return Collections.EMPTY_LIST;
            } else {
                return resultList;
            }

        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

}
