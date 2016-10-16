package ejb;

import ejb.Consultas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-15T16:02:33")
@StaticMetamodel(Pacientes.class)
public class Pacientes_ { 

    public static volatile SingularAttribute<Pacientes, Integer> codpac;
    public static volatile SingularAttribute<Pacientes, String> senha;
    public static volatile SingularAttribute<Pacientes, String> nome;
    public static volatile SingularAttribute<Pacientes, String> usuario;
    public static volatile CollectionAttribute<Pacientes, Consultas> consultasCollection;

}