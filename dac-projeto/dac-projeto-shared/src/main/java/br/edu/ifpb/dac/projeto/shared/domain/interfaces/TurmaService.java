
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface TurmaService {
    
    void salvar(Turma turma);
    void atualizar(Turma turma);
    void remover(int codigo);
    Turma getTurma(int codigo);
    List<Turma> listar();
    List<Aula> listarAulas(Turma turma);
}
