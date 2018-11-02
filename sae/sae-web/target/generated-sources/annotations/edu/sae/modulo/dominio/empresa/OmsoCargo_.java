package edu.sae.modulo.dominio.empresa;

import edu.sae.modulo.dominio.aplicacion.OmsRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OmsoCargo.class)
public abstract class OmsoCargo_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<OmsoCargo, String> nombreCargo;
	public static volatile SingularAttribute<OmsoCargo, OmsRole> rolDefault;
	public static volatile SingularAttribute<OmsoCargo, Long> id;

}

