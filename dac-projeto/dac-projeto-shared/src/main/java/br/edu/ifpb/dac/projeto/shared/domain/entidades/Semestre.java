package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Edilva
 */
@Entity
public class Semestre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sem_cod;
    private int sem_ano;
    private int sem_per;
    private int sem_ativo;

    public Semestre() {
    }

    public Semestre(int sem_ano, int sem_per, int sem_ativo) {
        this.sem_ano = sem_ano;
        this.sem_per = sem_per;
        this.sem_ativo = sem_ativo;
    }

    public Semestre(int sem_cod, int sem_ano, int sem_per, int sem_ativo) {
        this.sem_cod = sem_cod;
        this.sem_ano = sem_ano;
        this.sem_per = sem_per;
        this.sem_ativo = sem_ativo;
    }

    public int getSem_cod() {
        return sem_cod;
    }

    public void setSem_cod(int sem_cod) {
        this.sem_cod = sem_cod;
    }

    public int getSem_ano() {
        return sem_ano;
    }

    public void setSem_ano(int sem_ano) {
        this.sem_ano = sem_ano;
    }

    public int getSem_per() {
        return sem_per;
    }

    public void setSem_per(int sem_per) {
        this.sem_per = sem_per;
    }

    public int getSem_ativo() {
        return sem_ativo;
    }

    public void setSem_ativo(int sem_ativo) {
        this.sem_ativo = sem_ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.sem_cod;
        hash = 11 * hash + this.sem_ano;
        hash = 11 * hash + this.sem_per;
        hash = 11 * hash + this.sem_ativo;
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
        final Semestre other = (Semestre) obj;
        if (this.sem_cod != other.sem_cod) {
            return false;
        }
        if (this.sem_ano != other.sem_ano) {
            return false;
        }
        if (this.sem_per != other.sem_per) {
            return false;
        }
        if (this.sem_ativo != other.sem_ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Semestre{" + "sem_cod=" + sem_cod + ", sem_ano=" + sem_ano + ", sem_per=" + sem_per + ", sem_ativo=" + sem_ativo + '}';
    }

}
