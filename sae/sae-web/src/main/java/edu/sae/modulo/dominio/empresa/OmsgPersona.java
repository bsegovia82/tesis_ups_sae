package edu.sae.modulo.dominio.empresa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

// TODO: Auto-generated Javadoc
/**
 * The Class OmsgPersona.
 */
@Entity
@Table(name = "OMSG_PERSONAS")
public class OmsgPersona extends EntidadBaseAuditable<Long> implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant ECUATORIANO. */
	public static final Long ECUATORIANO = 1l;
	
	/** The Constant NUMERODOCUMENTO. */
	public static final String NUMERODOCUMENTO = "numeroDocumento";

	/** The razon social. */
	private String razonSocial;
	
	/** The nombres. */
	private String nombres;
	
	/** The apellidos. */
	private String apellidos;
	
	/** The fecha nacimiento. */
	private Date fechaNacimiento;
	
	/** The genero. */
	private String genero;
	
	/** The ocupacion. */
	private String ocupacion;
	
	/** The telefono contacto. */
	private String telefonoContacto;
	
	/** The direccion principal. */
	private String direccionPrincipal;

	/** The tipo documento identificacion. */
	private OmsgTipoDocumentoIdentificacion tipoDocumentoIdentificacion;
	
	/** The numero documento. */
	private String numeroDocumento;

	
	/** The direccion correo. */
	private String direccionCorreo;

	/** The usuario. */
	private OmsUsuario usuario;

	
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.dominio.entidades.IEntidadPersistible#getId()
	 */
	@GeneratedValue(generator = "secPersona", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secPersona", allocationSize = 1, initialValue = 1, sequenceName = "SEC_PERSONA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
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
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	@OneToOne
	@JoinColumn(name = "ID_USUARIO", nullable = true)
	public OmsUsuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(OmsUsuario usuario) {
		this.usuario = usuario;
	}



	

	/**
	 * Gets the telefono.
	 *
	 * @param pIdTipoTelefono the id tipo telefono
	 * @return the telefono
	 */
	



	
	
	
	

	// public void asociarRemoverNacionalidadOriginaria(OmslPais pPais){
	// OmsgNacionalidad lNacionalidad=getNacionalidadOriginaria();
	// if(pPais!=null){
	// if(lNacionalidad!=null){
	// lNacionalidad.setPais(pPais);
	// pPais.getNacionalidades().add(lNacionalidad);
	// }
	// else{
	// lNacionalidad=new OmsgNacionalidad();
	// lNacionalidad.setTipoNacionalidad(TipoNacionalidad.ORIGINARIA);
	//
	// lNacionalidad.setPais(pPais);
	// pPais.getNacionalidades().add(lNacionalidad);
	//
	// this.getNacionalidades().add(lNacionalidad);
	// lNacionalidad.setPersona(this);
	// }
	// }
	// }

	/**
	 * Gets the direccion correo.
	 *
	 * @return the direccion correo
	 */
	@Column(name = "DIRECCION_CORREO", nullable = true, length = 128)
	public String getDireccionCorreo() {
		return direccionCorreo;
	}

	/**
	 * Sets the direccion correo.
	 *
	 * @param direccionCorreo the new direccion correo
	 */
	public void setDireccionCorreo(String direccionCorreo) {
		if ("".equals(direccionCorreo))
			direccionCorreo = null;
		this.direccionCorreo = direccionCorreo;
	}

	/**
	 * Gets the razon social.
	 *
	 * @return the razon social
	 */
	@Column(name = "RAZON_SOCIAL", length = 128)
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * Sets the razon social.
	 *
	 * @param razonSocial the new razon social
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * Gets the nombres.
	 *
	 * @return the nombres
	 */
	@Column(name = "NOMBRES", length = 128)
	public String getNombres() {
		return nombres;
	}

	/**
	 * Sets the nombres.
	 *
	 * @param nombres the new nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	@Column(name = "APELLIDOS", length = 128)
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO", nullable = true)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Gets the genero.
	 *
	 * @return the genero
	 */
	@Column(name = "GENERO", nullable = true, length = 32)
	public String getGenero() {
		return genero;
	}

	/**
	 * Sets the genero.
	 *
	 * @param genero the new genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Gets the ocupacion.
	 *
	 * @return the ocupacion
	 */
	@Column(name = "OCUPACION", nullable = true)
	public String getOcupacion() {
		return ocupacion;
	}

	/**
	 * Sets the ocupacion.
	 *
	 * @param ocupacion the new ocupacion
	 */
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * Gets the tipo documento identificacion.
	 *
	 * @return the tipo documento identificacion
	 */
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_DOCUMENTO_IDENT", nullable = false)
	public OmsgTipoDocumentoIdentificacion getTipoDocumentoIdentificacion() {
		return tipoDocumentoIdentificacion;
	}

	/**
	 * Sets the tipo documento identificacion.
	 *
	 * @param tipoDocumentoIdentificacion the new tipo documento identificacion
	 */
	public void setTipoDocumentoIdentificacion(OmsgTipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
	}

	/**
	 * Gets the numero documento.
	 *
	 * @return the numero documento
	 */
	@Column(name = "NUMERO_DOCUMENTO", length = 128, nullable = false)
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * Sets the numero documento.
	 *
	 * @param numeroDocumento the new numero documento
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	/**
	 * Gets the telefono contacto.
	 *
	 * @return the telefono contacto
	 */
	@Column(name = "TELEFONO_CONTACTO")
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	/**
	 * Sets the telefono contacto.
	 *
	 * @param telefonoContacto the new telefono contacto
	 */
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	
	/**
	 * Gets the direccion principal.
	 *
	 * @return the direccion principal
	 */
	@Column(name = "TELEFONO_PRINCIPAL")
	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}
	
	/**
	 * Sets the direccion principal.
	 *
	 * @param direccionPrincipal the new direccion principal
	 */
	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}
	
	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
	}
	
}
