package edu.sae.modulo.librerias.dominio.entidades.generales;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GenTiposQuery.class)
public abstract class GenTiposQuery_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<GenTiposQuery, String> descripcion;
	public static volatile SingularAttribute<GenTiposQuery, Long> id;
	public static volatile SingularAttribute<GenTiposQuery, String> nombre;
	public static volatile ListAttribute<GenTiposQuery, GenQuery> genQuerys;

}

