package edu.sae.modulo.dominio.escolar;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SaeMatricula.class)
public abstract class SaeMatricula_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<SaeMatricula, Date> lFechaInicio;
	public static volatile SingularAttribute<SaeMatricula, Date> lFechaFin;
	public static volatile SingularAttribute<SaeMatricula, Long> id;
	public static volatile SingularAttribute<SaeMatricula, SaeAnioLectivo> lAnioLectivo;
	public static volatile SingularAttribute<SaeMatricula, SaeEstudiante> lEstudiante;
	public static volatile SingularAttribute<SaeMatricula, SaeCursosAnio> lCursoAnio;

}

