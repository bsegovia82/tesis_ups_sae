package edu.sae.modulo.dominio.producto;

import java.io.Serializable;
import javax.persistence.*;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="ONIX_PRODUCTO")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto extends EntidadBaseAuditable<Long> implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	
	private String lCodigoProducto;
	
	private Integer lAniosServicio;
	
	private String lDescripcion;

	private Double lExistencia;

	private String lNombre;

	private Double lPrecioUnitario;

	private Integer lImpuestoIva;
	
	private Integer lImpuestoIce;
	
	private String lDetallesAdicionales;
	
	private String lCodigoIva;
	
	private String lCodigoICE;

	public Producto() {
	}
	
	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(generator = "FactProducto", strategy = GenerationType.SEQUENCE)
   	@SequenceGenerator(name = "FactProducto", allocationSize = 1, initialValue = 1, 
   	sequenceName = "SEC_POS_PRODUCTO")  
	public Long getId() {
		return id;
	}	
	
	public String getlDescripcion() {
		return lDescripcion;
	}

	public void setlDescripcion(String lDescripcion) {
		this.lDescripcion = lDescripcion;
	}

	public Double getlExistencia() {
		return lExistencia;
	}

	public void setlExistencia(Double lExistencia) {
		this.lExistencia = lExistencia;
	}

	public String getlNombre() {
		return lNombre;
	}

	public void setlNombre(String lNombre) {
		this.lNombre = lNombre;
	}

	public Double getlPrecioUnitario() {
		return lPrecioUnitario;
	}

	public void setlPrecioUnitario(Double lPrecioUnitario) {
		this.lPrecioUnitario = lPrecioUnitario;
	}

	public Integer getlImpuestoIva() {
		return lImpuestoIva;
	}

	public void setlImpuestoIva(Integer lImpuestoIva) {
		this.lImpuestoIva = lImpuestoIva;
	}

	public Integer getlImpuestoIce() {
		return lImpuestoIce;
	}

	public void setlImpuestoIce(Integer lImpuestoIce) {
		this.lImpuestoIce = lImpuestoIce;
	}


	public String getlCodigoProducto() {
		return lCodigoProducto;
	}

	public void setlCodigoProducto(String lCodigoProducto) {
		this.lCodigoProducto = lCodigoProducto;
	}

	public String getlDetallesAdicionales() {
		return lDetallesAdicionales;
	}

	public void setlDetallesAdicionales(String lDetallesAdicionales) {
		this.lDetallesAdicionales = lDetallesAdicionales;
	}

	public String getlCodigoIva() {
		return lCodigoIva;
	}

	public void setlCodigoIva(String lCodigoIva) {
		this.lCodigoIva = lCodigoIva;
	}

	public String getlCodigoICE() {
		return lCodigoICE;
	}

	public void setlCodigoICE(String lCodigoICE) {
		this.lCodigoICE = lCodigoICE;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
		
	}

	public Integer getlAniosServicio() {
		return lAniosServicio;
	}

	public void setlAniosServicio(Integer lAniosServicio) {
		this.lAniosServicio = lAniosServicio;
	}
		
	
	
	
}