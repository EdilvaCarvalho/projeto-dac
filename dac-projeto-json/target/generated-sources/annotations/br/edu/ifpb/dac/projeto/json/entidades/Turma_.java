package br.edu.ifpb.dac.projeto.json.entidades;

import br.edu.ifpb.dac.projeto.json.entidades.Curso;
import br.edu.ifpb.dac.projeto.json.entidades.Professor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T12:55:45")
@StaticMetamodel(Turma.class)
public class Turma_ { 

    public static volatile SingularAttribute<Turma, Integer> codigo;
    public static volatile SingularAttribute<Turma, Professor> professor;
    public static volatile SingularAttribute<Turma, String> identificacao;
    public static volatile SingularAttribute<Turma, Curso> curso;
    public static volatile SingularAttribute<Turma, String> disciplina;

}