package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Laboratorio;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.LaboratorioService;
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
public class LaboratorioBean implements Serializable {

    @Inject
    private LaboratorioService laboratorioService;
    private Laboratorio laboratorioEncontrado = new Laboratorio();
    private List<Aula> aulas = new ArrayList<>();

    public LaboratorioBean() {
    }

    public String pegaLaboratorio(Laboratorio laboratorio) {
        this.laboratorioEncontrado = this.laboratorioService.getLaboratorio(laboratorio.getCodigo());
        return "horarioLaboratorio.xhtml";
    }
    
    public List<Laboratorio> todosOsLaboratorios(){
        return laboratorioService.listar();
    }

    public Laboratorio getLaboratorioEncontrado() {
        return laboratorioEncontrado;
    }

    public void setLaboratorioEncontrado(Laboratorio laboratorioEncontrado) {
        this.laboratorioEncontrado = laboratorioEncontrado;
    }

    public List<Aula> getAulas() {
        aulas = this.laboratorioService.listarAulas(laboratorioEncontrado);
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

}
