
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Semestre;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface SemestreDAO {
    
    void salvar(Semestre semestre);
    void atualizar(Semestre semestre);
    void remover(Semestre semestre);
    Semestre getSemestre(int codigo);
    List<Semestre> listar();
}
