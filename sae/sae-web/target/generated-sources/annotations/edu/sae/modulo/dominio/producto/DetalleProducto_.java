package edu.sae.modulo.dominio.producto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleProducto.class)
public abstract class DetalleProducto_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<DetalleProducto, String> lMartes;
	public static volatile SingularAttribute<DetalleProducto, String> lDomingo;
	public static volatile SingularAttribute<DetalleProducto, String> lLunes;
	public static volatile SingularAttribute<DetalleProducto, TiposDetalles> lTipoDetalle;
	public static volatile SingularAttribute<DetalleProducto, Double> lPrecio;
	public static volatile SingularAttribute<DetalleProducto, String> lMiercoles;
	public static volatile SingularAttribute<DetalleProducto, String> lJuves;
	public static volatile SingularAttribute<DetalleProducto, String> lViernes;
	public static volatile SingularAttribute<DetalleProducto, Producto> lProducto;
	public static volatile SingularAttribute<DetalleProducto, Long> id;
	public static volatile SingularAttribute<DetalleProducto, String> lSabado;

}

