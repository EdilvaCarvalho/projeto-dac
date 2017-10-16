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
public class ReposicaoDeAula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(length = 150)
    private String assunto;
    @OneToOne
    private Horario horario;
    @ManyToOne
    private Curso curso;
    @OneToOne
    private Disciplina disciplina;
    @OneToOne
    private Turma turma;
    @OneToOne
    private Semestre semestre;
    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Sala sala;
    @ManyToOne
    private Laboratorio laboratorio;

    public ReposicaoDeAula() {
    }

    public ReposicaoDeAula(String assunto, Horario horario, Curso curso, Disciplina disciplina, Turma turma, Semestre semestre, Professor professor, Sala sala, Laboratorio laboratorio) {
        this.assunto = assunto;
        this.horario = horario;
        this.curso = curso;
        this.disciplina = disciplina;
        this.turma = turma;
        this.semestre = semestre;
        this.professor = professor;
        this.sala = sala;
        this.laboratorio = laboratorio;
    }

    public ReposicaoDeAula(int codigo, String assunto, Horario horario, Curso curso, Disciplina disciplina, Turma turma, Semestre semestre, Professor professor, Sala sala, Laboratorio laboratorio) {
        this.codigo = codigo;
        this.assunto = assunto;
        this.horario = horario;
        this.curso = curso;
        this.disciplina = disciplina;
        this.turma = turma;
        this.semestre = semestre;
        this.professor = professor;
        this.sala = sala;
        this.laboratorio = laboratorio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.assunto);
        hash = 97 * hash + Objects.hashCode(this.horario);
        hash = 97 * hash + Objects.hashCode(this.curso);
        hash = 97 * hash + Objects.hashCode(this.disciplina);
        hash = 97 * hash + Objects.hashCode(this.turma);
        hash = 97 * hash + Objects.hashCode(this.semestre);
        hash = 97 * hash + Objects.hashCode(this.professor);
        hash = 97 * hash + Objects.hashCode(this.sala);
        hash = 97 * hash + Objects.hashCode(this.laboratorio);
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
        final ReposicaoDeAula other = (ReposicaoDeAula) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.assunto, other.assunto)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        if (!Objects.equals(this.semestre, other.semestre)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.sala, other.sala)) {
            return false;
        }
        if (!Objects.equals(this.laboratorio, other.laboratorio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReposicaoDeAula{" + "codigo=" + codigo + ", assunto=" + assunto + ", horario=" + horario + ", curso=" + curso + ", disciplina=" + disciplina + ", turma=" + turma + ", semestre=" + semestre + ", professor=" + professor + ", sala=" + sala + ", laboratorio=" + laboratorio + '}';
    }

}
