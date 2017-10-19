package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.TurmaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Edilva
 */
public class TurmaBean implements Serializable {

    @Inject
    private TurmaService turmaService;
    private Turma turmaEncontrada = new Turma();
    private List<Aula> aulas = new ArrayList<>();

    public TurmaBean() {
    }

    public String pegaTurma(Turma turma) {
        this.turmaEncontrada = this.turmaService.getTurma(turma.getCodigo());
        return "horarioProfessor.xhtml";
    }
    
    public List<Turma> todosAsTurmas(){
        return turmaService.listar();
    }

    public Turma getTurmaEncontrada() {
        return turmaEncontrada;
    }

    public void setTurmaEncontrada(Turma turmaEncontrada) {
        this.turmaEncontrada = turmaEncontrada;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

}
