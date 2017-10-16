
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.LaboratorioDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Laboratorio;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.LaboratorioService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(LaboratorioService.class)
public class LaboratorioServiceImpl implements LaboratorioService{
    
    @EJB
    private LaboratorioDAO laboratorioDAO;

    @Override
    public void salvar(Laboratorio laboratorio) {
        laboratorioDAO.salvar(laboratorio);
    }

    @Override
    public void atualizar(Laboratorio laboratorio) {
        laboratorioDAO.atualizar(laboratorio);
    }

    @Override
    public void remover(int codigo) {
        Laboratorio laboratorio = laboratorioDAO.getLaboratorio(codigo);
        laboratorioDAO.remover(laboratorio);
    }

    @Override
    public Laboratorio getLaboratorio(int codigo) {
        return laboratorioDAO.getLaboratorio(codigo);
    }

    @Override
    public List<Laboratorio> listar() {
        return laboratorioDAO.listar();
    }
    
}
