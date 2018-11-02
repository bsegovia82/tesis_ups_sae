package edu.sae.modulo.dominio.empresa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;


// TODO: Auto-generated Javadoc
/**
 * The Class OmsoEspecialidad.
 */
@Entity
@Table(name="OMSO_ESPECIALIDADES")  
public class OmsoEspecialidad extends EntidadBaseAuditable<Long> implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre especialidad. */
	private String nombreEspecialidad;
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.dominio.entidades.IEntidadPersistible#getId()
	 */
	@GeneratedValue(generator = "secEspecialidades", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secEspecialidades", allocationSize = 1, initialValue = 1, sequenceName = "SEC_ESPECIALIDAD")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.dominio.entidades.base.EntidadBase#setId(java.io.Serializable)
	 */
	@Override
	public void setId(Long id) {
		this.id =  id;
	}
	
	/**
	 * Gets the nombre especialidad.
	 *
	 * @return the nombre especialidad
	 */
	@Column(name="NOMBRE_ESPECIALIDAD")
	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}
	
	/**
	 * Sets the nombre especialidad.
	 *
	 * @param nombreEspecialidad the new nombre especialidad
	 */
	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombreEspecialidad;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
		
	}
}
