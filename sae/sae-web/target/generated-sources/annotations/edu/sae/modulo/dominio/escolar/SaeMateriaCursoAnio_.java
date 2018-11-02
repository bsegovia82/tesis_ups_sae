package edu.sae.modulo.dominio.escolar;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SaeMateriaCursoAnio.class)
public abstract class SaeMateriaCursoAnio_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<SaeMateriaCursoAnio, SaeDocente> lDocente;
	public static volatile SingularAttribute<SaeMateriaCursoAnio, SaeTipoCalificacion> lTipoCalificacion;
	public static volatile SingularAttribute<SaeMateriaCursoAnio, Long> id;
	public static volatile SingularAttribute<SaeMateriaCursoAnio, SaeCursosAnio> lCursoAnio;
	public static volatile SingularAttribute<SaeMateriaCursoAnio, SaeMateria> lMateria;

}

