
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Sala;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface SalaDAO {
    
    void salvar(Sala sala);
    void atualizar(Sala sala);
    void remover(Sala sala);
    Sala getSala(int codigo);
    List<Sala> listar();
}
