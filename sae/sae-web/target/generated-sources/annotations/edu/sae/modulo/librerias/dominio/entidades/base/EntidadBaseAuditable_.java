package edu.sae.modulo.librerias.dominio.entidades.base;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EntidadBaseAuditable.class)
public abstract class EntidadBaseAuditable_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBase_ {

	public static volatile SingularAttribute<EntidadBaseAuditable, Date> fechaRegistro;
	public static volatile SingularAttribute<EntidadBaseAuditable, Date> fechaActualizacion;
	public static volatile SingularAttribute<EntidadBaseAuditable, String> auditoria;
	public static volatile SingularAttribute<EntidadBaseAuditable, String> observacion;

}

