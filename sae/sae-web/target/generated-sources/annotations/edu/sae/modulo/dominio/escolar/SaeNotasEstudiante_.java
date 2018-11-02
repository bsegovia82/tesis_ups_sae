package edu.sae.modulo.dominio.escolar;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SaeNotasEstudiante.class)
public abstract class SaeNotasEstudiante_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<SaeNotasEstudiante, SaeMateriaCursoAnio> lMateriaCursoAnio;
	public static volatile SingularAttribute<SaeNotasEstudiante, Long> id;
	public static volatile SingularAttribute<SaeNotasEstudiante, SaeEstudiante> lEstudiante;

}

