package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import br.edu.ifpb.dac.projeto.shared.domain.util.ConvertLocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Edilva
 */
@Entity
public class Atividade implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 80)
    private String descricao;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate data;
    private Turma turma;

    public Atividade() {
    }

    public Atividade(String descricao, LocalDate data, Turma turma) {
        this.descricao = descricao;
        this.data = data;
        this.turma = turma;
    }

    public Atividade(int id, String descricao, LocalDate data, Turma turma) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.turma = turma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.descricao);
        hash = 59 * hash + Objects.hashCode(this.data);
        hash = 59 * hash + Objects.hashCode(this.turma);
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
        final Atividade other = (Atividade) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atividade{" + "id=" + id + ", descricao=" + descricao + ", data=" + data + ", turma=" + turma + '}';
    }

}
