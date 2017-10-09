
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ProfessorService {
    
    void salvar(Professor professor);
    void atualizar(Professor professor);
    void remover(Professor professor);
    Professor getProfessor(int codigo);
    List<Professor> listar();
}
