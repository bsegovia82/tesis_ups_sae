package edu.sae.modulo.dominio.escolar;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.dominio.empresa.OmsoCargo;
import edu.sae.modulo.dominio.empresa.OmsoEspecialidad;
import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "SAE_DOCENTE")
public class SaeDocente extends EntidadBaseAuditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OmsgPersona persona;

	private OmsoEspecialidad especialidad;

	private String codigoEmpleado;

	/** The cargo. */
	private OmsoCargo cargo;

	/** The fecha inicio. */
	private Date fechaInicio;

	/** The fecha fin. */
	private Date fechaFin;

	/** The jefe. */
	private SaeDocente jefe;

	/** The sub ordinados. */
	private List<SaeDocente> subOrdinados;

	@GeneratedValue(generator = "secDocente", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secDocente", allocationSize = 1, initialValue = 1, sequenceName = "SEC_DOCENTE")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);

	}

	@Transient
	public String getNombreCompleto() {
		return this.persona.getNombres() + " " + this.persona.getApellidos();
	}

	@OneToOne
	@JoinColumn(name = "ID_PERSONA", nullable = true)
	public OmsgPersona getPersona() {
		return persona;
	}

	public void setPersona(OmsgPersona persona) {
		this.persona = persona;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INGRESO")
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio
	 *            the new fecha inicio
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_SALIDA")
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@OneToMany(mappedBy = "jefe")
	public List<SaeDocente> getSubOrdinados() {
		return subOrdinados;
	}

	/**
	 * Sets the sub ordinados.
	 *
	 * @param subOrdinados
	 *            the new sub ordinados
	 */
	public void setSubOrdinados(List<SaeDocente> subOrdinados) {
		this.subOrdinados = subOrdinados;
	}

	@ManyToOne
	@JoinColumn(name = "ID_JEFE")
	public SaeDocente getJefe() {
		return jefe;
	}

	/**
	 * Sets the jefe.
	 *
	 * @param jefe
	 *            the new jefe
	 */
	public void setJefe(SaeDocente jefe) {
		this.jefe = jefe;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CARGO")
	public OmsoCargo getCargo() {
		return cargo;
	}

	/**
	 * Sets the cargo.
	 *
	 * @param cargo
	 *            the new cargo
	 */
	public void setCargo(OmsoCargo cargo) {
		this.cargo = cargo;
	}

	@Column(name = "CODIGO_EMPLEADO")
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	/**
	 * Sets the codigo empleado.
	 *
	 * @param codigoEmpleado
	 *            the new codigo empleado
	 */
	@Column(name = "CODIGO_EMPLEADO")
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	@OneToOne
	@JoinColumn(name = "ID_ESPECIALIDAD", nullable = true)
	public OmsoEspecialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(OmsoEspecialidad especialidad) {
		this.especialidad = especialidad;
	}

}
