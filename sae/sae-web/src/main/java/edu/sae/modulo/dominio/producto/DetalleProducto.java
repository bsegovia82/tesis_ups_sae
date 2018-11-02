package edu.sae.modulo.dominio.producto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "ONIX_DETALLE_PRODUCTO")
@NamedQuery(name = "DetalleProducto.findAll", query = "SELECT p FROM DetalleProducto p")
public class DetalleProducto extends EntidadBaseAuditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Producto lProducto;
	private TiposDetalles lTipoDetalle;
	private Double lPrecio;
	private String lLunes;
	private String lMartes;
	private String lMiercoles;
	private String lJuves;
	private String lViernes;
	private String lSabado;
	private String lDomingo;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "FactDetProducto", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "FactDetProducto", allocationSize = 1, initialValue = 1, sequenceName = "SEC_POS_DET_PRODUCTO")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);
	}

	@ManyToOne
	@JoinColumn(name = "ID_PRODUCTO")
	public Producto getlProducto() {
		return lProducto;
	}

	public void setlProducto(Producto lProducto) {
		this.lProducto = lProducto;
	}

	@ManyToOne
	@JoinColumn(name = "ID_DETALLE")
	public TiposDetalles getlTipoDetalle() {
		return lTipoDetalle;
	}

	public void setlTipoDetalle(TiposDetalles lTipoDetalle) {
		this.lTipoDetalle = lTipoDetalle;
	}

	public Double getlPrecio() {
		return lPrecio;
	}

	public void setlPrecio(Double lPrecio) {
		this.lPrecio = lPrecio;
	}

	public String getlLunes() {
		return lLunes;
	}

	public void setlLunes(String lLunes) {
		this.lLunes = lLunes;
	}

	public String getlMartes() {
		return lMartes;
	}

	public void setlMartes(String lMartes) {
		this.lMartes = lMartes;
	}

	public String getlMiercoles() {
		return lMiercoles;
	}

	public void setlMiercoles(String lMiercoles) {
		this.lMiercoles = lMiercoles;
	}

	public String getlJuves() {
		return lJuves;
	}

	public void setlJuves(String lJuves) {
		this.lJuves = lJuves;
	}

	public String getlViernes() {
		return lViernes;
	}

	public void setlViernes(String lViernes) {
		this.lViernes = lViernes;
	}

	public String getlSabado() {
		return lSabado;
	}

	public void setlSabado(String lSabado) {
		this.lSabado = lSabado;
	}

	public String getlDomingo() {
		return lDomingo;
	}

	public void setlDomingo(String lDomingo) {
		this.lDomingo = lDomingo;
	}

	@Transient
	public String getDias() {
		return (lLunes==null || "null".equals(lLunes) ?"":lLunes) + " - " + (lMartes==null || "null".equals(lMartes) ?"":lMartes) + " - " + 
	(lMiercoles==null || "null".equals(lMiercoles) ?"":lMiercoles) + " - " + 
	(lJuves==null || "null".equals(lJuves) ?"":lJuves) + " - " + 
	(lViernes==null || "null".equals(lViernes) ?"":lViernes) + " - " + 
	(lSabado==null || "null".equals(lSabado) ?"":lSabado)
				+ " - " + (lDomingo==null || "null".equals(lDomingo) ?"":lDomingo);
	}

}
