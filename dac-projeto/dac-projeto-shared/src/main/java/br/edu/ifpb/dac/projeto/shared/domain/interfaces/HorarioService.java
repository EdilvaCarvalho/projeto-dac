
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface HorarioService {
    
    void salvar(Horario horario);
    void atualizar(Horario horario);
    void remover(int codigo);
    Horario getHorario(int codigo);
    List<Horario> listar();
}
