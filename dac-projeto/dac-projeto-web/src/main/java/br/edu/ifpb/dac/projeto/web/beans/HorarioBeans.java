package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.HorarioService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edilva
 */
@Named
@SessionScoped
public class HorarioBeans implements Serializable {

    @Inject
    private HorarioService horarioService;
    private List<Object[]> horarios = new ArrayList<>();

    public HorarioBeans() {
    }

    public List<Horario> getTodosOsHorarios() {
        return this.horarioService.listar();
    }

    public String pegaAula(Aula aula) {
        this.horarios = this.horarioService.horarioDisponivelReposicao(aula);
        for (Object[] horario : horarios) {
            System.out.println(Arrays.toString(horario));
        }
        System.out.println("oi");
        return "horariosDisponiveis.xhtml";
    }

    public List<Object[]> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Object[]> horarios) {
        this.horarios = horarios;
    }

}
