
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface AulaService {
    
    void salvar(Aula aula);
    void atualizar(Aula aula);
    void remover(int codigo);
    Aula getAula(int codigo);
    List<Aula> listar();
}
