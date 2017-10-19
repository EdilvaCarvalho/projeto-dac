package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import br.edu.ifpb.dac.projeto.shared.domain.util.ConvertLocalTime;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Edilva
 */
@Entity
public class Horario implements Serializable {

    @Id
    private int hor_cod;
    @Column(length = 10)
    private String hor_desc;
    @Convert(converter = ConvertLocalTime.class)
    private LocalTime hor_inicio;
    @Convert(converter = ConvertLocalTime.class)
    private LocalTime hor_fim;

    public Horario() {
    }

    public Horario(String hor_desc, LocalTime hor_inicio, LocalTime hor_fim) {
        this.hor_desc = hor_desc;
        this.hor_inicio = hor_inicio;
        this.hor_fim = hor_fim;
    }

    public Horario(int hor_cod, String hor_desc, LocalTime hor_inicio, LocalTime hor_fim) {
        this.hor_cod = hor_cod;
        this.hor_desc = hor_desc;
        this.hor_inicio = hor_inicio;
        this.hor_fim = hor_fim;
    }

    public int getHor_cod() {
        return hor_cod;
    }

    public void setHor_cod(int hor_cod) {
        this.hor_cod = hor_cod;
    }

    public String getHor_desc() {
        return hor_desc;
    }

    public void setHor_desc(String hor_desc) {
        this.hor_desc = hor_desc;
    }

    public LocalTime getHor_inicio() {
        return hor_inicio;
    }

    public void setHor_inicio(LocalTime hor_inicio) {
        this.hor_inicio = hor_inicio;
    }

    public LocalTime getHor_fim() {
        return hor_fim;
    }

    public void setHor_fim(LocalTime hor_fim) {
        this.hor_fim = hor_fim;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.hor_cod;
        hash = 97 * hash + Objects.hashCode(this.hor_desc);
        hash = 97 * hash + Objects.hashCode(this.hor_inicio);
        hash = 97 * hash + Objects.hashCode(this.hor_fim);
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
        final Horario other = (Horario) obj;
        if (this.hor_cod != other.hor_cod) {
            return false;
        }
        if (!Objects.equals(this.hor_desc, other.hor_desc)) {
            return false;
        }
        if (!Objects.equals(this.hor_inicio, other.hor_inicio)) {
            return false;
        }
        if (!Objects.equals(this.hor_fim, other.hor_fim)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "hor_cod=" + hor_cod + ", hor_desc=" + hor_desc + ", hor_inicio=" + hor_inicio + ", hor_fim=" + hor_fim + '}';
    }

}
