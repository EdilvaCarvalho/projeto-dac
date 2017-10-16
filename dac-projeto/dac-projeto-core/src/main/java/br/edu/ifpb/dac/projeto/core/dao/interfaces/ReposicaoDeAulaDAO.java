
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.ReposicaoDeAula;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ReposicaoDeAulaDAO {
    
    void salvar(ReposicaoDeAula reposicao);
    void atualizar(ReposicaoDeAula reposicao);
    void remover(ReposicaoDeAula reposicao);
    ReposicaoDeAula getReposicaoDeAula(int codigo);
    List<ReposicaoDeAula> listar();
}
