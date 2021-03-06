
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.ProfessorDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.ProfessorService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(ProfessorService.class)
public class ProfessorServiceImpl implements ProfessorService{
    
    @EJB
    private ProfessorDAO professorDAO;

    @Override
    public void salvar(Professor professor) {
        professorDAO.salvar(professor);
    }

    @Override
    public void atualizar(Professor professor) {
        professorDAO.atualizar(professor);
    }

    @Override
    public void remover(int codigo) {
        Professor professor = professorDAO.getProfessor(codigo);
        professorDAO.remover(professor);
    }

    @Override
    public Professor getProfessor(int codigo) {
        return professorDAO.getProfessor(codigo);
    }

    @Override
    public List<Professor> listar() {
        return professorDAO.listar();
    }

    @Override
    public List<Aula> listarAulas(Professor professor) {
        return professorDAO.listarAulas(professor);
    }

    @Override
    public Professor professorPorEmail(String email) {
        return professorDAO.professorPorEmail(email);
    }

    @Override
    public Professor autenticar(String email, String senha) {
         return professorDAO.autenticar(email, senha);
    }

    @Override
    public List<Disciplina> listarDisciplinas(Professor professor) {
        return professorDAO.listarDisciplinas(professor);
    }

    @Override
    public Professor professorPorUsuario(Usuario usuario) {
        return professorDAO.professorPorUsuario(usuario);
    }
    
}
