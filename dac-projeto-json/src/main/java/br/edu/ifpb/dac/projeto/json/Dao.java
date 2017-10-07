package br.edu.ifpb.dac.projeto.json;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Curso;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Laboratorio;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Sala;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Semestre;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import javax.persistence.EntityManager;

/**
 *
 * @author Edilva
 */
public class Dao {

    private EntityManager manager;

    public Dao() {
        manager = ProdutorEntityManager.criaEntityManager();
    }

    public void salvarProfessor(Professor professor) {
        manager.getTransaction().begin();
        manager.persist(professor);
        manager.getTransaction().commit();
    }
    
    public Professor getProfessor(int codigo){
        return manager.find(Professor.class, codigo);
    }
    
    public void salvarSala(Sala sala) {
        manager.getTransaction().begin();
        manager.persist(sala);
        manager.getTransaction().commit();
    }
    
    public Sala getSala(int codigo){
        return manager.find(Sala.class, codigo);
    }
    
    public void salvarLaboratorio(Laboratorio laboratorio) {
        manager.getTransaction().begin();
        manager.persist(laboratorio);
        manager.getTransaction().commit();
    }
    
    public Laboratorio getLaboratorio(int codigo){
        return manager.find(Laboratorio.class, codigo);
    }
    
    public void salvarCurso(Curso curso) {
        manager.getTransaction().begin();
        manager.persist(curso);
        manager.getTransaction().commit();
    }
    
    public Curso getCurso(int codigo){
        return manager.find(Curso.class, codigo);
    }
    
    public void salvarDisciplina(Disciplina disciplina) {
        manager.getTransaction().begin();
        manager.persist(disciplina);
        manager.getTransaction().commit();
    }
    
    public Disciplina getDisciplina(int codigo){
        return manager.find(Disciplina.class, codigo);
    }
    
    public void salvarSemestre(Semestre semestre) {
        manager.getTransaction().begin();
        manager.persist(semestre);
        manager.getTransaction().commit();
    }
    
    public Semestre getSemestre(int codigo){
        return manager.find(Semestre.class, codigo);
    }
    
    public void salvarTurma(Turma turma) {
        manager.getTransaction().begin();
        manager.persist(turma);
        manager.getTransaction().commit();
    }
    
    public Turma getTurma(int codigo){
        return manager.find(Turma.class, codigo);
    }
    
    public void salvarAula(Aula aula) {
        manager.getTransaction().begin();
        manager.persist(aula);
        manager.getTransaction().commit();
    }
    
    public Aula getAula(int codigo){
        return manager.find(Aula.class, codigo);
    }
    
    public void salvarHorario(Horario horario) {
        manager.getTransaction().begin();
        manager.persist(horario);
        manager.getTransaction().commit();
    }
    
    public Horario getHorario(int codigo){
        return manager.find(Horario.class, codigo);
    }
    
    public void finalizaConexao(){
        ProdutorEntityManager.finaliza(manager);
    }
}
