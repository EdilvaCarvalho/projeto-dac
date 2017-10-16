
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.DisciplinaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.DisciplinaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(DisciplinaService.class)
public class DisciplinaServiceImpl implements DisciplinaService{
    
    @EJB
    private DisciplinaDAO disciplinaDAO;

    @Override
    public void salvar(Disciplina disciplina) {
        disciplinaDAO.salvar(disciplina);
    }

    @Override
    public void atualizar(Disciplina disciplina) {
        disciplinaDAO.atualizar(disciplina);
    }

    @Override
    public void remover(int codigo) {
        Disciplina disciplina = disciplinaDAO.getDisciplina(codigo);
        disciplinaDAO.remover(disciplina);
    }

    @Override
    public Disciplina getDisciplina(int codigo) {
        return disciplinaDAO.getDisciplina(codigo);
    }

    @Override
    public List<Disciplina> listar() {
        return disciplinaDAO.listar();
    }
    
}
