package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.escolar.SaeMateriaCursoAnio;
import edu.sae.modulo.eao.escolar.SaeMateriaCursoAnioEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoMateriaCursoAnio
		extends ServicioMantenedorControlAuditoria<SaeMateriaCursoAnioEAO, SaeMateriaCursoAnio, Long> {

	@EJB
	private SaeMateriaCursoAnioEAO crud;

	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub

	}

	@Override
	protected SaeMateriaCursoAnioEAO getCrud() {
		return crud;
	}

}
