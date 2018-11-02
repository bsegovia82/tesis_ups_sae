package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import edu.sae.modulo.dominio.escolar.SaeAnioLectivo;
import edu.sae.modulo.dominio.escolar.SaeCursosAnio;
import edu.sae.modulo.dominio.escolar.SaeEstudiante;
import edu.sae.modulo.dominio.escolar.SaeMatricula;
import edu.sae.modulo.eao.escolar.SaeMatriculaEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.ControlListaEntidadesPersonalizada;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorCursoAnio;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorEstudiante;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoAnioLectivo;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoMatricula;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorMatricula.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorMatricula
		extends BeanMantenedorGenerico<ServicioMantenimientoMatricula, Long, SaeMatricula, SaeMatriculaEAO> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenimientoMatricula servicioMantenedor;
	
	private List<SaeAnioLectivo> lListaAnioActivos;
	
	private List<SaeEstudiante> lListaEstudiantesSinMatricula;
	
	private List<SaeMatricula> lListaEstudiantesMatriculados;
	
	private List<SaeCursosAnio> lListaCursoAnio;

	@EJB
	private ServicioMantenimientoAnioLectivo lServicioMantenimiento;
	
	private SaeAnioLectivo lAnioLectivoSeleccionado;
	
	@EJB
	private ServicioMantenedorEstudiante lServicioEstudiante;
	
	@EJB
	private ServicioMantenedorCursoAnio lServicioCursoAnio;
	
	
	public BeanMantenedorMatricula() {
		super(SaeMatricula.class);
		lListaAnioActivos = new ArrayList<>();
		
		addPostConstructuListener(new PostConstructListener() {
			@Override
			public void metodoPostConstruct() {
				lListaAnioActivos = lServicioMantenimiento.listaObjetosActivos(SaeAnioLectivo.class);
				lAnioLectivoSeleccionado = new SaeAnioLectivo();
				
				lListaCursoAnio =  new ArrayList<>();
				entidadRegistrar.setlCursoAnio(new SaeCursosAnio());
				
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
			
				lListaEstudiantesMatriculados  = lServicioEstudiante.obtenerEstudiantesMatriculados(lAnioLectivoSeleccionado);
				lListaEstudiantesSinMatricula = lServicioEstudiante.obtenerEstudiantesSinMatricula(lAnioLectivoSeleccionado);
				entidadRegistrar = new SaeMatricula();
				entidadRegistrar.setlCursoAnio(new SaeCursosAnio());

			}
		});
		
		addPostEventoInicializacion(() -> 
		{
			
		});

	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#getServicioMantenedor()
	 */
	@Override
	protected ServicioMantenimientoMatricula getServicioMantenedor() {
		return servicioMantenedor;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#cargarListaEtiquetas()
	 */
	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Estudiantes pendientes por matricular");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Matriculas registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Matricula");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Matriculas registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	public List<SaeAnioLectivo> getlListaAnioActivos() {
		return lListaAnioActivos;
	}

	public void setlListaAnioActivos(List<SaeAnioLectivo> lListaAnioActivos) {
		this.lListaAnioActivos = lListaAnioActivos;
	}

	public SaeAnioLectivo getlAnioLectivoSeleccionado() {
		return lAnioLectivoSeleccionado;
	}

	public void setlAnioLectivoSeleccionado(SaeAnioLectivo lAnioLectivoSeleccionado) {
		this.lAnioLectivoSeleccionado = lAnioLectivoSeleccionado;
	}

	public void consulta(AjaxBehaviorEvent lEvento)
	{
		System.out.println("Anio " + lAnioLectivoSeleccionado.getId());
		
		lListaEstudiantesMatriculados  = lServicioEstudiante.obtenerEstudiantesMatriculados(lAnioLectivoSeleccionado);
		lListaEstudiantesSinMatricula = lServicioEstudiante.obtenerEstudiantesSinMatricula(lAnioLectivoSeleccionado);
		
		
		
	}

	public List<SaeEstudiante> getlListaEstudiantesSinMatricula() {
		return lListaEstudiantesSinMatricula;
	}

	public void setlListaEstudiantesSinMatricula(List<SaeEstudiante> lListaEstudiantesSinMatricula) {
		this.lListaEstudiantesSinMatricula = lListaEstudiantesSinMatricula;
	}

	public List<SaeMatricula> getlListaEstudiantesMatriculados() {
		return lListaEstudiantesMatriculados;
	}

	public void setlListaEstudiantesMatriculados(List<SaeMatricula> lListaEstudiantesMatriculados) {
		this.lListaEstudiantesMatriculados = lListaEstudiantesMatriculados;
	}

	public List<SaeCursosAnio> getlListaCursoAnio() {
		return lListaCursoAnio;
	}

	public void setlListaCursoAnio(List<SaeCursosAnio> lListaCursoAnio) {
		this.lListaCursoAnio = lListaCursoAnio;
	}
	
	public void cambiarEliminarMatricula(ActionEvent lEvento)
	{
		SaeMatricula lEstudiante = (SaeMatricula)lEvento.getComponent().getAttributes().get("ESTUDIANTE");
		
		servicioMantenedor.eliminarMatricula(lEstudiante.getlEstudiante(), lAnioLectivoSeleccionado);
		
		lListaEstudiantesMatriculados  = lServicioEstudiante.obtenerEstudiantesMatriculados(lAnioLectivoSeleccionado);
		lListaEstudiantesSinMatricula = lServicioEstudiante.obtenerEstudiantesSinMatricula(lAnioLectivoSeleccionado);
	}
	
	public void matricular(ActionEvent lEvento)
	{
		SaeEstudiante lEstudiante = (SaeEstudiante)lEvento.getComponent().getAttributes().get("ESTUDIANTE");
		this.entidadRegistrar.setlEstudiante(lEstudiante);
		this.entidadRegistrar.setlAnioLectivo(lAnioLectivoSeleccionado);
		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("anio", lAnioLectivoSeleccionado.getId());
		lListaCursoAnio = lServicioCursoAnio.ejecutarQueryNativoObjeto("select * from SAE_CURSO_ANIO where ID_ANIO = :anio and estado = 'A'", lParametros, SaeCursosAnio.class);
		this.entidadRegistrar.setEstado("A");
		this.entidadRegistrar.setFechaRegistro(new Date());
		this.entidadRegistrar.setAuditoria(usuarioAutenticado());
		
	}
	
	
}
