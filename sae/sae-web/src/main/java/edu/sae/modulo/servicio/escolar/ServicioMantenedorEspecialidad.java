package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.empresa.OmsoEspecialidad;
import edu.sae.modulo.eao.empresa.OmsoEspecialidadEAO;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioMantenedorEspecialidad.
 */
@Stateless
public class ServicioMantenedorEspecialidad
		extends ServicioMantenedorControlAuditoria<OmsoEspecialidadEAO, OmsoEspecialidad, Long> {

	/** The crud. */
	@EJB
	private OmsoEspecialidadEAO crud;

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#getCrud()
	 */
	protected OmsoEspecialidadEAO getCrud() {
		return crud;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#cargarConfiguracionServicio()
	 */
	@Override
	protected void cargarConfiguracionServicio() {

		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmsoEspecialidad, Long>() {

			@Override
			public void validacionTransaccional(OmsoEspecialidad entidad) throws ErrorServicioNegocio {
				OmsoEspecialidad especilidad = crud.obtenerObjetoPorCampoGenerico("nombreEspecialidad",
						entidad.getNombreEspecialidad(), OmsoEspecialidad.class);
				if (especilidad != null) {
					throw new ErrorServicioNegocio(
							"La especialidad " + especilidad.getNombreEspecialidad() + ", ya se encuentra registrado");
				}

			}
		});
		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmsoEspecialidad, Long>() {

			@Override
			public void validacionTransaccional(OmsoEspecialidad entidad) throws ErrorServicioNegocio {
				OmsoEspecialidad especilidad = crud.obtenerObjetoPorCampoGenerico("nombreEspecialidad",
						entidad.getNombreEspecialidad(), OmsoEspecialidad.class);
				if (especilidad != null) {
					if (!especilidad.getId().equals(entidad.getId())) {
						throw new ErrorServicioNegocio("La especialidad " + especilidad.getNombreEspecialidad()
								+ ", ya se encuentra registrado");
					}
				}

			}
		});
	}

}
