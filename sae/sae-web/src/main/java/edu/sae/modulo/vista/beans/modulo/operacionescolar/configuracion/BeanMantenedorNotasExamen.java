package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.dominio.escolar.SaeAnioLectivo;
import edu.sae.modulo.dominio.escolar.SaeCursosAnio;
import edu.sae.modulo.dominio.escolar.SaeDocente;
import edu.sae.modulo.dominio.escolar.SaeMateriaCursoAnio;
import edu.sae.modulo.dominio.escolar.SaeMatricula;
import edu.sae.modulo.dominio.escolar.SaeNotasExamen;
import edu.sae.modulo.eao.escolar.SaeNotasExamenEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.ControlListaEntidadesPersonalizada;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorCursoAnio;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorDocente;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoAnioLectivo;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoMateriaCursoAnio;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoMatricula;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoNotasExamen;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoTipoItemCalificables;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorMatricula.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorNotasExamen extends
		BeanMantenedorGenerico<ServicioMantenimientoNotasExamen, Long, SaeNotasExamen, SaeNotasExamenEAO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */

	private SaeAnioLectivo lAnioLectivoSeleccionado;
	private SaeCursosAnio lCursoAnioSeleccionado;
	private List<SaeMatricula> lListaEstudiantesMatriculados;
	private List<SaeDocente> lListaDocentes;

	private List<SaeNotasExamen> lListaNotasEstudiantes;

	@EJB
	private ServicioMantenimientoAnioLectivo lServicioMantenimientoAnio;

	@EJB
	private ServicioMantenimientoNotasExamen servicioMantenedor;

	@EJB
	private ServicioMantenedorCursoAnio lServicioCursoAnio;
	
	@EJB
	private ServicioMantenimientoMateriaCursoAnio lServicioMateriaCursoAnio;
	

	@EJB
	private ServicioMantenimientoMatricula servicioMantenedorMatricula;

	@EJB
	private ServicioMantenimientoTipoItemCalificables servicioMantenedorTipoItem;

	@EJB
	private ServicioMantenedorDocente servicioDocente;

	private String lQuimestreSeleccionado;

	private SaeDocente lDocenteSeleccionado;
	
	private SaeMateriaCursoAnio lMateriaCursoAnioSeleccionado;

	private List<SaeCursosAnio> listaCursoAnio;
	private List<SaeMateriaCursoAnio> listaMateriaCursoAnio;

	public BeanMantenedorNotasExamen() {
		super(SaeNotasExamen.class);
		listaMateriaCursoAnio = new ArrayList<>();
		
		addPostConstructuListener(new PostConstructListener() {
			@Override
			public void metodoPostConstruct() {
				lCursoAnioSeleccionado = new SaeCursosAnio();
				lDocenteSeleccionado = new SaeDocente();
				OmsgPersona lPersona = new OmsgPersona();
				lListaNotasEstudiantes = new ArrayList<>();
				lPersona.setNombres("");
				lPersona.setApellidos("");
				lDocenteSeleccionado.setPersona(lPersona);
				lMateriaCursoAnioSeleccionado = new SaeMateriaCursoAnio();
				lListaEstudiantesMatriculados = new ArrayList<>();
				
				List<SaeAnioLectivo> lListaAnios = lServicioMantenimientoAnio.listaObjetosActivos(SaeAnioLectivo.class);
				if (lListaAnios.isEmpty()) {
					lListaDocentes = new ArrayList<>();
					lListaEstudiantesMatriculados = new ArrayList<>();
				} else {
					lAnioLectivoSeleccionado = lListaAnios.get(0);
					String lQuery = "select * from sae_curso_anio where id_anio = :idAnio and id_curso != 1 and estado = 'A'";
					HashMap<String, Object> lParametros = new HashMap<>();
					lParametros.put("idAnio", lAnioLectivoSeleccionado.getId());
					listaCursoAnio = lServicioCursoAnio.ejecutarQueryNativoObjeto(lQuery, lParametros,
							SaeCursosAnio.class);
					
					listaMateriaCursoAnio = new ArrayList<>();
					lListaDocentes = new ArrayList<>();
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

				entidadRegistrar = new SaeNotasExamen();

			}
		});

		addPostEventoInicializacion(() -> {

		});

	}

	public void consultaMateriasCursoanio(AjaxBehaviorEvent lEvento) {
		
	}
	
	public void consulta(AjaxBehaviorEvent lEvento) {
		System.out.println("Anio " + lAnioLectivoSeleccionado.getId());

		

	}
	
	public void cargarMaterias (AjaxBehaviorEvent lEvento) {
		
		String lQuery = "select * from sae_materia_curso_anio where estado = 'A' " + 
				"and  id_curso_anio = :idCursoAnio";
		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idCursoAnio", lCursoAnioSeleccionado.getId());
		
		listaMateriaCursoAnio = lServicioMateriaCursoAnio.ejecutarQueryNativoObjeto(lQuery, lParametros, SaeMateriaCursoAnio.class);
		lListaDocentes = new ArrayList<>();
		OmsgPersona lPersona = new OmsgPersona();
		lPersona.setNombres("");
		lPersona.setApellidos("");
		lDocenteSeleccionado.setPersona(lPersona);
	}
	
	public void cargarDocentes (AjaxBehaviorEvent lEvento) {
		SaeMateriaCursoAnio lMateriaCursoANio = lServicioMateriaCursoAnio.obtenerObjtoPK(lMateriaCursoAnioSeleccionado.getId(), SaeMateriaCursoAnio.class);
		lDocenteSeleccionado = lMateriaCursoANio.getlDocente();
		String lQueryEstudiante = " select *  " + "				from sae_matricula  "
				+ "				where estado = 'A' " + "				and id_anio_lectivo = :anio "
				+ "             and ID_CURSO_ANIO = :idCursoAnio ";

		HashMap<String, Object> lParametrosEstudiantes = new HashMap<>();
		lParametrosEstudiantes.put("anio", lAnioLectivoSeleccionado.getId());
		lParametrosEstudiantes.put("idCursoAnio", lCursoAnioSeleccionado.getId());

		lListaEstudiantesMatriculados = servicioMantenedorMatricula.ejecutarQueryNativoObjeto(
				lQueryEstudiante, lParametrosEstudiantes, SaeMatricula.class);
		
		lListaNotasEstudiantes = new ArrayList<>();
		for (SaeMatricula matricula : lListaEstudiantesMatriculados) {
			
			SaeNotasExamen lNota = new SaeNotasExamen();
			lNota.setAuditoria(usuarioAutenticado());
			lNota.setlEstudiante(matricula.getlEstudiante());
			lNota.setEstado("A");
			lNota.setFechaRegistro(new Date());
			lNota.setIdReferencia(1L);
			lNota.setlAnioLectivo(lAnioLectivoSeleccionado);
			lNota.setlCursoAnio(lCursoAnioSeleccionado);
			lListaNotasEstudiantes.add(lNota);
			lNota.setlMateriaCursoAnio(lMateriaCursoAnioSeleccionado);
		}
		
		String lQuery = "select * from sae_notas_examen s " + "where s.ID_MATERIA_CURSO_ANIO = :idMateria "
				+ "and s.ID_ESTUDIANTE = :idEstudiante " + "and s.ID_CURSO_ANIO = :idCursoAnio "
				+ "and s.ID_DOCENTE = :idDocente "
				+ "and s.ESTADO = 'A'";

		
		
		for (SaeNotasExamen nota : lListaNotasEstudiantes) {
			HashMap<String, Object> lParametro = new HashMap<>();
			lParametro.put("idMateria", lMateriaCursoAnioSeleccionado.getId());
			lParametro.put("idEstudiante", nota.getlEstudiante().getId());
			lParametro.put("idCursoAnio", lCursoAnioSeleccionado.getId());
			lParametro.put("idDocente", lDocenteSeleccionado.getId());
			
			List<SaeNotasExamen> lNotasDB = servicioMantenedor.ejecutarQueryNativoObjeto(lQuery, lParametro,
					SaeNotasExamen.class);
			if (!lNotasDB.isEmpty()) 
			{
				nota.setId(lNotasDB.get(0).getId()); 
				nota.setlNotaExamen(lNotasDB.get(0).getlNotaExamen());
				
			}
		
				nota.setlDocente(lDocenteSeleccionado);
				
			
		}
		
		
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#
	 * getServicioMantenedor()
	 */
	@Override
	protected ServicioMantenimientoNotasExamen getServicioMantenedor() {
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

	

	public SaeDocente getlDocenteSeleccionado() {
		return lDocenteSeleccionado;
	}

	public void setlDocenteSeleccionado(SaeDocente lDocenteSeleccionado) {
		this.lDocenteSeleccionado = lDocenteSeleccionado;
	}

	public List<SaeNotasExamen> getlListaNotasEstudiantes() {
		return lListaNotasEstudiantes;
	}

	public void setlListaNotasEstudiantes(List<SaeNotasExamen> lListaNotasEstudiantes) {
		this.lListaNotasEstudiantes = lListaNotasEstudiantes;
	}

	public void registrarNota(AjaxBehaviorEvent lEvento) {
		
		SaeNotasExamen lNota = (SaeNotasExamen) lEvento.getComponent().getAttributes().get("NOTA");

		Long idNota = lNota.getId();
		
		entidadRegistrar = lNota;

		try {
			guardarOActualizar();

			lNota = servicioMantenedor.obtenerObjtoPK(idNota, SaeNotasExamen.class);
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<SaeCursosAnio> getListaCursoAnio() {
		return listaCursoAnio;
	}

	public void setListaCursoAnio(List<SaeCursosAnio> listaCursoAnio) {
		this.listaCursoAnio = listaCursoAnio;
	}

	public List<SaeMateriaCursoAnio> getListaMateriaCursoAnio() {
		return listaMateriaCursoAnio;
	}

	public void setListaMateriaCursoAnio(List<SaeMateriaCursoAnio> listaMateriaCursoAnio) {
		this.listaMateriaCursoAnio = listaMateriaCursoAnio;
	}

	public SaeMateriaCursoAnio getlMateriaCursoAnioSeleccionado() {
		return lMateriaCursoAnioSeleccionado;
	}

	public void setlMateriaCursoAnioSeleccionado(SaeMateriaCursoAnio lMateriaCursoAnioSeleccionado) {
		this.lMateriaCursoAnioSeleccionado = lMateriaCursoAnioSeleccionado;
	}
	
	

}
