
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Semestre;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface SemestreService {
    
    void salvar(Semestre semestre);
    void atualizar(Semestre semestre);
    void remover(int codigo);
    Semestre getSemestre(int codigo);
    List<Semestre> listar();
}
