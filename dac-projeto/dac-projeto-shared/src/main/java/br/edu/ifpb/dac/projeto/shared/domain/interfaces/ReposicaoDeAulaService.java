
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.ReposicaoDeAula;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ReposicaoDeAulaService {
    
    void salvar(ReposicaoDeAula reposicaoDeAula);
    void atualizar(ReposicaoDeAula reposicaoDeAula);
    void remover(int codigo);
    ReposicaoDeAula getReposicaoDeAula(int codigo);
    List<ReposicaoDeAula> listar();
}
