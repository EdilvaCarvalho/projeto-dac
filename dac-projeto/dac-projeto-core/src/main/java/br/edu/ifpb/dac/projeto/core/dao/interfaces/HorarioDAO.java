
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface HorarioDAO {
    
    void salvar(Horario horario);
    void atualizar(Horario horario);
    void remover(Horario horario);
    Horario getHorario(int codigo);
    List<Horario> listar();
    List<Object[]> horarioDisponivelReposicao(Aula aula);
}
