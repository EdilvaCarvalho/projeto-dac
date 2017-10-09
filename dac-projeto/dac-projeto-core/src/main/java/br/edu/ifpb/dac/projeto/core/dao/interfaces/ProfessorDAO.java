
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
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
    List<Professor> listar();
}
