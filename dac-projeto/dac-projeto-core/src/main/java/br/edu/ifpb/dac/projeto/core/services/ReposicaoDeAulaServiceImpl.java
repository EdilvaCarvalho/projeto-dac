
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.ReposicaoDeAulaDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.ReposicaoDeAula;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.ReposicaoDeAulaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(ReposicaoDeAulaService.class)
public class ReposicaoDeAulaServiceImpl implements ReposicaoDeAulaService{
    
    @EJB
    private ReposicaoDeAulaDAO reposicaoDAO;

    @Override
    public void salvar(ReposicaoDeAula reposicaoDeAula) {
        reposicaoDAO.salvar(reposicaoDeAula);
    }

    @Override
    public void atualizar(ReposicaoDeAula reposicaoDeAula) {
        reposicaoDAO.atualizar(reposicaoDeAula);
    }

    @Override
    public void remover(int codigo) {
        ReposicaoDeAula reposicaoDeAula = reposicaoDAO.getReposicaoDeAula(codigo);
        reposicaoDAO.remover(reposicaoDeAula);
    }

    @Override
    public ReposicaoDeAula getReposicaoDeAula(int codigo) {
        return reposicaoDAO.getReposicaoDeAula(codigo);
    }

    @Override
    public List<ReposicaoDeAula> listar() {
        return reposicaoDAO.listar();
    }
    
}
