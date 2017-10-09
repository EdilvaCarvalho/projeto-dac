
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Curso;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface CursoService {
    
    void salvar(Curso curso);
    void atualizar(Curso curso);
    void remover(Curso curso);
    Curso getCurso(int codigo);
    List<Curso> listar();
}
