
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface TurmaDAO {
    
    void salvar(Turma turma);
    void atualizar(Turma turma);
    void remover(Turma turma);
    Turma getTurma(int codigo);
    List<Turma> listar();
}
