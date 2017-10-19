
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.TurmaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.TurmaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(TurmaService.class)
public class TurmaServiceImpl implements TurmaService{
    
    @EJB
    private TurmaDAO turmaDAO;

    @Override
    public void salvar(Turma turma) {
        turmaDAO.salvar(turma);
    }

    @Override
    public void atualizar(Turma turma) {
        turmaDAO.atualizar(turma);
    }

    @Override
    public void remover(int codigo) {
        Turma turma = turmaDAO.getTurma(codigo);
        turmaDAO.remover(turma);
    }

    @Override
    public Turma getTurma(int codigo) {
        return turmaDAO.getTurma(codigo);
    }

    @Override
    public List<Turma> listar() {
        return turmaDAO.listar();
    }

    @Override
    public List<Aula> listarAulas(Turma turma) {
        return turmaDAO.listarAulas(turma);
    }
    
}
