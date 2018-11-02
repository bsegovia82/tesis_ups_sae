package edu.sae.modulo.dominio.escolar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name="SAE_CURSO")
public class SaeCurso extends EntidadBaseAuditable<Long> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lNombreCurso;  
	
	@GeneratedValue(generator = "secCurso", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secCurso", allocationSize = 1, initialValue = 1, sequenceName = "SEC_CURSO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);
	}

	public String getlNombreCurso() {
		return lNombreCurso;
	}

	public void setlNombreCurso(String lNombreCurso) {
		this.lNombreCurso = lNombreCurso;
	}
	
	@Override
	public String toString() {
		return lNombreCurso;
	}

}
