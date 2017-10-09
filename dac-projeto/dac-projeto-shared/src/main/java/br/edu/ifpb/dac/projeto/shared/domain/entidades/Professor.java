package br.edu.ifpb.dac.projeto.shared.domain.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Edilva
 */
@Entity
public class Professor implements Serializable {

    @Id
    private int codigo;
    @Column(length = 80)
    private String nome;
    @Column(length = 30)
    private String unidade;
    @Column(length = 30)
    private String vinculo;
    @Column(length = 30)
    private String regime;
    @Column(length = 80)
    private String email;
    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;
    @OneToMany(mappedBy = "professor")
    private List<Aula> aulas;
    private Usuario usuario;

    public Professor() {
    }

    public Professor(int codigo, String nome, String unidade, String vinculo, String regime, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidade = unidade;
        this.vinculo = vinculo;
        this.regime = regime;
        this.email = email;
    }

    public Professor(int codigo, String nome, String unidade, String vinculo, String regime, String email, List<Turma> turmas, List<Aula> aulas, Usuario usuario) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidade = unidade;
        this.vinculo = vinculo;
        this.regime = regime;
        this.email = email;
        this.turmas = turmas;
        this.aulas = aulas;
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void addAula(Aula aula) {
        this.aulas.add(aula);
        aula.setProfessor(this);
    }

    public void removeAula(Aula aula) {
        this.aulas.remove(aula);
    }

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
        turma.setProfessor(this);
    }

    public void removeTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.unidade);
        hash = 23 * hash + Objects.hashCode(this.vinculo);
        hash = 23 * hash + Objects.hashCode(this.regime);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.turmas);
        hash = 23 * hash + Objects.hashCode(this.aulas);
        hash = 23 * hash + Objects.hashCode(this.usuario);
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
        final Professor other = (Professor) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.unidade, other.unidade)) {
            return false;
        }
        if (!Objects.equals(this.vinculo, other.vinculo)) {
            return false;
        }
        if (!Objects.equals(this.regime, other.regime)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.turmas, other.turmas)) {
            return false;
        }
        if (!Objects.equals(this.aulas, other.aulas)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Professor{" + "codigo=" + codigo + ", nome=" + nome + ", unidade=" + unidade + ", vinculo=" + vinculo + ", regime=" + regime + ", email=" + email + ", turmas=" + turmas + ", aulas=" + aulas + ", usuario=" + usuario + '}';
    }

}
