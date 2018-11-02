package edu.sae.modulo.servicio.escolar;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.sae.modulo.dominio.aplicacion.OmsAccesosDirecto;
import edu.sae.modulo.dominio.escolar.SaeAnioLectivo;
import edu.sae.modulo.dominio.escolar.SaeEstudiante;
import edu.sae.modulo.dominio.escolar.SaeMatricula;
import edu.sae.modulo.eao.escolar.SaeMatriculaEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoMatricula 
extends
ServicioMantenedorControlAuditoria<SaeMatriculaEAO, SaeMatricula, Long>
{

	@EJB
	private SaeMatriculaEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SaeMatriculaEAO getCrud() {
		return crud;
	}

	public void eliminarMatricula(SaeEstudiante lEstudiante, SaeAnioLectivo lAnioLectivoSeleccionado) {
		
		String sql = "delete from sae_matricula where ID_ANIO_LECTIVO = :idAnio and ID_ESTUDIANTE = :idEstudiante";
		Query query = crud.getAdminEntidad().createNativeQuery(sql, SaeMatricula.class);
		query.setParameter("idAnio", lAnioLectivoSeleccionado.getId());
		query.setParameter("idEstudiante", lEstudiante.getId());
		query.executeUpdate();
	}

}
