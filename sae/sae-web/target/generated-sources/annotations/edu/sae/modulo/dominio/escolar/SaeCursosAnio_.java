package edu.sae.modulo.dominio.escolar;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SaeCursosAnio.class)
public abstract class SaeCursosAnio_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<SaeCursosAnio, SaeCurso> lCurso;
	public static volatile SingularAttribute<SaeCursosAnio, String> lNombreAsignacion;
	public static volatile SingularAttribute<SaeCursosAnio, Long> id;
	public static volatile SingularAttribute<SaeCursosAnio, SaeAnioLectivo> lAnioLectivo;

}

