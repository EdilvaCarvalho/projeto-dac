
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ProfessorService {
    
    void salvar(Professor professor);
    void atualizar(Professor professor);
    void remover(int codigo);
    Professor getProfessor(int codigo);
    Professor professorPorEmail(String email);
    Professor professorPorUsuario(Usuario usuario);
    Professor autenticar(String email, String senha);
    List<Professor> listar();
    List<Aula> listarAulas(Professor professor);
    List<Disciplina> listarDisciplinas(Professor professor);
}
