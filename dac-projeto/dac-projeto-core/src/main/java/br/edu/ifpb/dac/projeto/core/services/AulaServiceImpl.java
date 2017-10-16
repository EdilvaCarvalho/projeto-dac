
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.AulaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.AulaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(AulaService.class)
public class AulaServiceImpl implements AulaService{
    
    @EJB
    private AulaDAO aulaDAO;

    @Override
    public void salvar(Aula aula) {
        aulaDAO.salvar(aula);
    }

    @Override
    public void atualizar(Aula aula) {
        aulaDAO.atualizar(aula);
    }

    @Override
    public void remover(int codigo) {
        Aula aula = aulaDAO.getAula(codigo);
        aulaDAO.remover(aula);
    }

    @Override
    public Aula getAula(int codigo) {
        return aulaDAO.getAula(codigo);
    }

    @Override
    public List<Aula> listar() {
        return aulaDAO.listar();
    }
    
}
