package edu.sae.modulo.dominio.empresa;

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

import edu.sae.modulo.dominio.aplicacion.OmsRole;
import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;


// TODO: Auto-generated Javadoc
/**
 * The Class OmsoCargo.
 */
@Entity
@Table(name="OMSO_CARGOS_EMPLEADOS")
public class OmsoCargo extends EntidadBaseAuditable<Long> implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre cargo. */
	private String nombreCargo;
	
	/** The rol default. */  
	private OmsRole rolDefault;
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.dominio.entidades.IEntidadPersistible#getId()
	 */
	@GeneratedValue(generator = "secCargo", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secCargo", allocationSize = 1, initialValue = 1, sequenceName = "SEC_CARGO_EMPLEADO")
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
	 * Gets the nombre cargo.
	 *
	 * @return the nombre cargo
	 */
	@Column(name="NOMBRE_CARGO")
	public String getNombreCargo() {
		return nombreCargo;
	}
	
	/**
	 * Sets the nombre cargo.
	 *
	 * @param nombreCargo the new nombre cargo
	 */
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nombreCargo;
	}
	
	/**
	 * Gets the rol default.
	 *
	 * @return the rol default
	 */
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	public OmsRole getRolDefault() {
		return rolDefault;
	}
	
	/**
	 * Sets the rol default.
	 *
	 * @param rolDefault the new rol default
	 */
	public void setRolDefault(OmsRole rolDefault) {
		this.rolDefault = rolDefault;
	}
	
	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
	}
}
