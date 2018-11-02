package edu.sae.modulo.dominio.producto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Promociones.class)
public abstract class Promociones_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<Promociones, String> lTitulo;
	public static volatile SingularAttribute<Promociones, Date> lFechaInicio;
	public static volatile SingularAttribute<Promociones, Date> lFechaFin;
	public static volatile SingularAttribute<Promociones, Long> id;
	public static volatile SingularAttribute<Promociones, String> lMensaje;
	public static volatile SingularAttribute<Promociones, byte[]> imagenReferencia;

}

