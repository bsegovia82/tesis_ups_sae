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
@Table(name = "SAE_MATERIA")
public class SaeMateria extends EntidadBaseAuditable<Long> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String lDescripcionMateria;
	
	
	@GeneratedValue(generator = "secMateria", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secMateria", allocationSize = 1, initialValue = 1, sequenceName = "SEC_MATERIA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);
	}

	public String getlDescripcionMateria() {
		return lDescripcionMateria;
	}

	public void setlDescripcionMateria(String lDescripcionMateria) {
		this.lDescripcionMateria = lDescripcionMateria;
	}

	
	
}
