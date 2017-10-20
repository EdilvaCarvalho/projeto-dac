
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Curso;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface CursoDAO {
    
    void salvar(Curso curso);
    void atualizar(Curso curso);
    void remover(Curso curso);
    Curso getCurso(int codigo);
    List<Curso> listar();
    List<Aula> listarAulas(Curso curso, int periodo);
}
