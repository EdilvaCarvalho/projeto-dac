package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Edilva
 */
@Entity
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(length = 10)
    private String identificacao;
    @Column(length = 80)
    private String disciplina;
    @OneToOne
    private Curso curso;
    @ManyToOne
    private Professor professor;

    public Turma() {
    }

    public Turma(String identificacao, String disciplina, Curso curso, Professor professor) {
        this.identificacao = identificacao;
        this.disciplina = disciplina;
        this.curso = curso;
        this.professor = professor;
    }

    public Turma(int codigo, String identificacao, String disciplina, Curso curso, Professor professor) {
        this.codigo = codigo;
        this.identificacao = identificacao;
        this.disciplina = disciplina;
        this.curso = curso;
        this.professor = professor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.identificacao);
        hash = 53 * hash + Objects.hashCode(this.disciplina);
        hash = 53 * hash + Objects.hashCode(this.curso);
        hash = 53 * hash + Objects.hashCode(this.professor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.identificacao, other.identificacao)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma{" + "codigo=" + codigo + ", identificacao=" + identificacao + ", disciplina=" + disciplina + ", curso=" + curso + ", professor=" + professor + '}';
    }

}
