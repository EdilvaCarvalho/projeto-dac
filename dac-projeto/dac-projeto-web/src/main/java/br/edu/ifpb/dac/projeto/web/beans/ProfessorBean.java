
package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.ProfessorService;
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
public class ProfessorBean implements Serializable{
    
    @Inject
    private ProfessorService professorService;
    private Professor professorEncontrado = new Professor();
    private List<Aula> aulas = new ArrayList<>();

    public ProfessorBean() {
    }
    
    public String pegaProfessor(Professor professor) {
        this.professorEncontrado = this.professorService.getProfessor(professor.getCodigo());
        return "horarioProfessor.xhtml";
    }
    
    public List<Professor> todosOsProfessores(){
        return professorService.listar();
    }

    public Professor getProfessorEncontrado() {
        return professorEncontrado;
    }

    public void setProfessorEncontrado(Professor professorEncontrado) {
        this.professorEncontrado = professorEncontrado;
    }

    public List<Aula> getAulas() {
        aulas = this.professorService.listarAulas(professorEncontrado);
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
    
    
}
