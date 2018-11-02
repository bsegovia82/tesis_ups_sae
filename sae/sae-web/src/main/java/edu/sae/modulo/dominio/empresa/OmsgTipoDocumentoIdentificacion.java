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
 * The Class OmsgTipoDocumentoIdentificacion.
 */
@Entity
@Table(name = "OMSG_TIPOS_DOCUMENTOS_IDENT")
public class OmsgTipoDocumentoIdentificacion extends EntidadBaseAuditable<Long> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nombre. */
	private String nombre;
	
	/** The nombre corto. */
	private String nombreCorto;

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.dominio.entidades.IEntidadPersistible#getId()
	 */
	@GeneratedValue(generator = "secTipoDoc", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secTipoDoc", allocationSize = 1, initialValue = 1, sequenceName = "SEC_TIPO_DOC")
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
		this.id = id;

	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	@Column(name = "NOMBRE", length = 64, nullable = false)
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the nombre corto.
	 *
	 * @return the nombre corto
	 */
	@Column(name = "NOMBRE_CORTO", length = 8, nullable = false)
	public String getNombreCorto() {
		return nombreCorto;
	}

	/**
	 * Sets the nombre corto.
	 *
	 * @param nombreCorto the new nombre corto
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
	}

}
