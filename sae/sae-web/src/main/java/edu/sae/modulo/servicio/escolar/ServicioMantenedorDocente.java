package edu.sae.modulo.servicio.escolar;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.dominio.empresa.OmsoCargo;
import edu.sae.modulo.dominio.escolar.SaeDocente;
import edu.sae.modulo.eao.empresa.OmsgPersonaEAO;
import edu.sae.modulo.eao.escolar.SaeDocenteEAO;
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
public class ServicioMantenedorDocente
		extends ServicioMantenedorControlAuditoria<SaeDocenteEAO, SaeDocente, Long> {

	/** The Constant SEMILLA_CODIGO_EMPLEADO. */
	private static final String SEMILLA_CODIGO_EMPLEADO = "EMP-";

	/** The crud. */
	@EJB
	private SaeDocenteEAO crud;

	/** The persona EAO. */
	@EJB
	private OmsgPersonaEAO personaEAO;

	/** The servicio usuario rol. */
	@EJB
	private ServicioMantenedorUsuarioRol servicioUsuarioRol;

	/** The servicio cargo. */
	@EJB
	private ServicioMantenedorCargo servicioCargo;

	/** The servicio mantenedor usuario. */
	@EJB
	private ServicioMantenedorUsuario servicioMantenedorUsuario;

	/** The servicio especialidad. */
	

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#getCrud()
	 */
	protected SaeDocenteEAO getCrud() {
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
	 * Obtener lista cargos.
	 *
	 * @return the list
	 */
	public List<OmsoCargo> obtenerListaCargos() {
		return servicioCargo.listaObjetosActivos(OmsoCargo.class);
	}

	/**
	 * Obtener lista especialidad.
	 *
	 * @return the list
	 */
	

	/**
	 * Cargar empleado por identificacion.
	 *
	 * @param numeroIdentificacion the numero identificacion
	 * @return the omso empleado
	 */
	public SaeDocente cargarEmpleadoPorIdentificacion(String numeroIdentificacion) {
		OmsgPersona personaBase = buscarPersonaIdentificacion(numeroIdentificacion);
		SaeDocente empleadoNew = new SaeDocente();
		empleadoNew.setPersona(personaBase);
		return empleadoNew;
	}

	/**
	 * Buscar empleado por identificacion.
	 *
	 * @param numeroIdentificacion the numero identificacion
	 * @return the omso empleado
	 */
	public SaeDocente buscarEmpleadoPorIdentificacion(String numeroIdentificacion) {
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

		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<SaeDocente, Long>() {

			@Override
			public void validacionTransaccional(SaeDocente entidad) throws ErrorServicioNegocio {
				OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO,
						entidad.getPersona().getNumeroDocumento(), OmsgPersona.class);

				if (personaBase != null && !personaBase.getId().equals(entidad.getPersona().getId())) {
					throw new ErrorServicioNegocio(
							"La identificación " + personaBase.getNumeroDocumento() + ", ya se encuentra registrada");
				}

			}
		});

		addValidacionTransaccionalInsertListener(new AccionValidacionListener<SaeDocente, Long>() {

			@Override
			public void validacionTransaccional(SaeDocente entidad) throws ErrorServicioNegocio {
				OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO,
						entidad.getPersona().getNumeroDocumento(), OmsgPersona.class);

				if (personaBase != null) {
					SaeDocente empleadoBase = getCrud().buscarEmpleadoPorIdPersona(personaBase.getId());
					if (empleadoBase != null) {
						throw new ErrorServicioNegocio("La identificación " + personaBase.getNumeroDocumento()
								+ ", ya se encuentra asociada a un empleado");
					}
				}

			}
		});

		addDatosRegistroInsertListener(new PreLlenadoRegistroListener<SaeDocente, Long>() {

			@Override
			public void preCargaDatosRegistro(SaeDocente entidad) {
				entidad.setCodigoEmpleado(generadorCodigoEmpleado());

			}
		});

		addPreInsertListener(new AccionTransaccionalListener<SaeDocente, Long>() {

			@Override
			public void controlTransaccional(SaeDocente entidad) throws ErrorServicioNegocio, ErrorValidacionGeneral {
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

}
