
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.SemestreDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Semestre;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.SemestreService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(SemestreService.class)
public class SemestreServiceImpl implements SemestreService{
    
    @EJB
    private SemestreDAO semestreDAO;

    @Override
    public void salvar(Semestre semestre) {
        semestreDAO.salvar(semestre);
    }

    @Override
    public void atualizar(Semestre semestre) {
        semestreDAO.atualizar(semestre);
    }

    @Override
    public void remover(int codigo) {
        Semestre semestre = semestreDAO.getSemestre(codigo);
        semestreDAO.remover(semestre);
    }

    @Override
    public Semestre getSemestre(int codigo) {
        return semestreDAO.getSemestre(codigo);
    }

    @Override
    public List<Semestre> listar() {
        return semestreDAO.listar();
    }
    
}
