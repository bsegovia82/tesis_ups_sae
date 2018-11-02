package edu.sae.modulo.librerias.dominio.entidades.generales;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GenQuery.class)
public abstract class GenQuery_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<GenQuery, String> descripcion;
	public static volatile SingularAttribute<GenQuery, String> query;
	public static volatile SingularAttribute<GenQuery, GenTiposQuery> genTiposQuery;
	public static volatile SingularAttribute<GenQuery, Long> id;

}

