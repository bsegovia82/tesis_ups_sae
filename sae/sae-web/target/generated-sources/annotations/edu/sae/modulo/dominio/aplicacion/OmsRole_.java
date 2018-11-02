package edu.sae.modulo.dominio.aplicacion;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OmsRole.class)
public abstract class OmsRole_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<OmsRole, String> seleccionable;
	public static volatile ListAttribute<OmsRole, OmsUsuariosRole> priUsuariosRoles;
	public static volatile ListAttribute<OmsRole, OmsOpcionesRole> listaOpcionesRoles;
	public static volatile SingularAttribute<OmsRole, String> tipoRol;
	public static volatile SingularAttribute<OmsRole, String> aplicaAud;
	public static volatile SingularAttribute<OmsRole, String> ambito;
	public static volatile SingularAttribute<OmsRole, Long> id;
	public static volatile SingularAttribute<OmsRole, String> lPaginaPrincipal;
	public static volatile SingularAttribute<OmsRole, String> rol;

}

