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
@Table(name="SAE_ESPECIALIDAD")
public class SaeEspecialidad extends EntidadBaseAuditable<Long> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lDescripcionEspecialidad;

	@GeneratedValue(generator = "secEspecialidad", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secEspecialidad", allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_ESPECIALIDAD")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		setIdReferencia(idReferencia);
	}

	public String getlDescripcionEspecialidad() {
		return lDescripcionEspecialidad;
	}

	public void setlDescripcionEspecialidad(String lDescripcionEspecialidad) {
		this.lDescripcionEspecialidad = lDescripcionEspecialidad;
	}
	
	
	
}
