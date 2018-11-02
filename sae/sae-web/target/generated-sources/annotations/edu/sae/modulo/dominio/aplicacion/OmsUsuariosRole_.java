package edu.sae.modulo.dominio.aplicacion;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OmsUsuariosRole.class)
public abstract class OmsUsuariosRole_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<OmsUsuariosRole, String> descripcion;
	public static volatile SingularAttribute<OmsUsuariosRole, OmsUsuario> priUsuario;
	public static volatile SingularAttribute<OmsUsuariosRole, Long> id;
	public static volatile SingularAttribute<OmsUsuariosRole, OmsRole> priRole;

}

