
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Duvida;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface DuvidaService {
    
    void salvar(Duvida duvida);
    void atualizar(Duvida duvida);
    void remover(int id);
    Duvida getDuvida(int id);
    List<Duvida> listar();
    List<Duvida> duvidasProfessor(Professor professor);
}
