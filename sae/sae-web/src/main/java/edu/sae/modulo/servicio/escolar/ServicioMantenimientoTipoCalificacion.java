package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.escolar.SaeTipoCalificacion;
import edu.sae.modulo.eao.escolar.SaeTipoCalificacionEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoTipoCalificacion 
extends
ServicioMantenedorControlAuditoria<SaeTipoCalificacionEAO, SaeTipoCalificacion, Long>
{

	@EJB
	private SaeTipoCalificacionEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SaeTipoCalificacionEAO getCrud() {
		return crud;
	}

}
