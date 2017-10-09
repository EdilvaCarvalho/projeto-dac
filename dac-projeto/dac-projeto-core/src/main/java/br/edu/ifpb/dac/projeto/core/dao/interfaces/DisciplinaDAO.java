
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import java.util.List;

/**
 *
 * @author Edilva
 */
public interface DisciplinaDAO {
    
    void salvar(DisciplinaDAO disciplina);
    void atualizar(DisciplinaDAO disciplina);
    void remover(DisciplinaDAO disciplina);
    DisciplinaDAO getDisciplina(int codigo);
    List<DisciplinaDAO> listar();
}
