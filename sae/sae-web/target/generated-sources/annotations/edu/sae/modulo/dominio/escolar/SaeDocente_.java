package edu.sae.modulo.dominio.escolar;

import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.dominio.empresa.OmsoCargo;
import edu.sae.modulo.dominio.empresa.OmsoEspecialidad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SaeDocente.class)
public abstract class SaeDocente_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile ListAttribute<SaeDocente, SaeDocente> subOrdinados;
	public static volatile SingularAttribute<SaeDocente, OmsgPersona> persona;
	public static volatile SingularAttribute<SaeDocente, String> codigoEmpleado;
	public static volatile SingularAttribute<SaeDocente, Date> fechaInicio;
	public static volatile SingularAttribute<SaeDocente, Long> id;
	public static volatile SingularAttribute<SaeDocente, SaeDocente> jefe;
	public static volatile SingularAttribute<SaeDocente, OmsoCargo> cargo;
	public static volatile SingularAttribute<SaeDocente, Date> fechaFin;
	public static volatile SingularAttribute<SaeDocente, OmsoEspecialidad> especialidad;

}

