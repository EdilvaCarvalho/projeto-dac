package br.edu.ifpb.dac.projeto.core.dao.impl;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.ProfessorDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
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
@Local(ProfessorDAO.class)
public class ProfessorDaoImpl implements ProfessorDAO {

    @PersistenceContext(unitName = "dac-projeto-PU")
    private EntityManager manager;

    @Override
    public void salvar(Professor professor) {
        manager.persist(professor);
    }

    @Override
    public void atualizar(Professor professor) {
        manager.merge(professor);
    }

    @Override
    public void remover(Professor professor) {
        manager.remove(professor);
    }

    @Override
    public Professor getProfessor(int codigo) {
        return manager.find(Professor.class, codigo);
    }

    @Override
    public List<Professor> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT p FROM Professor p");

            List<Professor> list = query.getResultList();

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
    public List<Aula> listarAulas(Professor professor) {
        try {
            TypedQuery<Aula> query = manager.createQuery("SELECT a FROM Aula a WHERE a.professor.codigo = :codigo", Aula.class);
            query.setParameter("codigo", professor.getCodigo());
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

    @Override
    public Professor professorPorEmail(String email) {
        try {
            TypedQuery<Professor> query = manager.
                    createQuery("SELECT p FROM Professor p WHERE p.email = :email", Professor.class);
            query.setParameter("email", email);
            Professor professor = query.getSingleResult();

            return professor;

        } catch (Exception e) {
            return new Professor();
        }
    }

    @Override
    public Professor autenticar(String email, String senha) {
        try {
            TypedQuery<Professor> query = manager.
                    createQuery("SELECT p FROM Professor p WHERE p.usuario.email = :email AND p.usuario.senha = :senha", Professor.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            Professor professor = query.getSingleResult();

            return professor;

        } catch (Exception e) {
            return new Professor();
        }
    }

    @Override
    public List<Disciplina> listarDisciplinas(Professor professor) {
        try {
            TypedQuery<Disciplina> query = manager.createQuery("SELECT DISTINCT(a.disciplina) FROM Aula a WHERE a.professor = :professor", Disciplina.class);
            query.setParameter("professor", professor);
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

    @Override
    public Professor professorPorUsuario(Usuario usuario) {
        try {
            TypedQuery<Professor> query = manager.
                    createQuery("SELECT p FROM Professor p WHERE p.usuario = :usuario", Professor.class);
            query.setParameter("usuario", usuario);
            Professor professor = query.getSingleResult();

            return professor;

        } catch (Exception e) {
            return new Professor();
        }
    }

}
