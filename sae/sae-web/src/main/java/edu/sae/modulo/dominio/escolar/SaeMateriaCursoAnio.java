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
@Table(name = "SAE_MATERIA_CURSO_ANIO")
public class SaeMateriaCursoAnio extends EntidadBaseAuditable<Long> implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private  SaeCursosAnio lCursoAnio;
	private SaeMateria lMateria;
	private SaeTipoCalificacion lTipoCalificacion;
	private SaeDocente lDocente;

	@GeneratedValue(generator = "secMateriaCursoAnio", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secMateriaCursoAnio", allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_MATERIA_CURSO_ANIO")
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
	@JoinColumn(name="ID_CURSO_ANIO")
	public SaeCursosAnio getlCursoAnio() {
		return lCursoAnio;
	}

	public void setlCursoAnio(SaeCursosAnio lCursoAnio) {
		this.lCursoAnio = lCursoAnio;
	}

	@ManyToOne
	@JoinColumn(name="ID_MATERIA")
	public SaeMateria getlMateria() {
		return lMateria;
	}

	public void setlMateria(SaeMateria lMateria) {
		this.lMateria = lMateria;
	}

	@ManyToOne
	@JoinColumn(name="ID_TIPO_CALIFICACION")
	public SaeTipoCalificacion getlTipoCalificacion() {
		return lTipoCalificacion;
	}

	public void setlTipoCalificacion(SaeTipoCalificacion lTipoCalificacion) {
		this.lTipoCalificacion = lTipoCalificacion;
	}

	@ManyToOne
	@JoinColumn(name="ID_DOCENTE")
	public SaeDocente getlDocente() {
		return lDocente;
	}

	public void setlDocente(SaeDocente lDocente) {
		this.lDocente = lDocente;
	}
	
	

}
