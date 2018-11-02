package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.empresa.OmsoCargo;
import edu.sae.modulo.eao.empresa.OmsoCargoEAO;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioMantenedorCargo.
 */
@Stateless
public class ServicioMantenedorCargo extends 
ServicioMantenedorControlAuditoria<OmsoCargoEAO, OmsoCargo, Long> {

	/** The crud. */
	@EJB
	private OmsoCargoEAO crud;

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#getCrud()
	 */
	protected OmsoCargoEAO getCrud() {
		return crud;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#cargarConfiguracionServicio()
	 */
	@Override
	protected void cargarConfiguracionServicio() {
		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmsoCargo, Long>() {
		
		@Override
		public void validacionTransaccional(OmsoCargo entidad) throws ErrorServicioNegocio {
			OmsoCargo cargoBase = crud.
					obtenerObjetoPorCampoGenerico(
							"nombreCargo",
					entidad.getNombreCargo(), OmsoCargo.class);
			if (cargoBase != null && !cargoBase.getId().equals(entidad.getId()))
				throw new ErrorServicioNegocio(
						"El nombre del cargo " + cargoBase.getNombreCargo() + ", ya se encuentra registrado");
			
		}
		
		});
		
		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmsoCargo, Long>() {
			
			@Override
			public void validacionTransaccional(OmsoCargo entidad) throws ErrorServicioNegocio {
				OmsoCargo cargoBase = crud.
						obtenerObjetoPorCampoGenerico(
								"nombreCargo",
						entidad.getNombreCargo(), OmsoCargo.class);
				if (cargoBase != null)
					throw new ErrorServicioNegocio(
							"El nombre del cargo " + cargoBase.getNombreCargo() + ", ya se encuentra registrado");
				
			}
		});
		
	}

	


	

}
