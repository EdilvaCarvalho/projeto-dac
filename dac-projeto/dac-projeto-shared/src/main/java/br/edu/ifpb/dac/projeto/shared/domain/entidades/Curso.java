package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Edilva
 */
@Entity
public class Curso implements Serializable {

    @Id
    private int codigo;
    @Column(length = 40)
    private String unidade;
    @Column(length = 80)
    private String descricao;
    @Column(length = 20)
    private String abreviacao;
    private int periodos;
    @OneToMany(mappedBy = "curso")
    @JoinColumn(name = "curso_codigo")
    private List<Disciplina> disciplinas;
    @OneToMany(mappedBy = "curso")
    @JoinColumn(name = "curso_codigo")
    private List<Aula> aulas;

    public Curso() {
    }

    public Curso(String unidade, String descricao, String abreviacao, int periodos) {
        this.unidade = unidade;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
        this.periodos = periodos;
        this.aulas = new ArrayList<>();
    }

    public Curso(int codigo, String unidade, String descricao, String abreviacao, int periodos) {
        this.codigo = codigo;
        this.unidade = unidade;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
        this.periodos = periodos;
        this.disciplinas = new ArrayList<>();
        this.aulas = new ArrayList<>();
    }

    public Curso(int codigo, String unidade, String descricao, String abreviacao, int periodos, List<Disciplina> disciplinas, List<Aula> aulas) {
        this.codigo = codigo;
        this.unidade = unidade;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
        this.periodos = periodos;
        this.disciplinas = disciplinas;
        this.aulas = aulas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public int getPeriodos() {
        return periodos;
    }

    public void setPeriodos(int periodos) {
        this.periodos = periodos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        disciplina.setCurso(this);
    }

    public void removeDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
    }

    public void addAula(Aula aula) {
        this.aulas.add(aula);
        aula.setCurso(this);
    }

    public void removeAula(Aula aula) {
        this.aulas.remove(aula);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.codigo;
        hash = 19 * hash + Objects.hashCode(this.unidade);
        hash = 19 * hash + Objects.hashCode(this.descricao);
        hash = 19 * hash + Objects.hashCode(this.abreviacao);
        hash = 19 * hash + this.periodos;
        hash = 19 * hash + Objects.hashCode(this.disciplinas);
        hash = 19 * hash + Objects.hashCode(this.aulas);
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
        final Curso other = (Curso) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.periodos != other.periodos) {
            return false;
        }
        if (!Objects.equals(this.unidade, other.unidade)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.abreviacao, other.abreviacao)) {
            return false;
        }
        if (!Objects.equals(this.disciplinas, other.disciplinas)) {
            return false;
        }
        if (!Objects.equals(this.aulas, other.aulas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", unidade=" + unidade + ", descricao=" + descricao + ", abreviacao=" + abreviacao + ", periodos=" + periodos + ", disciplinas=" + disciplinas + ", aulas=" + aulas + '}';
    }

}
