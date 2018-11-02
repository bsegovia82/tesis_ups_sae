package edu.sae.modulo.dominio.aplicacion;

import edu.sae.modulo.dominio.aplicacion.OmsBitacora.TIPO_BITACORA;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OmsBitacora.class)
public abstract class OmsBitacora_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<OmsBitacora, TIPO_BITACORA> lTipoBitacora;
	public static volatile SingularAttribute<OmsBitacora, String> proceso;
	public static volatile SingularAttribute<OmsBitacora, String> usuario;
	public static volatile SingularAttribute<OmsBitacora, Long> id;

}

