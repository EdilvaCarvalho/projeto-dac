
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Sala;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface SalaService {
    
    void salvar(Sala sala);
    void atualizar(Sala sala);
    void remover(int codigo);
    Sala getSala(int codigo);
    List<Sala> listar();
    List<Aula> listarAulas(Sala sala);
}
