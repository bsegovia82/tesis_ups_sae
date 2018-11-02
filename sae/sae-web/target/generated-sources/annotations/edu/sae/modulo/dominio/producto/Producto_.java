package edu.sae.modulo.dominio.producto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ extends edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable_ {

	public static volatile SingularAttribute<Producto, Double> lExistencia;
	public static volatile SingularAttribute<Producto, String> lCodigoICE;
	public static volatile SingularAttribute<Producto, Integer> lImpuestoIva;
	public static volatile SingularAttribute<Producto, Double> lPrecioUnitario;
	public static volatile SingularAttribute<Producto, Integer> lAniosServicio;
	public static volatile SingularAttribute<Producto, String> lDescripcion;
	public static volatile SingularAttribute<Producto, String> lCodigoProducto;
	public static volatile SingularAttribute<Producto, Long> id;
	public static volatile SingularAttribute<Producto, String> lDetallesAdicionales;
	public static volatile SingularAttribute<Producto, Integer> lImpuestoIce;
	public static volatile SingularAttribute<Producto, String> lCodigoIva;
	public static volatile SingularAttribute<Producto, String> lNombre;

}

