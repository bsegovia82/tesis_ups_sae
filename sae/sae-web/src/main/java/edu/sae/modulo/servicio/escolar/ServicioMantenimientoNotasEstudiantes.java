package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.escolar.SaeNotasEstudiante;
import edu.sae.modulo.eao.escolar.SaeNotasEstudianteEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoNotasEstudiantes 
extends
ServicioMantenedorControlAuditoria<SaeNotasEstudianteEAO, SaeNotasEstudiante, Long>
{

	@EJB
	private SaeNotasEstudianteEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SaeNotasEstudianteEAO getCrud() {
		return crud;
	}

}
