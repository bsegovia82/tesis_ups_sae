package edu.sae.modulo.dominio.producto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name="ONIX_PROMOCIONES")
@NamedQuery(name="Promociones.findAll", query="SELECT p FROM Promociones p")
public class Promociones extends EntidadBaseAuditable<Long> implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	private String lTitulo;
	private String lMensaje;
	private Date lFechaInicio;
	private Date lFechaFin;
	private byte[] imagenReferencia;
	
	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(generator = "Promociones", strategy = GenerationType.SEQUENCE)
   	@SequenceGenerator(name = "Promociones", allocationSize = 1, initialValue = 1, 
   	sequenceName = "SEC_PROMOCIONES")  
	public Long getId() {
		return id;
	}	
	
	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
	}

	public String getlTitulo() {
		return lTitulo;
	}

	public void setlTitulo(String lTitulo) {
		this.lTitulo = lTitulo;
	}

	public String getlMensaje() {
		return lMensaje;
	}

	public void setlMensaje(String lMensaje) {
		this.lMensaje = lMensaje;
	}

	public Date getlFechaInicio() {
		return lFechaInicio;
	}

	public void setlFechaInicio(Date lFechaInicio) {
		this.lFechaInicio = lFechaInicio;
	}

	public Date getlFechaFin() {
		return lFechaFin;
	}

	public void setlFechaFin(Date lFechaFin) {
		this.lFechaFin = lFechaFin;
	}

	@Lob
	public byte[] getImagenReferencia() {
		return imagenReferencia;
	}

	public void setImagenReferencia(byte[] imagenReferencia) {
		this.imagenReferencia = imagenReferencia;
	}
}
