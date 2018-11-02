package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import edu.sae.modulo.dominio.escolar.SaeAnioLectivo;
import edu.sae.modulo.dominio.escolar.SaeCursosAnio;
import edu.sae.modulo.dominio.escolar.SaeDocente;
import edu.sae.modulo.dominio.escolar.SaeEstudiante;
import edu.sae.modulo.dominio.escolar.SaeMatricula;
import edu.sae.modulo.dominio.escolar.SaeNotasEstudiante;
import edu.sae.modulo.dominio.escolar.SaeTipoItemsCalificables;
import edu.sae.modulo.eao.escolar.SaeNotasEstudianteEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.ControlListaEntidadesPersonalizada;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorCursoAnio;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorDocente;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoAnioLectivo;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoMatricula;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoNotasEstudiantes;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoTipoItemCalificables;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorMatricula.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorNotasPrimeroBasica extends
		BeanMantenedorGenerico<ServicioMantenimientoNotasEstudiantes, Long, SaeNotasEstudiante, SaeNotasEstudianteEAO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */

	private SaeAnioLectivo lAnioLectivoSeleccionado;
	private SaeCursosAnio lCursoAnioSeleccionado;
	private List<SaeMatricula> lListaEstudiantesMatriculados;
	private List<SaeDocente> lListaDocentes;

	private List<SaeNotasEstudiante> lListaNotasEstudiantes;

	@EJB
	private ServicioMantenimientoAnioLectivo lServicioMantenimientoAnio;

	@EJB
	private ServicioMantenimientoNotasEstudiantes servicioMantenedor;

	@EJB
	private ServicioMantenedorCursoAnio lServicioCursoAnio;

	@EJB
	private ServicioMantenimientoMatricula servicioMantenedorMatricula;

	@EJB
	private ServicioMantenimientoTipoItemCalificables servicioMantenedorTipoItem;

	@EJB
	private ServicioMantenedorDocente servicioDocente;

	private String lQuimestreSeleccionado;

	private SaeEstudiante lEstudianteSeleccionado;
	private SaeDocente lDocenteSeleccionado;

	public BeanMantenedorNotasPrimeroBasica() {
		super(SaeNotasEstudiante.class);

		addPostConstructuListener(new PostConstructListener() {
			@Override
			public void metodoPostConstruct() {
				lEstudianteSeleccionado = new SaeEstudiante();
				lDocenteSeleccionado = new SaeDocente();
				List<SaeAnioLectivo> lListaAnios = lServicioMantenimientoAnio.listaObjetosActivos(SaeAnioLectivo.class);
				if (lListaAnios.isEmpty()) {
					lListaDocentes = new ArrayList<>();
					lListaEstudiantesMatriculados = new ArrayList<>();
				} else {
					lAnioLectivoSeleccionado = lListaAnios.get(0);
					String lQuery = "select * from sae_curso_anio where id_anio = :idAnio and id_curso = 1 and estado = 'A'";
					HashMap<String, Object> lParametros = new HashMap<>();
					lParametros.put("idAnio", lAnioLectivoSeleccionado.getId());
					List<SaeCursosAnio> listaCursoAnio = lServicioCursoAnio.ejecutarQueryNativoObjeto(lQuery,
							lParametros, SaeCursosAnio.class);

					if (listaCursoAnio.isEmpty()) {
						lListaEstudiantesMatriculados = new ArrayList<>();
					} else {
						lCursoAnioSeleccionado = listaCursoAnio.get(0);
						String lQueryEstudiante = " select *  " + "				from sae_matricula  "
								+ "				where estado = 'A' " + "				and id_anio_lectivo = :anio "
								+ "             and ID_CURSO_ANIO = :idCursoAnio ";

						HashMap<String, Object> lParametrosEstudiantes = new HashMap<>();
						lParametrosEstudiantes.put("anio", lAnioLectivoSeleccionado.getId());
						lParametrosEstudiantes.put("idCursoAnio", lCursoAnioSeleccionado.getId());

						lListaEstudiantesMatriculados = servicioMantenedorMatricula.ejecutarQueryNativoObjeto(
								lQueryEstudiante, lParametrosEstudiantes, SaeMatricula.class);

						String lQueryDocente = "select * from sae_docente where id in ( "
								+ "select id_docente from sae_materia_curso_anio where id_curso_anio = :idCursoAnio "
								+ "and estado = 'A' " + ") " + "and estado = 'A'";
						HashMap<String, Object> lParametrosDocente = new HashMap<>();
						lParametrosDocente.put("idCursoAnio", lCursoAnioSeleccionado.getId());

						lListaDocentes = servicioDocente.ejecutarQueryNativoObjeto(lQueryDocente, lParametrosDocente,
								SaeDocente.class);	
						
						lListaNotasEstudiantes = new ArrayList<>();
					}

				}

			}
		});

		addControlListaEntidadesPersonalizada(new ControlListaEntidadesPersonalizada() {

			@Override
			public void cargarListaEntidades() {
				setListaEntidades(new ArrayList<>());

			}
		});

		addPostTransaccion(new PostTransaccionListener() {

			@Override
			public void metodoPostTransaccion() {

				entidadRegistrar = new SaeNotasEstudiante();

			}
		});

		addPostEventoInicializacion(() -> {

		});

	}

	public void consulta(AjaxBehaviorEvent lEvento) {
		System.out.println("Anio " + lAnioLectivoSeleccionado.getId());
		
		
		String lQueryNotas = "select * from sae_tipo_items_calificables where id not in ( "
				+ "select id from sae_tipo_items_calificables where id  in ( "
				+ "select id_tipo_item_padre from sae_tipo_items_calificables where estado = 'A' "
				+ ") " + "and estado = 'A' " + ") " + "and estado = 'A' "
				+ "and id_curso_anio = :idCursoAnio " + "order by lLiteralTipo";
		
		HashMap<String, Object> lParametrosNotas = new HashMap<>();
		lParametrosNotas.put("idCursoAnio", lCursoAnioSeleccionado.getId());
		List<SaeTipoItemsCalificables> lListaTipoItems = servicioMantenedorTipoItem
				.ejecutarQueryNativoObjeto(lQueryNotas, lParametrosNotas,
						SaeTipoItemsCalificables.class);
		lListaNotasEstudiantes = new ArrayList<>();
		for (SaeTipoItemsCalificables tipo : lListaTipoItems) {
			SaeNotasEstudiante lNota = new SaeNotasEstudiante();
			lNota.setlTipoItem(tipo);
			lNota.setAuditoria(usuarioAutenticado());
			lNota.setEstado("A");
			lNota.setFechaRegistro(new Date());
			lNota.setIdReferencia(1L);
			lNota.setlAnioLectivo(lAnioLectivoSeleccionado);
			lNota.setlCursoAnio(lCursoAnioSeleccionado);
			lListaNotasEstudiantes.add(lNota);
		}
		

		String lQuery = "select * from sae_notas_estudiantes s " + "where s.ID_TIPO_ITEM = :idTipoItem "
				+ "and s.ID_ESTUDIANTE = :idEstudiante " + "and s.ID_CURSO_ANIO = :idCursoAnio "
				+ "and s.ID_DOCENTE = :idDocente "
				+ "and s.lQuimestreTrimestre = :quimestre " + "and s.ESTADO = 'A'";

		
		
		for (SaeNotasEstudiante nota : lListaNotasEstudiantes) {
			HashMap<String, Object> lParametro = new HashMap<>();
			lParametro.put("idTipoItem", nota.getlTipoItem().getId());
			lParametro.put("idEstudiante", lEstudianteSeleccionado.getId());
			lParametro.put("idCursoAnio", lCursoAnioSeleccionado.getId());
			lParametro.put("idDocente", lDocenteSeleccionado.getId());
			lParametro.put("quimestre", lQuimestreSeleccionado);
			
			List<SaeNotasEstudiante> lNotasDB = servicioMantenedor.ejecutarQueryNativoObjeto(lQuery, lParametro,
					SaeNotasEstudiante.class);
			if (!lNotasDB.isEmpty()) 
			{
				nota.setId(lNotasDB.get(0).getId()); 
				nota.setlNotaAporte(lNotasDB.get(0).getlNotaAporte());
				nota.setlRecomendacion(lNotasDB.get(0).getlRecomendacion()); 
			}
		
				nota.setlDocente(lDocenteSeleccionado);
				nota.setlEstudiante(lEstudianteSeleccionado);
				nota.setlQuimestreTrimestre(lQuimestreSeleccionado);
			
		}
		
		System.out.println(lListaNotasEstudiantes);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#
	 * getServicioMantenedor()
	 */
	@Override
	protected ServicioMantenimientoNotasEstudiantes getServicioMantenedor() {
		return servicioMantenedor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#
	 * cargarListaEtiquetas()
	 */
	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Notas a Registrar");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Notas");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Matriculas registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Matriculas registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	public SaeAnioLectivo getlAnioLectivoSeleccionado() {
		return lAnioLectivoSeleccionado;
	}

	public void setlAnioLectivoSeleccionado(SaeAnioLectivo lAnioLectivoSeleccionado) {
		this.lAnioLectivoSeleccionado = lAnioLectivoSeleccionado;
	}

	public SaeCursosAnio getlCursoAnioSeleccionado() {
		return lCursoAnioSeleccionado;
	}

	public void setlCursoAnioSeleccionado(SaeCursosAnio lCursoAnioSeleccionado) {
		this.lCursoAnioSeleccionado = lCursoAnioSeleccionado;
	}

	public List<SaeMatricula> getlListaEstudiantesMatriculados() {
		return lListaEstudiantesMatriculados;
	}

	public void setlListaEstudiantesMatriculados(List<SaeMatricula> lListaEstudiantesMatriculados) {
		this.lListaEstudiantesMatriculados = lListaEstudiantesMatriculados;
	}

	public List<SaeDocente> getlListaDocentes() {
		return lListaDocentes;
	}

	public void setlListaDocentes(List<SaeDocente> lListaDocentes) {
		this.lListaDocentes = lListaDocentes;
	}

	public String getlQuimestreSeleccionado() {
		return lQuimestreSeleccionado;
	}

	public void setlQuimestreSeleccionado(String lQuimestreSeleccionado) {
		this.lQuimestreSeleccionado = lQuimestreSeleccionado;
	}

	public SaeEstudiante getlEstudianteSeleccionado() {
		return lEstudianteSeleccionado;
	}

	public void setlEstudianteSeleccionado(SaeEstudiante lEstudianteSeleccionado) {
		this.lEstudianteSeleccionado = lEstudianteSeleccionado;
	}

	public SaeDocente getlDocenteSeleccionado() {
		return lDocenteSeleccionado;
	}

	public void setlDocenteSeleccionado(SaeDocente lDocenteSeleccionado) {
		this.lDocenteSeleccionado = lDocenteSeleccionado;
	}

	public List<SaeNotasEstudiante> getlListaNotasEstudiantes() {
		return lListaNotasEstudiantes;
	}

	public void setlListaNotasEstudiantes(List<SaeNotasEstudiante> lListaNotasEstudiantes) {
		this.lListaNotasEstudiantes = lListaNotasEstudiantes;
	}

	public void registrarNota(AjaxBehaviorEvent lEvento) {
		SaeNotasEstudiante lNota = (SaeNotasEstudiante) lEvento.getComponent().getAttributes().get("NOTA");

		SaeTipoItemsCalificables ltipo = lNota.getlTipoItem();
		
		entidadRegistrar = lNota;

		try {
			guardarOActualizar();

			
			String lQuery = "select * from sae_notas_estudiantes s " + "where s.ID_TIPO_ITEM = :idTipoItem "
					+ "and s.ID_ESTUDIANTE = :idEstudiante " + "and s.ID_CURSO_ANIO = :idCursoAnio "
					+ "and s.ID_DOCENTE = :idDocente " + "and s.ESTADO = 'A'";

			
			HashMap<String, Object> lParametro = new HashMap<>();
			lParametro.put("idTipoItem", ltipo.getId());
			lParametro.put("idEstudiante", lEstudianteSeleccionado.getId());
			lParametro.put("idCursoAnio", lCursoAnioSeleccionado.getId());
			lParametro.put("idDocente", lDocenteSeleccionado.getId());
			List<SaeNotasEstudiante> lNotasDB = servicioMantenedor.ejecutarQueryNativoObjeto(lQuery, lParametro,
					SaeNotasEstudiante.class);
			
			lNota = lNotasDB.get(0);
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
