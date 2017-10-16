
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface DisciplinaDAO {
    
    void salvar(Disciplina disciplina);
    void atualizar(Disciplina disciplina);
    void remover(Disciplina disciplina);
    Disciplina getDisciplina(int codigo);
    List<Disciplina> listar();
}
