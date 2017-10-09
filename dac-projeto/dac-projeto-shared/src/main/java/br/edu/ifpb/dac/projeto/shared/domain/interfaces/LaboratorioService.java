
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Laboratorio;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface LaboratorioService {
    
    void salvar(Laboratorio laboratorio);
    void atualizar(Laboratorio laboratorio);
    void remover(Laboratorio laboratorio);
    Laboratorio getLaboratorio(int codigo);
    List<Laboratorio> listar();
}
