package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Edilva
 */
@Entity
public class Disciplina implements Serializable {

    @Id
    private int codigo;
    @ManyToOne
    private Curso curso;
    @Column(length = 80)
    private String descricao;
    @Column(length = 20)
    private String abreviacao;
    private int periodo;
    private int carga_horaria;
    private int aulas_semana;

    public Disciplina() {
    }

    public Disciplina(int codigo, Curso curso, String descricao, String abreviacao, int periodo, int carga_horaria, int aulas_semana) {
        this.codigo = codigo;
        this.curso = curso;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
        this.periodo = periodo;
        this.carga_horaria = carga_horaria;
        this.aulas_semana = aulas_semana;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public int getAulas_semana() {
        return aulas_semana;
    }

    public void setAulas_semana(int aulas_semana) {
        this.aulas_semana = aulas_semana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.codigo;
        hash = 71 * hash + Objects.hashCode(this.curso);
        hash = 71 * hash + Objects.hashCode(this.descricao);
        hash = 71 * hash + Objects.hashCode(this.abreviacao);
        hash = 71 * hash + this.periodo;
        hash = 71 * hash + this.carga_horaria;
        hash = 71 * hash + this.aulas_semana;
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
        final Disciplina other = (Disciplina) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.carga_horaria != other.carga_horaria) {
            return false;
        }
        if (this.aulas_semana != other.aulas_semana) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.abreviacao, other.abreviacao)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", curso=" + curso + ", descricao=" + descricao + ", abreviacao=" + abreviacao + ", periodo=" + periodo + ", carga_horaria=" + carga_horaria + ", aulas_semana=" + aulas_semana + '}';
    }

}
