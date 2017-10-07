package br.edu.ifpb.dac.projeto.json.entidades;

import br.edu.ifpb.dac.projeto.json.entidades.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T12:55:45")
@StaticMetamodel(Disciplina.class)
public class Disciplina_ { 

    public static volatile SingularAttribute<Disciplina, Integer> carga_horaria;
    public static volatile SingularAttribute<Disciplina, Integer> codigo;
    public static volatile SingularAttribute<Disciplina, String> abreviacao;
    public static volatile SingularAttribute<Disciplina, Integer> periodo;
    public static volatile SingularAttribute<Disciplina, Curso> curso;
    public static volatile SingularAttribute<Disciplina, Integer> aulas_semana;
    public static volatile SingularAttribute<Disciplina, String> descricao;

}