package edu.sae.modulo.dominio.empresa;

import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OmsgPersona.class)
public abstract class OmsgPersona_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<OmsgPersona, String> apellidos;
	public static volatile SingularAttribute<OmsgPersona, Date> fechaNacimiento;
	public static volatile SingularAttribute<OmsgPersona, String> ocupacion;
	public static volatile SingularAttribute<OmsgPersona, String> nombres;
	public static volatile SingularAttribute<OmsgPersona, String> razonSocial;
	public static volatile SingularAttribute<OmsgPersona, String> genero;
	public static volatile SingularAttribute<OmsgPersona, OmsUsuario> usuario;
	public static volatile SingularAttribute<OmsgPersona, String> direccionCorreo;
	public static volatile SingularAttribute<OmsgPersona, String> direccionPrincipal;
	public static volatile SingularAttribute<OmsgPersona, Long> id;
	public static volatile SingularAttribute<OmsgPersona, String> numeroDocumento;
	public static volatile SingularAttribute<OmsgPersona, OmsgTipoDocumentoIdentificacion> tipoDocumentoIdentificacion;
	public static volatile SingularAttribute<OmsgPersona, String> telefonoContacto;

}

