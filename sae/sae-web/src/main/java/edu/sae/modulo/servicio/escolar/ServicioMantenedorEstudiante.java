package edu.sae.modulo.servicio.escolar;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.dominio.escolar.SaeAnioLectivo;
import edu.sae.modulo.dominio.escolar.SaeEstudiante;
import edu.sae.modulo.dominio.escolar.SaeMatricula;
import edu.sae.modulo.eao.empresa.OmsgPersonaEAO;
import edu.sae.modulo.eao.escolar.SaeEstudianteEAO;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.exceptions.ErrorValidacionGeneral;
import edu.sae.modulo.librerias.servicio.oyentes.AccionTransaccionalListener;
import edu.sae.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import edu.sae.modulo.librerias.servicio.oyentes.PreLlenadoRegistroListener;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuarioRol;


// TODO: Auto-generated Javadoc
/**
 * The Class ServicioMantenedorEmpleado.
 */
@Stateless
public class ServicioMantenedorEstudiante
		extends ServicioMantenedorControlAuditoria<SaeEstudianteEAO, SaeEstudiante, Long> {

	/** The Constant SEMILLA_CODIGO_EMPLEADO. */
	private static final String SEMILLA_CODIGO_EMPLEADO = "EMP-";

	/** The crud. */
	@EJB
	private SaeEstudianteEAO crud;

	/** The persona EAO. */
	@EJB
	private OmsgPersonaEAO personaEAO;

	/** The servicio usuario rol. */
	@EJB
	private ServicioMantenedorUsuarioRol servicioUsuarioRol;

	
	/** The servicio mantenedor usuario. */
	@EJB
	private ServicioMantenedorUsuario servicioMantenedorUsuario;

	/** The servicio especialidad. */
	

	@EJB
	private ServicioMantenimientoMatricula lServicioMatricula;
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#getCrud()
	 */
	protected SaeEstudianteEAO getCrud() {
		return crud;
	}

	/**
	 * Generador codigo empleado.
	 *
	 * @return the string
	 */
	public static String generadorCodigoEmpleado() {
		return SEMILLA_CODIGO_EMPLEADO + new Date().getTime();
	}

		

	/**
	 * Cargar empleado por identificacion.
	 *
	 * @param numeroIdentificacion the numero identificacion
	 * @return the omso empleado
	 */
	public SaeEstudiante cargarEmpleadoPorIdentificacion(String numeroIdentificacion) {
		OmsgPersona personaBase = buscarPersonaIdentificacion(numeroIdentificacion);
		SaeEstudiante empleadoNew = new SaeEstudiante();
		empleadoNew.setPersona(personaBase);
		return empleadoNew;
	}

	/**
	 * Buscar empleado por identificacion.
	 *
	 * @param numeroIdentificacion the numero identificacion
	 * @return the omso empleado
	 */
	public SaeEstudiante buscarEmpleadoPorIdentificacion(String numeroIdentificacion) {
		return getCrud().buscarEmpleadoPorIdPersona(buscarPersonaIdentificacion(numeroIdentificacion).getId());
	}

	/**
	 * Buscar persona identificacion.
	 *
	 * @param numeroIdentificacion the numero identificacion
	 * @return the omsg persona
	 */
	public OmsgPersona buscarPersonaIdentificacion(String numeroIdentificacion) {
		return personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO, numeroIdentificacion,
				OmsgPersona.class);
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#cargarConfiguracionServicio()
	 */
	@Override
	protected void cargarConfiguracionServicio() {

		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<SaeEstudiante, Long>() {

			@Override
			public void validacionTransaccional(SaeEstudiante entidad) throws ErrorServicioNegocio {
				OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO,
						entidad.getPersona().getNumeroDocumento(), OmsgPersona.class);

				if (personaBase != null && !personaBase.getId().equals(entidad.getPersona().getId())) {
					throw new ErrorServicioNegocio(
							"La identificación " + personaBase.getNumeroDocumento() + ", ya se encuentra registrada");
				}

			}
		});

		addValidacionTransaccionalInsertListener(new AccionValidacionListener<SaeEstudiante, Long>() {

			@Override
			public void validacionTransaccional(SaeEstudiante entidad) throws ErrorServicioNegocio {
				OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO,
						entidad.getPersona().getNumeroDocumento(), OmsgPersona.class);

				if (personaBase != null) {
					SaeEstudiante empleadoBase = getCrud().buscarEmpleadoPorIdPersona(personaBase.getId());
					if (empleadoBase != null) {
						throw new ErrorServicioNegocio("La identificación " + personaBase.getNumeroDocumento()
								+ ", ya se encuentra asociada a un empleado");
					}
				}

			}
		});

		addDatosRegistroInsertListener(new PreLlenadoRegistroListener<SaeEstudiante, Long>() {

			@Override
			public void preCargaDatosRegistro(SaeEstudiante entidad) {
				entidad.setCodigoCliente(generadorCodigoEmpleado());

			}
		});

		addPreInsertListener(new AccionTransaccionalListener<SaeEstudiante, Long>() {

			@Override
			public void controlTransaccional(SaeEstudiante entidad) throws ErrorServicioNegocio, ErrorValidacionGeneral {
				// personaEAO.insertar(entidad.getPersona());
				System.out.println("SIN PREINSERT QUE REALIZAR");
			}
		});

	}

	/**
	 * Guardar actualizar persona.
	 *
	 * @param pPersona the persona
	 */
	public void guardarActualizarPersona(OmsgPersona pPersona) {
		if (pPersona.getId() == null)
			personaEAO.insertar(pPersona);
		else
			personaEAO.actualizar(pPersona);
	}

	public List<SaeMatricula> obtenerEstudiantesMatriculados(SaeAnioLectivo lAnioLectivoSeleccionado) {
		
		HashMap<String, Object> parametros = new HashMap<>();
		parametros.put("anio", lAnioLectivoSeleccionado.getId());
		String lQuery = "select * " + 
				"from sae_matricula  " + 
				"where estado = 'A' " + 
				"and id_anio_lectivo = :anio ";
		
		return lServicioMatricula.ejecutarQueryNativoObjeto(lQuery, parametros, SaeMatricula.class);
	}

	public List<SaeEstudiante> obtenerEstudiantesSinMatricula(SaeAnioLectivo lAnioLectivoSeleccionado) {
		HashMap<String, Object> parametros = new HashMap<>();
		parametros.put("anio", lAnioLectivoSeleccionado.getId());
		String lQuery = "select * from sae_estudiante " + 
				"where estado = 'A' " + 
				"and id not in ( " + 
				"select id_estudiante " + 
				"from sae_matricula  " + 
				"where estado = 'A' " + 
				"and id_anio_lectivo = :anio " + 
				")";
		return crud.ejecutarQueryNativo(lQuery, parametros, SaeEstudiante.class);
	}

}
