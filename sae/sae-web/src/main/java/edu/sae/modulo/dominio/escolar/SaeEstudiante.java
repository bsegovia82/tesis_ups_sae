package edu.sae.modulo.dominio.escolar;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "SAE_ESTUDIANTE")
public class SaeEstudiante extends EntidadBaseAuditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	private OmsgPersona persona;
	private Date fechaInicio;
	private Date fechaFin;
	private String codigoCliente;
	
	
	
	private String escuelaProcede;
	private String lugarNacimiento;
	private String lAnios;
	private String lMeses;
	private String lTipoSanngre;
	private String lTalla;
	private String lPeso;
	private String lNumeroCarnet;
	
	private String lPorcentaje;
	private String lTipoDiscapacidad;
	private String lNumeroCarpeta;
	private String lDireccion;
	private String lParroquia;
	private String lTelefonoFijo;
	private String lTelefonoEmergencia;
	private String lTelefonoFamiliar;
	private String lCelularFamiliar;
	private String lParentesco;
	private String lBecadoMunicipio;
	private String lBecadoDireccionEstudio;
	private String lOtro;
	
	private String lNombreCompletoMadre;
	private String lViveNinioMadre;
	private String lCedulaMadre;
	private String lEstadoCivilMadre;
	private String lInstrccionMadre;
	private String lOcupacionMadre;
	private String lTelefonoTrabajoMadre;
	private String lDireccionTrabajoMadre;
	
	private String lNombreCompletoPadre;
	private String lViveNinioPadre;
	private String lCedulaPadre;
	private String lEstadoCivilPadre;
	private String lInstrccionPadre;
	private String lOcupacionPadre;
	private String lTelefonoTrabajoPadre;
	private String lDireccionTrabajoPadre;
	
	private String lNombreRepresentante;
	private String lTelefonoFijoRepresentate;
	private String lCelularRepresentante;
	private String lObservaciones;
	
	
	
	@GeneratedValue(generator = "secEstudiante", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secEstudiante", allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_ESTUDIANTE")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);
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

	@Column(name = "CODIGO_INTERNO_ESTUDIANTE")
	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	@Transient
	public String getNombreCompleto()
	{
		return persona.getNombres() + " " + persona.getApellidos();
	}

	public String getEscuelaProcede() {
		return escuelaProcede;
	}

	public void setEscuelaProcede(String escuelaProcede) {
		this.escuelaProcede = escuelaProcede;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getlAnios() {
		return lAnios;
	}

	public void setlAnios(String lAnios) {
		this.lAnios = lAnios;
	}

	public String getlMeses() {
		return lMeses;
	}

	public void setlMeses(String lMeses) {
		this.lMeses = lMeses;
	}

	public String getlTipoSanngre() {
		return lTipoSanngre;
	}

	public void setlTipoSanngre(String lTipoSanngre) {
		this.lTipoSanngre = lTipoSanngre;
	}

	public String getlTalla() {
		return lTalla;
	}

	public void setlTalla(String lTalla) {
		this.lTalla = lTalla;
	}

	public String getlPeso() {
		return lPeso;
	}

	public void setlPeso(String lPeso) {
		this.lPeso = lPeso;
	}

	public String getlNumeroCarnet() {
		return lNumeroCarnet;
	}

	public void setlNumeroCarnet(String lNumeroCarnet) {
		this.lNumeroCarnet = lNumeroCarnet;
	}

	public String getlPorcentaje() {
		return lPorcentaje;
	}

	public void setlPorcentaje(String lPorcentaje) {
		this.lPorcentaje = lPorcentaje;
	}

	public String getlTipoDiscapacidad() {
		return lTipoDiscapacidad;
	}

	public void setlTipoDiscapacidad(String lTipoDiscapacidad) {
		this.lTipoDiscapacidad = lTipoDiscapacidad;
	}

	public String getlNumeroCarpeta() {
		return lNumeroCarpeta;
	}

	public void setlNumeroCarpeta(String lNumeroCarpeta) {
		this.lNumeroCarpeta = lNumeroCarpeta;
	}

	public String getlDireccion() {
		return lDireccion;
	}

	public void setlDireccion(String lDireccion) {
		this.lDireccion = lDireccion;
	}

	public String getlParroquia() {
		return lParroquia;
	}

	public void setlParroquia(String lParroquia) {
		this.lParroquia = lParroquia;
	}

	public String getlTelefonoFijo() {
		return lTelefonoFijo;
	}

	public void setlTelefonoFijo(String lTelefonoFijo) {
		this.lTelefonoFijo = lTelefonoFijo;
	}

	public String getlTelefonoEmergencia() {
		return lTelefonoEmergencia;
	}

	public void setlTelefonoEmergencia(String lTelefonoEmergencia) {
		this.lTelefonoEmergencia = lTelefonoEmergencia;
	}

	public String getlTelefonoFamiliar() {
		return lTelefonoFamiliar;
	}

	public void setlTelefonoFamiliar(String lTelefonoFamiliar) {
		this.lTelefonoFamiliar = lTelefonoFamiliar;
	}

	public String getlCelularFamiliar() {
		return lCelularFamiliar;
	}

	public void setlCelularFamiliar(String lCelularFamiliar) {
		this.lCelularFamiliar = lCelularFamiliar;
	}

	public String getlParentesco() {
		return lParentesco;
	}

	public void setlParentesco(String lParentesco) {
		this.lParentesco = lParentesco;
	}

	public String getlBecadoMunicipio() {
		return lBecadoMunicipio;
	}

	public void setlBecadoMunicipio(String lBecadoMunicipio) {
		this.lBecadoMunicipio = lBecadoMunicipio;
	}

	public String getlBecadoDireccionEstudio() {
		return lBecadoDireccionEstudio;
	}

	public void setlBecadoDireccionEstudio(String lBecadoDireccionEstudio) {
		this.lBecadoDireccionEstudio = lBecadoDireccionEstudio;
	}

	public String getlOtro() {
		return lOtro;
	}

	public void setlOtro(String lOtro) {
		this.lOtro = lOtro;
	}

	public String getlNombreCompletoMadre() {
		return lNombreCompletoMadre;
	}

	public void setlNombreCompletoMadre(String lNombreCompletoMadre) {
		this.lNombreCompletoMadre = lNombreCompletoMadre;
	}

	public String getlViveNinioMadre() {
		return lViveNinioMadre;
	}

	public void setlViveNinioMadre(String lViveNinioMadre) {
		this.lViveNinioMadre = lViveNinioMadre;
	}

	public String getlCedulaMadre() {
		return lCedulaMadre;
	}

	public void setlCedulaMadre(String lCedulaMadre) {
		this.lCedulaMadre = lCedulaMadre;
	}

	public String getlEstadoCivilMadre() {
		return lEstadoCivilMadre;
	}

	public void setlEstadoCivilMadre(String lEstadoCivilMadre) {
		this.lEstadoCivilMadre = lEstadoCivilMadre;
	}

	public String getlInstrccionMadre() {
		return lInstrccionMadre;
	}

	public void setlInstrccionMadre(String lInstrccionMadre) {
		this.lInstrccionMadre = lInstrccionMadre;
	}

	public String getlOcupacionMadre() {
		return lOcupacionMadre;
	}

	public void setlOcupacionMadre(String lOcupacionMadre) {
		this.lOcupacionMadre = lOcupacionMadre;
	}

	public String getlTelefonoTrabajoMadre() {
		return lTelefonoTrabajoMadre;
	}

	public void setlTelefonoTrabajoMadre(String lTelefonoTrabajoMadre) {
		this.lTelefonoTrabajoMadre = lTelefonoTrabajoMadre;
	}

	public String getlDireccionTrabajoMadre() {
		return lDireccionTrabajoMadre;
	}

	public void setlDireccionTrabajoMadre(String lDireccionTrabajoMadre) {
		this.lDireccionTrabajoMadre = lDireccionTrabajoMadre;
	}

	public String getlNombreCompletoPadre() {
		return lNombreCompletoPadre;
	}

	public void setlNombreCompletoPadre(String lNombreCompletoPadre) {
		this.lNombreCompletoPadre = lNombreCompletoPadre;
	}

	public String getlViveNinioPadre() {
		return lViveNinioPadre;
	}

	public void setlViveNinioPadre(String lViveNinioPadre) {
		this.lViveNinioPadre = lViveNinioPadre;
	}

	public String getlCedulaPadre() {
		return lCedulaPadre;
	}

	public void setlCedulaPadre(String lCedulaPadre) {
		this.lCedulaPadre = lCedulaPadre;
	}

	public String getlEstadoCivilPadre() {
		return lEstadoCivilPadre;
	}

	public void setlEstadoCivilPadre(String lEstadoCivilPadre) {
		this.lEstadoCivilPadre = lEstadoCivilPadre;
	}

	public String getlInstrccionPadre() {
		return lInstrccionPadre;
	}

	public void setlInstrccionPadre(String lInstrccionPadre) {
		this.lInstrccionPadre = lInstrccionPadre;
	}

	public String getlOcupacionPadre() {
		return lOcupacionPadre;
	}

	public void setlOcupacionPadre(String lOcupacionPadre) {
		this.lOcupacionPadre = lOcupacionPadre;
	}

	public String getlTelefonoTrabajoPadre() {
		return lTelefonoTrabajoPadre;
	}

	public void setlTelefonoTrabajoPadre(String lTelefonoTrabajoPadre) {
		this.lTelefonoTrabajoPadre = lTelefonoTrabajoPadre;
	}

	public String getlDireccionTrabajoPadre() {
		return lDireccionTrabajoPadre;
	}

	public void setlDireccionTrabajoPadre(String lDireccionTrabajoPadre) {
		this.lDireccionTrabajoPadre = lDireccionTrabajoPadre;
	}

	public String getlNombreRepresentante() {
		return lNombreRepresentante;
	}

	public void setlNombreRepresentante(String lNombreRepresentante) {
		this.lNombreRepresentante = lNombreRepresentante;
	}

	public String getlTelefonoFijoRepresentate() {
		return lTelefonoFijoRepresentate;
	}

	public void setlTelefonoFijoRepresentate(String lTelefonoFijoRepresentate) {
		this.lTelefonoFijoRepresentate = lTelefonoFijoRepresentate;
	}

	public String getlCelularRepresentante() {
		return lCelularRepresentante;
	}

	public void setlCelularRepresentante(String lCelularRepresentante) {
		this.lCelularRepresentante = lCelularRepresentante;
	}

	public String getlObservaciones() {
		return lObservaciones;
	}

	public void setlObservaciones(String lObservaciones) {
		this.lObservaciones = lObservaciones;
	}
	
	
	
	
}
