package edu.sae.modulo.dominio.escolar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "SAE_NOTAS_EXAMEN")
public class SaeNotasExamen  extends EntidadBaseAuditable<Long> implements Serializable
{

	private static final long serialVersionUID = 1L;
	private SaeEstudiante lEstudiante;
	private SaeMateriaCursoAnio lMateriaCursoAnio;
	private SaeCursosAnio lCursoAnio;
	private String lNotaExamen;
	
	private SaeDocente lDocente;
	private SaeAnioLectivo lAnioLectivo;
	
	@GeneratedValue(generator = "secNotaExamen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secNotaExamen", allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_NOTAS_EXAMEN")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);
	}

	@ManyToOne
	@JoinColumn(name = "ID_ESTUDIANTE")
	public SaeEstudiante getlEstudiante() {
		return lEstudiante;
	}

	public void setlEstudiante(SaeEstudiante lEstudiante) {
		this.lEstudiante = lEstudiante;
	}

	@ManyToOne
	@JoinColumn(name = "ID_MATERIA_CURSO_ANIO")
	public SaeMateriaCursoAnio getlMateriaCursoAnio() {
		return lMateriaCursoAnio;
	}

	public void setlMateriaCursoAnio(SaeMateriaCursoAnio lMateriaCursoAnio) {
		this.lMateriaCursoAnio = lMateriaCursoAnio;
	}

	
	@ManyToOne
	@JoinColumn(name = "ID_DOCENTE")
	public SaeDocente getlDocente() {
		return lDocente;
	}

	public void setlDocente(SaeDocente lDocente) {
		this.lDocente = lDocente;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CURSO_ANIO")
	public SaeCursosAnio getlCursoAnio() {
		return lCursoAnio;
	}

	public void setlCursoAnio(SaeCursosAnio lCursoAnio) {
		this.lCursoAnio = lCursoAnio;
	}

	@ManyToOne
	@JoinColumn(name = "ID_ANIO")
	public SaeAnioLectivo getlAnioLectivo() {
		return lAnioLectivo;
	}

	public void setlAnioLectivo(SaeAnioLectivo lAnioLectivo) {
		this.lAnioLectivo = lAnioLectivo;
	}

	public String getlNotaExamen() {
		return lNotaExamen;
	}

	public void setlNotaExamen(String lNotaExamen) {
		this.lNotaExamen = lNotaExamen;
	}

		
	
}