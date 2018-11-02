package edu.sae.modulo.dominio.escolar;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SaeAnioLectivo.class)
public abstract class SaeAnioLectivo_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<SaeAnioLectivo, String> lPeriodo;
	public static volatile SingularAttribute<SaeAnioLectivo, Date> lFechaInicio;
	public static volatile SingularAttribute<SaeAnioLectivo, Date> lFechaFin;
	public static volatile SingularAttribute<SaeAnioLectivo, Long> id;
	public static volatile SingularAttribute<SaeAnioLectivo, String> lAnio;
	public static volatile SingularAttribute<SaeAnioLectivo, String> lRegion;

}

