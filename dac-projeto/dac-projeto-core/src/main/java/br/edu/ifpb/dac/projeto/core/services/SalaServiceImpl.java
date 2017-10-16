
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.SalaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Sala;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.SalaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(SalaService.class)
public class SalaServiceImpl implements SalaService{
    
    @EJB
    private SalaDAO salaDAO;

    @Override
    public void salvar(Sala sala) {
        salaDAO.salvar(sala);
    }

    @Override
    public void atualizar(Sala sala) {
        salaDAO.atualizar(sala);
    }

    @Override
    public void remover(int codigo) {
        Sala sala = salaDAO.getSala(codigo);
        salaDAO.remover(sala);
    }

    @Override
    public Sala getSala(int codigo) {
        return salaDAO.getSala(codigo);
    }

    @Override
    public List<Sala> listar() {
        return salaDAO.listar();
    }
    
}
