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
@Table(name = "SAE_NOTAS_ESTUDIANTES")
public class SaeNotasEstudiante  extends EntidadBaseAuditable<Long> implements Serializable
{

	private static final long serialVersionUID = 1L;
	private SaeEstudiante lEstudiante;
	private SaeMateriaCursoAnio lMateriaCursoAnio;
	private SaeCursosAnio lCursoAnio;
	private String lNotaAporte;
	
	private String lNotaPT1;
	private String lNotaPT2;
	private String lNotaPT3;
	private String lNotaPT4;
	
	private String lNotaPI1;
	private String lNotaPI2;
	private String lNotaPI3;
	private String lNotaPI4;

	private String lNotaPG1;
	private String lNotaPG2;
	private String lNotaPG3;
	private String lNotaPG4;
	
	private String lNotaPL1;
	private String lNotaPL2;
	private String lNotaPL3;
	private String lNotaPL4;
	
	
	private String lRecomendacion;
	private String lQuimestreTrimestre;
	private SaeDocente lDocente;
	private SaeAnioLectivo lAnioLectivo;
	private SaeTipoItemsCalificables lTipoItem;
	
	@GeneratedValue(generator = "secNotaEstudiantes", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secNotaEstudiantes", allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_NOTAS_ESTUDIANTE")
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

	
	public String getlRecomendacion() {
		return lRecomendacion;
	}

	public void setlRecomendacion(String lRecomendacion) {
		this.lRecomendacion = lRecomendacion;
	}

	public String getlQuimestreTrimestre() {
		return lQuimestreTrimestre;
	}

	public void setlQuimestreTrimestre(String lQuimestreTrimestre) {
		this.lQuimestreTrimestre = lQuimestreTrimestre;
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

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_ITEM")
	public SaeTipoItemsCalificables getlTipoItem() {
		return lTipoItem;
	}

	public void setlTipoItem(SaeTipoItemsCalificables lTipoItem) {
		this.lTipoItem = lTipoItem;
	}

	public String getlNotaAporte() {
		return lNotaAporte;
	}

	public void setlNotaAporte(String lNotaAporte) {
		this.lNotaAporte = lNotaAporte;
	}

	public String getlNotaPT1() {
		return lNotaPT1;
	}

	public void setlNotaPT1(String lNotaPT1) {
		this.lNotaPT1 = lNotaPT1;
	}

	public String getlNotaPT2() {
		return lNotaPT2;
	}

	public void setlNotaPT2(String lNotaPT2) {
		this.lNotaPT2 = lNotaPT2;
	}

	public String getlNotaPT3() {
		return lNotaPT3;
	}

	public void setlNotaPT3(String lNotaPT3) {
		this.lNotaPT3 = lNotaPT3;
	}

	public String getlNotaPT4() {
		return lNotaPT4;
	}

	public void setlNotaPT4(String lNotaPT4) {
		this.lNotaPT4 = lNotaPT4;
	}

	public String getlNotaPI1() {
		return lNotaPI1;
	}

	public void setlNotaPI1(String lNotaPI1) {
		this.lNotaPI1 = lNotaPI1;
	}

	public String getlNotaPI2() {
		return lNotaPI2;
	}

	public void setlNotaPI2(String lNotaPI2) {
		this.lNotaPI2 = lNotaPI2;
	}

	public String getlNotaPI3() {
		return lNotaPI3;
	}

	public void setlNotaPI3(String lNotaPI3) {
		this.lNotaPI3 = lNotaPI3;
	}

	public String getlNotaPI4() {
		return lNotaPI4;
	}

	public void setlNotaPI4(String lNotaPI4) {
		this.lNotaPI4 = lNotaPI4;
	}

	public String getlNotaPG1() {
		return lNotaPG1;
	}

	public void setlNotaPG1(String lNotaPG1) {
		this.lNotaPG1 = lNotaPG1;
	}

	public String getlNotaPG2() {
		return lNotaPG2;
	}

	public void setlNotaPG2(String lNotaPG2) {
		this.lNotaPG2 = lNotaPG2;
	}

	public String getlNotaPG3() {
		return lNotaPG3;
	}

	public void setlNotaPG3(String lNotaPG3) {
		this.lNotaPG3 = lNotaPG3;
	}

	public String getlNotaPG4() {
		return lNotaPG4;
	}

	public void setlNotaPG4(String lNotaPG4) {
		this.lNotaPG4 = lNotaPG4;
	}

	public String getlNotaPL1() {
		return lNotaPL1;
	}

	public void setlNotaPL1(String lNotaPL1) {
		this.lNotaPL1 = lNotaPL1;
	}

	public String getlNotaPL2() {
		return lNotaPL2;
	}

	public void setlNotaPL2(String lNotaPL2) {
		this.lNotaPL2 = lNotaPL2;
	}

	public String getlNotaPL3() {
		return lNotaPL3;
	}

	public void setlNotaPL3(String lNotaPL3) {
		this.lNotaPL3 = lNotaPL3;
	}

	public String getlNotaPL4() {
		return lNotaPL4;
	}

	public void setlNotaPL4(String lNotaPL4) {
		this.lNotaPL4 = lNotaPL4;
	}
	
	
	
}
