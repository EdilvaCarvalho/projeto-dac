package br.edu.ifpb.dac.projeto.json.entidades;

import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T12:55:45")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Integer> hor_cod;
    public static volatile SingularAttribute<Horario, LocalTime> hor_fim;
    public static volatile SingularAttribute<Horario, String> hor_desc;
    public static volatile SingularAttribute<Horario, LocalTime> hor_inicio;

}