package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Edilva
 */
@Entity
public class Aula implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;
    private int dia_abrev;
    @Column(length = 80)
    private String dia_desc;
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

    public Aula() {
    }

    public Aula(int dia_abrev, String dia_desc, Horario horario, Curso curso, Disciplina disciplina, Turma turma, Semestre semestre, Professor professor, Sala sala, Laboratorio laboratorio) {
        this.dia_abrev = dia_abrev;
        this.dia_desc = dia_desc;
        this.horario = horario;
        this.curso = curso;
        this.disciplina = disciplina;
        this.turma = turma;
        this.semestre = semestre;
        this.professor = professor;
        this.sala = sala;
        this.laboratorio = laboratorio;
    }

    public Aula(int codigo, int dia_abrev, String dia_desc, Horario horario, Curso curso, Disciplina disciplina, Turma turma, Semestre semestre, Professor professor, Sala sala, Laboratorio laboratorio) {
        this.codigo = codigo;
        this.dia_abrev = dia_abrev;
        this.dia_desc = dia_desc;
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

    public int getDia_abrev() {
        return dia_abrev;
    }

    public void setDia_abrev(int dia_abrev) {
        this.dia_abrev = dia_abrev;
    }

    public String getDia_desc() {
        return dia_desc;
    }

    public void setDia_desc(String dia_desc) {
        this.dia_desc = dia_desc;
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
        int hash = 3;
        hash = 79 * hash + this.codigo;
        hash = 79 * hash + this.dia_abrev;
        hash = 79 * hash + Objects.hashCode(this.dia_desc);
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
        final Aula other = (Aula) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.dia_abrev != other.dia_abrev) {
            return false;
        }
        if (!Objects.equals(this.dia_desc, other.dia_desc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aula{" + "cod_aula=" + codigo + ", dia_abrev=" + dia_abrev + ", dia_desc=" + dia_desc + ", horario=" + horario + ", curso=" + curso + ", disciplina=" + disciplina + ", turma=" + turma + ", semestre=" + semestre + ", professor=" + professor + ", sala=" + sala + ", laboratorio=" + laboratorio + '}';
    }

}
