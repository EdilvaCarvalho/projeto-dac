package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Edilva
 */
@Entity
public class Laboratorio implements Serializable {

    @Id
    private int codigo;
    @Column(length = 80)
    private String descricao;
    @Column(length = 20)
    private String abreviacao;
    @OneToMany(mappedBy = "laboratorio")
    @JoinColumn(name = "laboratorio_codigo")
    private List<Aula> aulas;

    public Laboratorio() {
    }

    public Laboratorio(String descricao, String abreviacao) {
        this.descricao = descricao;
        this.abreviacao = abreviacao;
        this.aulas = new ArrayList<>();
    }

    public Laboratorio(int codigo, String descricao, String abreviacao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
        this.aulas = new ArrayList<>();
    }

    public Laboratorio(int codigo, String descricao, String abreviacao, List<Aula> aulas) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
        this.aulas = aulas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void addAula(Aula aula) {
        this.aulas.add(aula);
        aula.setLaboratorio(this);
    }

    public void removeAula(Aula aula) {
        this.aulas.remove(aula);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + Objects.hashCode(this.abreviacao);
        hash = 41 * hash + Objects.hashCode(this.aulas);
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
        final Laboratorio other = (Laboratorio) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.abreviacao, other.abreviacao)) {
            return false;
        }
        if (!Objects.equals(this.aulas, other.aulas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "codigo=" + codigo + ", descricao=" + descricao + ", abreviacao=" + abreviacao + ", aulas=" + aulas + '}';
    }

}
