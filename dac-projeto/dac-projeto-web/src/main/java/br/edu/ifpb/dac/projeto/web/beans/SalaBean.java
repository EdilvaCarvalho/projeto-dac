package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Sala;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.HorarioService;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.SalaService;
import java.io.Serializable;
import java.util.ArrayList;
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
public class SalaBean implements Serializable {

    @Inject
    private SalaService salaService;
    private Sala salaEncontrada = new Sala();
    private List<Aula> aulas = new ArrayList<>();

    public SalaBean() {
    }

    public String pegaSala(Sala sala) {
        this.salaEncontrada = this.salaService.getSala(sala.getCodigo());
        return "horarioSala.xhtml";
    }
    
    public List<Sala> todasAsSalas(){
        return salaService.listar();
    }

    public Sala getSalaEncontrada() {
        return salaEncontrada;
    }

    public void setSalaEncontrada(Sala salaEncontrada) {
        this.salaEncontrada = salaEncontrada;
    }

    public List<Aula> getAulas() {
        aulas = this.salaService.listarAulas(salaEncontrada);
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

}
