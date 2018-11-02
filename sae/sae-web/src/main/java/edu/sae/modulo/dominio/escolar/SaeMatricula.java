package edu.sae.modulo.dominio.escolar;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "SAE_MATRICULA")
public class SaeMatricula extends EntidadBaseAuditable<Long> implements Serializable
{
	private static final long serialVersionUID = 1L;

	private SaeAnioLectivo lAnioLectivo;
	private SaeEstudiante lEstudiante;
	private Date lFechaInicio;
	private Date lFechaFin;
	private SaeCursosAnio lCursoAnio;
	
	@GeneratedValue(generator = "secMatricula", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secMatricula", allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_MATRICULA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
	}

	@ManyToOne
	@JoinColumn(name = "ID_ANIO_LECTIVO")
	public SaeAnioLectivo getlAnioLectivo() {
		return lAnioLectivo;
	}

	public void setlAnioLectivo(SaeAnioLectivo lAnioLectivo) {
		this.lAnioLectivo = lAnioLectivo;
	}

	@ManyToOne
	@JoinColumn(name = "ID_ESTUDIANTE")
	public SaeEstudiante getlEstudiante() {
		return lEstudiante;
	}

	public void setlEstudiante(SaeEstudiante lEstudiante) {
		this.lEstudiante = lEstudiante;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INICIO")
	public Date getlFechaInicio() {
		return lFechaInicio;
	}

	public void setlFechaInicio(Date lFechaInicio) {
		this.lFechaInicio = lFechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_FIN")
	public Date getlFechaFin() {
		return lFechaFin;
	}

	public void setlFechaFin(Date lFechaFin) {
		this.lFechaFin = lFechaFin;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CURSO_ANIO")
	public SaeCursosAnio getlCursoAnio() {
		return lCursoAnio;
	}

	public void setlCursoAnio(SaeCursosAnio lCursoAnio) {
		this.lCursoAnio = lCursoAnio;
	}
	
	

}
