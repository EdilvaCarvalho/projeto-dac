package br.edu.ifpb.dac.projeto.json.entidades;

import br.edu.ifpb.dac.projeto.json.entidades.Aula;
import br.edu.ifpb.dac.projeto.json.entidades.Disciplina;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T12:55:45")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile ListAttribute<Curso, Disciplina> disciplinas;
    public static volatile SingularAttribute<Curso, Integer> codigo;
    public static volatile SingularAttribute<Curso, String> abreviacao;
    public static volatile ListAttribute<Curso, Aula> aulas;
    public static volatile SingularAttribute<Curso, Integer> periodos;
    public static volatile SingularAttribute<Curso, String> unidade;
    public static volatile SingularAttribute<Curso, String> descricao;

}