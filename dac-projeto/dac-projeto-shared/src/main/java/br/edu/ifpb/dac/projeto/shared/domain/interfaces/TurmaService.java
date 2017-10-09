
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface TurmaService {
    
    void salvar(Turma turma);
    void atualizar(Turma turma);
    void remover(Turma turma);
    Turma getTurma(int codigo);
    List<Turma> listar();
}
