package br.edu.ifpb.dac.projeto.json.entidades;

import br.edu.ifpb.dac.projeto.json.entidades.Aula;
import br.edu.ifpb.dac.projeto.json.entidades.Turma;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T12:55:45")
@StaticMetamodel(Professor.class)
public class Professor_ { 

    public static volatile SingularAttribute<Professor, Integer> codigo;
    public static volatile SingularAttribute<Professor, String> regime;
    public static volatile ListAttribute<Professor, Turma> turmas;
    public static volatile ListAttribute<Professor, Aula> aulas;
    public static volatile SingularAttribute<Professor, String> vinculo;
    public static volatile SingularAttribute<Professor, String> nome;
    public static volatile SingularAttribute<Professor, String> unidade;
    public static volatile SingularAttribute<Professor, String> email;

}