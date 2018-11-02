package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.escolar.SaeMateria;
import edu.sae.modulo.eao.escolar.SaeMateriaEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoMateria 
extends
ServicioMantenedorControlAuditoria<SaeMateriaEAO, SaeMateria, Long>
{

	@EJB
	private SaeMateriaEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SaeMateriaEAO getCrud() {
		return crud;
	}

}
