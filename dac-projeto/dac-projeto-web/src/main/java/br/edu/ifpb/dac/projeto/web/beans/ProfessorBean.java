package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.DisciplinaService;
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
public class ProfessorBean implements Serializable {

    @Inject
    private ProfessorService professorService;
    @Inject
    private DisciplinaService disciplinaService;
    private Professor professorEncontrado = new Professor();
    private List<Aula> aulas = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private Disciplina disciplinaEncontra = new Disciplina();
    private int ch;

    public ProfessorBean() {
    }

    public String pegaProfessorAulas(Professor professor) {
        this.professorEncontrado = this.professorService.getProfessor(professor.getCodigo());
        return "horarioProfessor.xhtml";
    }

    public String pegaProfessorTurmas(Professor professor) {
        this.professorEncontrado = this.professorService.getProfessor(professor.getCodigo());
        return "turmasDoProfessor.xhtml";
    }

    public String pegaDisciplina(Disciplina disciplina) {
        this.disciplinaEncontra = this.disciplinaService.getDisciplina(disciplina.getCodigo());
        return "horarioTurma.xhtml";
    }

    public List<Professor> todosOsProfessores() {
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

    public List<Disciplina> getDisciplinas() {
        disciplinas = this.professorService.listarDisciplinas(professorEncontrado);
        int cont = 0;
        for (Disciplina d : disciplinas) {
            cont += d.getAulas_semana();
        }
        this.ch = cont;
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public Disciplina getDisciplinaEncontra() {
        return disciplinaEncontra;
    }

    public void setDisciplinaEncontra(Disciplina disciplinaEncontra) {
        this.disciplinaEncontra = disciplinaEncontra;
    }

}
