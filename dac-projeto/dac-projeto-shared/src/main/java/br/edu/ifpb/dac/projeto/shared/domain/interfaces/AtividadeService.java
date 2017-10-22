
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Atividade;
import java.util.List;

/**
 *
 * @author joseph
 */
public interface AtividadeService {
    
    void salvar(Atividade atividade);
    void atualizar(Atividade atividade);
    void remover(int codigo);
    Atividade getAtividade(int codigo);
    List<Atividade> listar();
    
}

