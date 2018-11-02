package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.escolar.SaeCurso;
import edu.sae.modulo.eao.escolar.SaeCursoEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoCurso 
extends
ServicioMantenedorControlAuditoria<SaeCursoEAO, SaeCurso, Long>
{

	@EJB
	private SaeCursoEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SaeCursoEAO getCrud() {
		return crud;
	}

}
