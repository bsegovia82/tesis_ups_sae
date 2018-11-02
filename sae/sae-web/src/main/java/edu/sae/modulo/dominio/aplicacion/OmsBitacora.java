package edu.sae.modulo.dominio.aplicacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the PRI_USUARIOS database table.
 * 
 */
@Entity
@Table(name = "ONIX_BITACORA")
@NamedQuery(name = "OmsBitacora.findAll", query = "SELECT p FROM OmsBitacora p")
public class OmsBitacora extends EntidadBaseAuditable<Long> implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The proceso. */
	private String proceso;
	
	/** The usuario. */
	private String usuario;

	/** The l tipo bitacora. */
	private TIPO_BITACORA lTipoBitacora;

	/**
	 * Instantiates a new oms bitacora.
	 */
	public OmsBitacora() {
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.dominio.entidades.IEntidadPersistible#getId()
	 */
	@GeneratedValue(generator = "secBitacora", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secBitacora", allocationSize = 1, initialValue = 1, sequenceName = "SEC_BITACORA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.dominio.entidades.base.EntidadBase#setId(java.io.Serializable)
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the proceso.
	 *
	 * @return the proceso
	 */
	@Column(name = "PROCESO")
	public String getProceso() {
		return proceso;
	}

	/**
	 * Sets the proceso.
	 *
	 * @param proceso the new proceso
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	@Column(name = "USUARIO")
	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the l tipo bitacora.
	 *
	 * @return the l tipo bitacora
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_BITACORA")
	public TIPO_BITACORA getlTipoBitacora() {
		return lTipoBitacora;
	}
	
	/**
	 * Sets the l tipo bitacora.
	 *
	 * @param lTipoBitacora the new l tipo bitacora
	 */
	public void setlTipoBitacora(TIPO_BITACORA lTipoBitacora) {
		this.lTipoBitacora = lTipoBitacora;
	}
	
	/**
	 * The Enum TIPO_BITACORA.
	 */
	public enum TIPO_BITACORA {
		
		/** The novedad. */
		NOVEDAD, 
 /** The informacion. */
 INFORMACION, 
 /** The alerta. */
 ALERTA, 
 /** The error. */
 ERROR, 
 /** The fatal. */
 FATAL
	}
	
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
		
	}

}