
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.DuvidaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Duvida;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.DuvidaService;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(DuvidaService.class)
public class DuvidaServiceImpl implements DuvidaService{
    
    @Inject
    private DuvidaDAO duvidaDAO;

    @Override
    public void salvar(Duvida duvida) {
        duvidaDAO.salvar(duvida);
    }

    @Override
    public void atualizar(Duvida duvida) {
        duvidaDAO.atualizar(duvida);
    }

    @Override
    public void remover(int id) {
        Duvida duvida = duvidaDAO.getDuvida(id);
        duvidaDAO.remover(duvida);
    }

    @Override
    public Duvida getDuvida(int id) {
        return duvidaDAO.getDuvida(id);
    }

    @Override
    public List<Duvida> listar() {
        return duvidaDAO.listar();
    }

    @Override
    public List<Duvida> duvidasProfessor(Professor professor) {
        return duvidaDAO.duvidasProfessor(professor);
    }
    
}
