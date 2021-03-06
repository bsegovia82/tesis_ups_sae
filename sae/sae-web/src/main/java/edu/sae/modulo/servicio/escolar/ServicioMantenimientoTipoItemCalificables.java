package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.escolar.SaeTipoItemsCalificables;
import edu.sae.modulo.eao.escolar.SaeTipoItemsCalificablesEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoTipoItemCalificables 
extends
ServicioMantenedorControlAuditoria<SaeTipoItemsCalificablesEAO, SaeTipoItemsCalificables, Long>
{

	@EJB
	private SaeTipoItemsCalificablesEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SaeTipoItemsCalificablesEAO getCrud() {
		return crud;
	}

}
