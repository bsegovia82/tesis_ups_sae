package edu.sae.modulo.dominio.aplicacion;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OmsOpcione.class)
public abstract class OmsOpcione_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<OmsOpcione, String> accion;
	public static volatile SingularAttribute<OmsOpcione, String> descripcion;
	public static volatile SingularAttribute<OmsOpcione, String> tipo;
	public static volatile SingularAttribute<OmsOpcione, String> opcion;
	public static volatile ListAttribute<OmsOpcione, OmsOpcione> opcionesHijas;
	public static volatile SingularAttribute<OmsOpcione, String> rutaimagen;
	public static volatile SingularAttribute<OmsOpcione, String> orientacion;
	public static volatile SingularAttribute<OmsOpcione, Long> id;
	public static volatile SingularAttribute<OmsOpcione, Long> orden;
	public static volatile SingularAttribute<OmsOpcione, OmsOpcione> moduloPadre;
	public static volatile ListAttribute<OmsOpcione, OmsOpcionesRole> priOpcionesRoles;

}

