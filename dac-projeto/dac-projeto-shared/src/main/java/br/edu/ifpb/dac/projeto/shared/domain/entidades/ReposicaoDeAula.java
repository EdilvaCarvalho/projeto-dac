package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @OneToOne
    private Aula aula;
    @OneToOne
    private Horario horario;
    @Column(length = 30)
    private String dia_desc;
    private boolean realizada;

    public ReposicaoDeAula() {
    }

    public ReposicaoDeAula(Aula aula, Horario horario, String dia_desc, boolean realizada) {
        this.aula = aula;
        this.horario = horario;
        this.dia_desc = dia_desc;
        this.realizada = realizada;
    }

    public ReposicaoDeAula(int codigo, Aula aula, Horario horario, String dia_desc, boolean realizada) {
        this.codigo = codigo;
        this.aula = aula;
        this.horario = horario;
        this.dia_desc = dia_desc;
        this.realizada = realizada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getDia_desc() {
        return dia_desc;
    }

    public void setDia_desc(String dia_desc) {
        this.dia_desc = dia_desc;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.aula);
        hash = 67 * hash + Objects.hashCode(this.horario);
        hash = 67 * hash + Objects.hashCode(this.dia_desc);
        hash = 67 * hash + (this.realizada ? 1 : 0);
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
        if (this.realizada != other.realizada) {
            return false;
        }
        if (!Objects.equals(this.dia_desc, other.dia_desc)) {
            return false;
        }
        if (!Objects.equals(this.aula, other.aula)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReposicaoDeAula{" + "codigo=" + codigo + ", aula=" + aula + ", horario=" + horario + ", dia_desc=" + dia_desc + ", realizada=" + realizada + '}';
    }

}
