package br.edu.ifpb.dac.projeto.json.entidades;

import br.edu.ifpb.dac.projeto.json.entidades.Curso;
import br.edu.ifpb.dac.projeto.json.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.json.entidades.Horario;
import br.edu.ifpb.dac.projeto.json.entidades.Laboratorio;
import br.edu.ifpb.dac.projeto.json.entidades.Professor;
import br.edu.ifpb.dac.projeto.json.entidades.Sala;
import br.edu.ifpb.dac.projeto.json.entidades.Semestre;
import br.edu.ifpb.dac.projeto.json.entidades.Turma;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T12:55:45")
@StaticMetamodel(Aula.class)
public class Aula_ { 

    public static volatile SingularAttribute<Aula, Integer> codigo;
    public static volatile SingularAttribute<Aula, Professor> professor;
    public static volatile SingularAttribute<Aula, Horario> horario;
    public static volatile SingularAttribute<Aula, Curso> curso;
    public static volatile SingularAttribute<Aula, Sala> sala;
    public static volatile SingularAttribute<Aula, String> dia_desc;
    public static volatile SingularAttribute<Aula, Disciplina> disciplina;
    public static volatile SingularAttribute<Aula, Integer> dia_abrev;
    public static volatile SingularAttribute<Aula, Laboratorio> laboratorio;
    public static volatile SingularAttribute<Aula, Turma> turma;
    public static volatile SingularAttribute<Aula, Semestre> semestre;

}