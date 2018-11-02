package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import edu.sae.modulo.dominio.aplicacion.OmsRole;
import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.dominio.aplicacion.OmsUsuariosRole;
import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.dominio.empresa.OmsgTipoDocumentoIdentificacion;
import edu.sae.modulo.dominio.empresa.OmsoCargo;
import edu.sae.modulo.dominio.empresa.OmsoEspecialidad;
import edu.sae.modulo.dominio.escolar.SaeDocente;
import edu.sae.modulo.eao.escolar.SaeDocenteEAO;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.exceptions.ErrorValidacionGeneral;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostInicializacionEntidad;
import edu.sae.modulo.librerias.vista.beans.oyentes.PreTransaccionListener;
import edu.sae.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorCargo;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorDocente;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorEspecialidad;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorRol;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuarioRol;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorEmpleado.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorDocente
		extends BeanMantenedorGenerico<ServicioMantenedorDocente, Long, SaeDocente, SaeDocenteEAO> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenedorDocente servicioMantenedor;
	

	/** The servicio mantenedor usuario. */
	@EJB
	private ServicioMantenedorUsuario servicioMantenedorUsuario;
	
	
	/** The l servicio rol. */
	@EJB
	private ServicioMantenedorRol lServicioRol;
	
	/** The l servicio cargo. */
	@EJB
	private ServicioMantenedorCargo lServicioCargo;
	
	/** The l servicio usuario rol. */
	@EJB
	private ServicioMantenedorUsuarioRol lServicioUsuarioRol;
	
	private List<OmsoEspecialidad> listaEspecialidad; 

	/** The lista cargos. */
	private List<OmsoCargo> listaCargos;
	
	@EJB
	private ServicioMantenedorEspecialidad lServicioEspecialidad;
	
	
	
	/**
	 * Instantiates a new bean mantenedor empleado.
	 */
	public BeanMantenedorDocente() {
		super(SaeDocente.class);
		
		
		OmsgTipoDocumentoIdentificacion tipoDoc = new OmsgTipoDocumentoIdentificacion();
		OmsgPersona persona = new OmsgPersona();
		persona.setUsuario(new OmsUsuario());
		entidadRegistrar.setPersona(persona);
		entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
		OmsoCargo cargo = new OmsoCargo();
		
		entidadRegistrar.setEspecialidad(new OmsoEspecialidad());
		
		entidadRegistrar.setCargo(cargo);
		
		
		addPostConstructuListener(new PostConstructListener() {
			
			@Override
			public void metodoPostConstruct() {
				System.out.println("Inicializado");
				listaCargos = servicioMantenedor.obtenerListaCargos();
				listaEspecialidad = lServicioEspecialidad.listaObjetosActivos(OmsoEspecialidad.class);
				System.out.println("Lista cargos " + listaCargos.size());
				System.out.println("Lista especialidad " + listaEspecialidad.size());
				System.out.println("Finalizando");
			}
		});
		
		
		addPostEventoInicializacion(new PostInicializacionEntidad() {
			
			public void eventoPostInicializacion() {
				OmsoCargo cargo = new OmsoCargo();
				persona.setUsuario(new OmsUsuario());
				entidadRegistrar.setPersona(persona);
				entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
				entidadRegistrar.setCargo(cargo);
				
				entidadRegistrar.setEspecialidad(new OmsoEspecialidad());
				
			}
		});
		
		addPreTransaccionServicioListener(new PreTransaccionListener() {
			
			@Override
			public void accionPreTransaccion() throws ErrorAccionesPreTransaccion {
				if (entidadRegistrar.getCargo().getId() < 1 )
				{
					addMensajeAdvertencia("Debe registrar el cargo");
					return;
				}
				if (entidadRegistrar.getEspecialidad().getId() < 1)
				{
					addMensajeAdvertencia("Debe registrar la especialidad");
					return;
				}
				
			}
		});

	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#getServicioMantenedor()
	 */
	@Override
	protected ServicioMantenedorDocente getServicioMantenedor() {
		return servicioMantenedor;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#cargarListaEtiquetas()
	 */
	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Docente");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Docente");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Docente");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Docente");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Docente registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Docente");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Docente");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#metodoPostTransaccion()
	 */
	@Override
	protected void metodoPostTransaccion() {
		super.metodoPostTransaccion();
		entidadRegistrar = new SaeDocente();
		OmsgTipoDocumentoIdentificacion tipoDoc = new OmsgTipoDocumentoIdentificacion();
		OmsgPersona persona = new OmsgPersona();
		OmsoCargo cargo = new OmsoCargo();
		
		persona.setUsuario(new OmsUsuario());
		entidadRegistrar.setPersona(persona);
		entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
		entidadRegistrar.setCargo(cargo);
		entidadRegistrar.setEspecialidad(new OmsoEspecialidad());
		
		
	}

	
	/**
	 * Gets the lista cargos.
	 *
	 * @return the lista cargos
	 */
	public List<OmsoCargo> getListaCargos() {
		return listaCargos;
	}

	/**
	 * Sets the lista cargos.
	 *
	 * @param listaCargos the new lista cargos
	 */
	public void setListaCargos(List<OmsoCargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	/**
	 * Gets the lista especialidad.
	 *
	 * @return the lista especialidad
	 */
	

	/**
	 * Sets the lista especialidad.
	 *
	 * @param listaEspecialidad the new lista especialidad
	 */
	

	/**
	 * Buscar codigo disponible.
	 *
	 * @param pEvento the evento
	 */
	public void buscarCodigoDisponible(AjaxBehaviorEvent pEvento) {
		SaeDocente empleadoBase = servicioMantenedor.obtenerObjetoPropiedad("codigoEmpleado",
				this.entidadRegistrar.getCodigoEmpleado(), SaeDocente.class);

		if (empleadoBase != null) {
			addMensaje("Ya se encuentra registrado un empleado con el codigo : "
					+ this.entidadRegistrar.getCodigoEmpleado());
			this.entidadRegistrar.setCodigoEmpleado("");
		}
	}

	/**
	 * Buscar usuario disponible.
	 *
	 * @param pEvento the evento
	 */
	public void buscarUsuarioDisponible(AjaxBehaviorEvent pEvento) {
		OmsUsuario usuarioBase = servicioMantenedorUsuario.obtenerObjetoPropiedad("usuario",
				this.entidadRegistrar.getPersona().getUsuario().getUsuario(), OmsUsuario.class);

		if (usuarioBase != null) {
			addMensaje("Ya se encuentra registrado el usuario : "
					+ this.entidadRegistrar.getPersona().getUsuario().getUsuario());
			this.entidadRegistrar.getPersona().setUsuario(new OmsUsuario());
		}
	}

	/**
	 * Buscar persona identificacion.
	 *
	 * @param pEvento the evento
	 */
	public void buscarPersonaIdentificacion(AjaxBehaviorEvent pEvento) {

		String lDato = entidadRegistrar.getPersona().getNumeroDocumento();
		OmsgPersona persona = servicioMantenedor
				.buscarPersonaIdentificacion(lDato);
		if (persona != null) 
		{
			if (servicioMantenedor
					.buscarEmpleadoPorIdentificacion(lDato) != null) {
				entidadRegistrar = servicioMantenedor
						.buscarEmpleadoPorIdentificacion(lDato);
			} else {
				//entidadRegistrar = new OmsoEmpleado();
				OmsoCargo cargo = new OmsoCargo();
				
				persona.setUsuario(new OmsUsuario());
				this.entidadRegistrar.setPersona(persona);
				entidadRegistrar.setCargo(cargo);
				
				
			}
		} else {
			OmsgTipoDocumentoIdentificacion tipoDoc = new OmsgTipoDocumentoIdentificacion();
			//entidadRegistrar = new OmsoEmpleado();
			OmsgPersona lPersona = new OmsgPersona();
			OmsoCargo cargo = new OmsoCargo();
			
			lPersona.setUsuario(new OmsUsuario());
			lPersona.setNumeroDocumento(lDato);
			this.entidadRegistrar.setPersona(lPersona);
			entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
			entidadRegistrar.setCargo(cargo);
			
		}
	}
	
	public void buscarAreas(AjaxBehaviorEvent pEvento) {
		
		HashMap<String, Object> lParametros = new HashMap<>();
		
	}
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#accionesPreTransaccionServicio()
	 */
	@Override
	protected void accionesPreTransaccionServicio() throws ErrorAccionesPreTransaccion {
		super.accionesPreTransaccionServicio();
		validarRegistro();
		crearUsuario();
		crearPersona();
	}
	
	
	/**
	 * Crear persona.
	 *
	 * @throws ErrorAccionesPreTransaccion the error acciones pre transaccion
	 */
	private void crearPersona() throws ErrorAccionesPreTransaccion
	{
		try
		{
		servicioMantenedor.guardarActualizarPersona(entidadRegistrar.getPersona());
		}catch(Throwable lError) {
			throw new ErrorAccionesPreTransaccion("Error al crear la persona");
		}
	}

	/**
	 * Validar registro.
	 */
	private void validarRegistro() {
		System.out.println("Validaciones");
	}
	
	/**
	 * Crear usuario.
	 *
	 * @throws ErrorAccionesPreTransaccion the error acciones pre transaccion
	 */
	private void crearUsuario() throws ErrorAccionesPreTransaccion {
		try {
			OmsUsuario lUsuarioDB = servicioMantenedorUsuario.obtenerObjetoPropiedad("usuario",
					entidadRegistrar.getPersona().getNumeroDocumento(), OmsUsuario.class);
			
			OmsoCargo lCargo = lServicioCargo.obtenerObjtoPK(entidadRegistrar.getCargo().getId(), OmsoCargo.class);
			OmsRole lRol = lCargo.getRolDefault();
			if (lUsuarioDB == null) {
				OmsUsuario lUsuario = new OmsUsuario();
				lUsuario.setUsuario(entidadRegistrar.getPersona().getNumeroDocumento());
				lUsuario.setlDescripcion(entidadRegistrar.getPersona().getNombres() + " " + entidadRegistrar.getPersona().getApellidos());
				lUsuario.setClave(entidadRegistrar.getPersona().getNumeroDocumento());
				lUsuario.setAuditoria(JsfUtil.getUsuarioAutenticado().getName());
				lUsuario.setIdReferencia(obtenerObjetoSesion(JsfUtil.REFERENCIA_SESION));
				servicioMantenedorUsuario.guardarActualizar(lUsuario);
				crearUsuarioRol(lRol, lUsuario);
				this.entidadRegistrar.getPersona().setUsuario(lUsuario);;
			} else {
				OmsUsuariosRole lUsuarioRol = lServicioUsuarioRol.obtenerUsuarioRolPorRolUsuario(lRol.getRol(),
						lUsuarioDB.getId());
				if (lUsuarioRol == null)
					crearUsuarioRol(lRol, lUsuarioDB);
				this.entidadRegistrar.getPersona().setUsuario(lUsuarioDB);
			}
		} catch (Throwable lError) {
			lError.printStackTrace();
			throw new ErrorAccionesPreTransaccion("Error al crear el usuario");
		}
	}
	
	/**
	 * Crear usuario rol.
	 *
	 * @param lRol the l rol
	 * @param lUsuario the l usuario
	 * @throws ErrorServicioNegocio the error servicio negocio
	 * @throws ErrorValidacionGeneral the error validacion general
	 */
	private void crearUsuarioRol(OmsRole lRol, OmsUsuario lUsuario)
			throws ErrorServicioNegocio, ErrorValidacionGeneral {
		OmsUsuariosRole lUsuarioRol = new OmsUsuariosRole();
		lUsuarioRol.setPriRole(lRol);
		lUsuarioRol.setPriUsuario(lUsuario);
		lUsuarioRol.setIdReferencia(obtenerObjetoSesion(JsfUtil.REFERENCIA_SESION));
		lUsuarioRol.setAuditoria(JsfUtil.getUsuarioAutenticado().getName());
		lUsuarioRol.setDescripcion("REGISTRO DESDE LA CREACION DE PACIENTE");
		lServicioUsuarioRol.guardarActualizar(lUsuarioRol);
	}

	public List<OmsoEspecialidad> getListaEspecialidad() {
		return listaEspecialidad;
	}

	public void setListaEspecialidad(List<OmsoEspecialidad> listaEspecialidad) {
		this.listaEspecialidad = listaEspecialidad;
	}

	
	
	

}
