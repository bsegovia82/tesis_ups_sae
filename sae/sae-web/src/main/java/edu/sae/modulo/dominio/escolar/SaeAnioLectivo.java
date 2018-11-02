package edu.sae.modulo.dominio.escolar;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name="SAE_ANIO_LECTIVO")
public class SaeAnioLectivo extends EntidadBaseAuditable<Long> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lAnio;
	private String lPeriodo;
	private String lRegion;
	private Date lFechaInicio;
	private Date lFechaFin;
	

	@GeneratedValue(generator = "secAnio", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secAnio", allocationSize = 1, initialValue = 1, sequenceName = "SEC_ANIO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);
	}

	public String getlAnio() {
		return lAnio;
	}

	public void setlAnio(String lAnio) {
		this.lAnio = lAnio;
	}

	public String getlPeriodo() {
		return lPeriodo;
	}

	public void setlPeriodo(String lPeriodo) {
		this.lPeriodo = lPeriodo;
	}

	public String getlRegion() {
		return lRegion;
	}

	public void setlRegion(String lRegion) {
		this.lRegion = lRegion;
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
	
	

}
