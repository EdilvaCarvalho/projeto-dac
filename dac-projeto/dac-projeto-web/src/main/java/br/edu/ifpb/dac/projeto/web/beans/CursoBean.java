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
    private List<Aula> aulas = new ArrayList<>();

    public CursoBean() {
    }

    public String pegaCurso(Curso curso) {
        this.cursoEncontrado = this.cursoService.getCurso(curso.getCodigo());
        return "horarioCurso.xhtml";
    }
    
    public List<Curso> todosOsCursos(){
        return cursoService.listar();
    }

    public Curso getCursoEncontrado() {
        return cursoEncontrado;
    }

    public void setCursoEncontrado(Curso cursoEncontrado) {
        this.cursoEncontrado = cursoEncontrado;
    }

    public List<Aula> getAulas() {
        aulas = this.cursoService.listarAulas(cursoEncontrado);
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

}
