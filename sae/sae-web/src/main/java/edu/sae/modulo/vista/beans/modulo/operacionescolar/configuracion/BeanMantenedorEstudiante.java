package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.HashMap;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import edu.sae.modulo.dominio.aplicacion.OmsRole;
import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.dominio.aplicacion.OmsUsuariosRole;
import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.dominio.empresa.OmsgTipoDocumentoIdentificacion;
import edu.sae.modulo.dominio.escolar.SaeEstudiante;
import edu.sae.modulo.eao.escolar.SaeEstudianteEAO;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.exceptions.ErrorValidacionGeneral;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostInicializacionEntidad;
import edu.sae.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorEstudiante;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorRol;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuarioRol;


// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorEmpleado.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorEstudiante
		extends BeanMantenedorGenerico<ServicioMantenedorEstudiante, Long, SaeEstudiante, SaeEstudianteEAO> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenedorEstudiante servicioMantenedor;
	

	/** The servicio mantenedor usuario. */
	@EJB
	private ServicioMantenedorUsuario servicioMantenedorUsuario;
	
//	
//	/** The l servicio rol. */
	@EJB
	private ServicioMantenedorRol lServicioRol;
//	
	
	/** The l servicio usuario rol. */
	@EJB
	private ServicioMantenedorUsuarioRol lServicioUsuarioRol;
	
	
	
	
	
	
	/**
	 * Instantiates a new bean mantenedor empleado.
	 */
	public BeanMantenedorEstudiante() {
		super(SaeEstudiante.class);
		
		
		OmsgTipoDocumentoIdentificacion tipoDoc = new OmsgTipoDocumentoIdentificacion();
		OmsgPersona persona = new OmsgPersona();
		persona.setUsuario(new OmsUsuario());
		entidadRegistrar.setPersona(persona);
		entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
		
		
		
		
		addPostEventoInicializacion(new PostInicializacionEntidad() {
			
			public void eventoPostInicializacion() {
				persona.setUsuario(new OmsUsuario());
				entidadRegistrar.setPersona(persona);
				entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
				

				
			}
		});

	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#getServicioMantenedor()
	 */
	@Override
	protected ServicioMantenedorEstudiante getServicioMantenedor() {
		return servicioMantenedor;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#cargarListaEtiquetas()
	 */
	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Estudiante");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Estudiante");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Estudiante");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Estudiante");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Empleados Estudiante");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Estudiante");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Estudiante");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#metodoPostTransaccion()
	 */
	@Override
	protected void metodoPostTransaccion() {
		super.metodoPostTransaccion();
		entidadRegistrar = new SaeEstudiante();
		OmsgTipoDocumentoIdentificacion tipoDoc = new OmsgTipoDocumentoIdentificacion();
		OmsgPersona persona = new OmsgPersona();
		
		persona.setUsuario(new OmsUsuario());
		entidadRegistrar.setPersona(persona);
		entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
		
		
		
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#metodoPostConstruct()
	 */
	@Override
	protected void metodoPostConstruct() {
		try {
			
			

		} catch (Throwable e) {
			e.printStackTrace();
		}
		
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
		SaeEstudiante empleadoBase = servicioMantenedor.obtenerObjetoPropiedad("codigoEmpleado",
				this.entidadRegistrar.getCodigoCliente(), SaeEstudiante.class);

		if (empleadoBase != null) {
			addMensaje("Ya se encuentra registrado un empleado con el codigo : "
					+ this.entidadRegistrar.getCodigoCliente());
			this.entidadRegistrar.setCodigoCliente("");
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
				
				persona.setUsuario(new OmsUsuario());
				this.entidadRegistrar.setPersona(persona);
				
				
			}
		} else {
			OmsgTipoDocumentoIdentificacion tipoDoc = new OmsgTipoDocumentoIdentificacion();
			//entidadRegistrar = new OmsoEmpleado();
			OmsgPersona lPersona = new OmsgPersona();
			
			lPersona.setUsuario(new OmsUsuario());
			lPersona.setNumeroDocumento(lDato);
			this.entidadRegistrar.setPersona(lPersona);
			entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
			
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
			
			
			OmsRole lRol = new OmsRole();
			lRol.setId(101L);
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

	
}
