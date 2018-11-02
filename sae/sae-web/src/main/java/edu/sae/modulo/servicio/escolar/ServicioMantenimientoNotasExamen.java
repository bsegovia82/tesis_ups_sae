package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.escolar.SaeNotasExamen;
import edu.sae.modulo.eao.escolar.SaeNotasExamenEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoNotasExamen 
extends
ServicioMantenedorControlAuditoria<SaeNotasExamenEAO, SaeNotasExamen, Long>
{

	@EJB
	private SaeNotasExamenEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SaeNotasExamenEAO getCrud() {
		return crud;
	}

}
