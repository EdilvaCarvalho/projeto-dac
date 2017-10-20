package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Curso;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.CursoService;
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
public class CursoBean implements Serializable {

    @Inject
    private CursoService cursoService;
    private Curso cursoEncontrado = new Curso();
    private int periodo;
    private List<Aula> aulas = new ArrayList<>();
    private List<Integer> periodos = new ArrayList<>();

    public CursoBean() {
    }

    public String pegaCurso(Curso curso) {
        this.cursoEncontrado = this.cursoService.getCurso(curso.getCodigo());
        return "periodos.xhtml";
    }
    
    public String aulasPorPeriodo(int periodo){
        setPeriodo(periodo);
        getAulas();
        return "horarioCurso.xhtml";
    }

    public List<Curso> todosOsCursos() {
        return cursoService.listar();
    }

    public Curso getCursoEncontrado() {
        return cursoEncontrado;
    }

    public void setCursoEncontrado(Curso cursoEncontrado) {
        this.cursoEncontrado = cursoEncontrado;
    }

    public List<Aula> getAulas() {
        aulas = this.cursoService.listarAulas(cursoEncontrado, periodo);
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public List<Integer> getPeriodos() {
        this.periodos = new ArrayList<>();
        for (int i = 1; i < this.getCursoEncontrado().getPeriodos()+1; ++i) {
            this.periodos.add(i);
        }
        return periodos;
    }

    public void setPeriodos(List<Integer> periodos) {
        this.periodos = periodos;
    }

}
