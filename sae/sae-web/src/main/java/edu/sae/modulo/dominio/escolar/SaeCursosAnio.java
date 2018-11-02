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
@Table(name = "SAE_CURSO_ANIO")
public class SaeCursosAnio extends EntidadBaseAuditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String lNombreAsignacion;
	private SaeAnioLectivo lAnioLectivo;
	private SaeCurso lCurso;

	@GeneratedValue(generator = "secCursoAnio", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secCursoAnio", allocationSize = 1, initialValue = 1, sequenceName = "SEC_CURSO_ANIO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);
	}

	public String getlNombreAsignacion() {
		return lNombreAsignacion;
	}

	public void setlNombreAsignacion(String lNombreAsignacion) {
		this.lNombreAsignacion = lNombreAsignacion;
	}

	@ManyToOne
	@JoinColumn(name = "ID_ANIO")
	public SaeAnioLectivo getlAnioLectivo() {
		return lAnioLectivo;
	}

	public void setlAnioLectivo(SaeAnioLectivo lAnioLectivo) {
		this.lAnioLectivo = lAnioLectivo;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CURSO")
	public SaeCurso getlCurso() {
		return lCurso;
	}

	public void setlCurso(SaeCurso lCurso) {
		this.lCurso = lCurso;
	}

}
