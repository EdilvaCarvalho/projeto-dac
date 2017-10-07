package br.edu.ifpb.dac.projeto.json.entidades;

import br.edu.ifpb.dac.projeto.json.entidades.Aula;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T12:55:45")
@StaticMetamodel(Sala.class)
public class Sala_ { 

    public static volatile SingularAttribute<Sala, Integer> codigo;
    public static volatile SingularAttribute<Sala, String> abreviacao;
    public static volatile ListAttribute<Sala, Aula> aulas;
    public static volatile SingularAttribute<Sala, String> descricao;

}