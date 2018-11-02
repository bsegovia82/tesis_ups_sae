package edu.sae.modulo.dominio.aplicacion;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OmsUsuario.class)
public abstract class OmsUsuario_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<OmsUsuario, String> clave;
	public static volatile ListAttribute<OmsUsuario, OmsUsuariosRole> priUsuariosRoles;
	public static volatile SingularAttribute<OmsUsuario, String> correo;
	public static volatile SingularAttribute<OmsUsuario, String> lTokenRecuperacionClave;
	public static volatile SingularAttribute<OmsUsuario, Date> lFechaVencimiento;
	public static volatile SingularAttribute<OmsUsuario, String> lDescripcion;
	public static volatile SingularAttribute<OmsUsuario, String> usuario;
	public static volatile SingularAttribute<OmsUsuario, Long> id;
	public static volatile SingularAttribute<OmsUsuario, String> esNuevo;
	public static volatile SingularAttribute<OmsUsuario, Date> lFechaSolicitudClave;
	public static volatile SingularAttribute<OmsUsuario, String> rolPrincipal;
	public static volatile SingularAttribute<OmsUsuario, byte[]> imagenReferencia;

}

