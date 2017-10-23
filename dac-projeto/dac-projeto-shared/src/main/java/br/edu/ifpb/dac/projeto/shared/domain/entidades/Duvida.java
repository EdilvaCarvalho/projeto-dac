package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Edilva
 */
@Entity
public class Duvida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200)
    private String pergunta;
    @Column(length = 200)
    private String resposta;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Professor professor;

    public Duvida() {
    }

    public Duvida(String pergunta, String resposta, Usuario usuario, Professor professor) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.usuario = usuario;
        this.professor = professor;
    }

    public Duvida(int id, String pergunta, String resposta, Usuario usuario, Professor professor) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.usuario = usuario;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.pergunta);
        hash = 37 * hash + Objects.hashCode(this.resposta);
        hash = 37 * hash + Objects.hashCode(this.usuario);
        hash = 37 * hash + Objects.hashCode(this.professor);
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
        final Duvida other = (Duvida) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.pergunta, other.pergunta)) {
            return false;
        }
        if (!Objects.equals(this.resposta, other.resposta)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Duvida{" + "id=" + id + ", pergunta=" + pergunta + ", resposta=" + resposta + ", usuario=" + usuario + ", professor=" + professor + '}';
    }

}
