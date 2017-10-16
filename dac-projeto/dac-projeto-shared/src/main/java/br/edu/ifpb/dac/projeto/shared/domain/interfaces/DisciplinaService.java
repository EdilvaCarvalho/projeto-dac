
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface DisciplinaService {
    
    void salvar(Disciplina disciplina);
    void atualizar(Disciplina disciplina);
    void remover(int codigo);
    Disciplina getDisciplina(int codigo);
    List<Disciplina> listar();
}
