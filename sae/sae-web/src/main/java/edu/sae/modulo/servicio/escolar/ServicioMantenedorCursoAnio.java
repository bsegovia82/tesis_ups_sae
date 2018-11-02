package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.escolar.SaeCursosAnio;
import edu.sae.modulo.eao.escolar.SaeCursoAnioEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioMantenedorCargo.
 */
@Stateless
public class ServicioMantenedorCursoAnio extends 
ServicioMantenedorControlAuditoria<SaeCursoAnioEAO, SaeCursosAnio, Long> {

	/** The crud. */
	@EJB
	private SaeCursoAnioEAO crud;

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#getCrud()
	 */
	protected SaeCursoAnioEAO getCrud() {
		return crud;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad#cargarConfiguracionServicio()
	 */
	@Override
	protected void cargarConfiguracionServicio() {
		System.out.println("Nada que hacer");		
	}

	


	

}
