package edu.sae.modulo.servicio.escolar;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.sae.modulo.dominio.escolar.SaeAnioLectivo;
import edu.sae.modulo.dominio.escolar.SaeCurso;
import edu.sae.modulo.dominio.escolar.SaeCursosAnio;
import edu.sae.modulo.dominio.escolar.SaeMatricula;
import edu.sae.modulo.eao.escolar.SaeAnioLectivoEAO;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.exceptions.ErrorValidacionGeneral;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoAnioLectivo
		extends ServicioMantenedorControlAuditoria<SaeAnioLectivoEAO, SaeAnioLectivo, Long> {

	@EJB
	private SaeAnioLectivoEAO crud;

	@EJB
	private ServicioMantenimientoCurso lMantenimientoCurso;

	@EJB
	private ServicioMantenedorCursoAnio lServicioCursoAnio;

	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub

	}

	@Override
	protected SaeAnioLectivoEAO getCrud() {
		return crud;
	}

	public List<SaeCurso> obtenerCursosAsignadosAnio(Long id) {

		HashMap<String, Object> lParametros = new HashMap<>();

		lParametros.put("anio", id);

		List<SaeCurso> lCurso = lMantenimientoCurso.ejecutarQueryNativoObjeto(
				"select * from sae_curso " + "where id in ( " + " " + "select id_curso " + "from sae_curso_anio "
						+ "where estado = 'A' " + "and id_anio =  :anio " + ") " + "and estado = 'A'",
				lParametros, SaeCurso.class);

		return lCurso;
	}

	public List<SaeCurso> obtenerCursosPorAsignarAnio(String usuarioAutenticado, Long id,
			Serializable obtenerObjetoSesion) {
		HashMap<String, Object> lParametros = new HashMap<>();

		lParametros.put("anio", id);

		List<SaeCurso> lCurso = lMantenimientoCurso.ejecutarQueryNativoObjeto(
				"select * from sae_curso " + "where id not in ( " + " " + "select id_curso " + "from sae_curso_anio "
						+ "where estado = 'A' " + "and id_anio =  :anio " + ") " + "and estado = 'A'",
				lParametros, SaeCurso.class);

		return lCurso;
	}

	public void asigarCurso(List<String> lOpcionesTransferidas, String usuarioAutenticado, Long id, Long referencia)
			throws ErrorServicioNegocio, ErrorValidacionGeneral {

		for (String lCurso : lOpcionesTransferidas) {
			
			
			SaeCurso lCursoDB = lMantenimientoCurso.obtenerObjetoPropiedad("lNombreCurso", lCurso, SaeCurso.class);
			SaeCursosAnio lCursoAnio = new SaeCursosAnio();

			lCursoAnio.setAuditoria(usuarioAutenticado);
			lCursoAnio.setEstado("A");
			lCursoAnio.setFechaRegistro(new Date());
			lCursoAnio.setIdReferencia(1L);
			SaeAnioLectivo lAnio = new SaeAnioLectivo();
			lAnio.setId(id);
			lCursoAnio.setlAnioLectivo(lAnio);
			lCursoAnio.setlCurso(lCursoDB);
			lCursoAnio.setlNombreAsignacion(lCursoDB.getlNombreCurso());
			lCursoAnio.setObservacion("Registro desde la web");
			lServicioCursoAnio.guardarActualizar(lCursoAnio);
		}
	}

	public void inactivarCurso(List<String> lOpcionesTransferidas, String usuarioAutenticado, Long id)
			throws ErrorServicioNegocio, ErrorValidacionGeneral {
		for (String lCurso : lOpcionesTransferidas) {
			SaeCurso lCursoDB = lMantenimientoCurso.obtenerObjetoPropiedad("lNombreCurso", lCurso, SaeCurso.class);
			HashMap<String, Object> lParametros = new HashMap<>();
			lParametros.put("idCurso", lCursoDB.getId());
			lParametros.put("idAnio", id);
			
			
			List<SaeCursosAnio> lListaCurso = lServicioCursoAnio.ejecutarQueryNativoObjeto(
					"select * from sae_curso_anio "
					+ "where estado = 'A' and id_anio =  :anio and id_curso = :idCurso ", lParametros, SaeCursosAnio.class);
			
			if (lListaCurso.isEmpty())
				continue;
			
			SaeCursosAnio lCursoAnio = lListaCurso.get(0);
			
			lCursoAnio.setEstado("I");
			lCursoAnio.setFechaActualizacion(new Date());
			lServicioCursoAnio.guardarActualizar(lCursoAnio);
		}
	}

	public void inaactivarAniosLectivos() {
		String sql = "update SAE_ANIO_LECTIVO set estado = 'I'";
		Query query = crud.getAdminEntidad().createNativeQuery(sql, SaeMatricula.class);
		query.executeUpdate();
		
	}

}
