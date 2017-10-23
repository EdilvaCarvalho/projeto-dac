
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ProfessorDAO {
    
    void salvar(Professor professor);
    void atualizar(Professor professor);
    void remover(Professor professor);
    Professor getProfessor(int codigo);
    Professor professorPorEmail(String email);
    Professor professorPorUsuario(Usuario usuario);
    Professor autenticar(String email, String senha);
    List<Professor> listar();
    List<Aula> listarAulas(Professor professor);
    List<Disciplina> listarDisciplinas(Professor professor);
}
