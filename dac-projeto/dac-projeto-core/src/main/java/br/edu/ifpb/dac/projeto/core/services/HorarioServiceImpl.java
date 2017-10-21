
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.HorarioDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.HorarioService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(HorarioService.class)
public class HorarioServiceImpl implements HorarioService{
    
    @EJB
    private HorarioDAO horarioDAO;

    @Override
    public void salvar(Horario horario) {
        horarioDAO.salvar(horario);
    }

    @Override
    public void atualizar(Horario horario) {
        horarioDAO.atualizar(horario);
    }

    @Override
    public void remover(int codigo) {
        Horario horario = horarioDAO.getHorario(codigo);
        horarioDAO.remover(horario);
    }

    @Override
    public Horario getHorario(int codigo) {
        return horarioDAO.getHorario(codigo);
    }

    @Override
    public List<Horario> listar() {
        return horarioDAO.listar();
    }

    @Override
    public List<Object[]> horarioDisponivelReposicao(Aula aula) {
        return horarioDAO.horarioDisponivelReposicao(aula);
    }
    
}
