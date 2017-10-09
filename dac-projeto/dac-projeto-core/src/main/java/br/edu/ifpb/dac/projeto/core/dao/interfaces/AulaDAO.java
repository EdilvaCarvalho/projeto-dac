
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface AulaDAO {
    
    void salvar(Aula aula);
    void atualizar(Aula aula);
    void remover(Aula aula);
    Aula getAula(int codigo);
    List<Aula> listar();
    
}
