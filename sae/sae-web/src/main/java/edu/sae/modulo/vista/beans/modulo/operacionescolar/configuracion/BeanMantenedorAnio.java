package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import edu.sae.modulo.dominio.escolar.SaeAnioLectivo;
import edu.sae.modulo.dominio.escolar.SaeCurso;
import edu.sae.modulo.dominio.escolar.SaeCursosAnio;
import edu.sae.modulo.dominio.escolar.SaeDocente;
import edu.sae.modulo.dominio.escolar.SaeMateria;
import edu.sae.modulo.dominio.escolar.SaeMateriaCursoAnio;
import edu.sae.modulo.dominio.escolar.SaeTipoCalificacion;
import edu.sae.modulo.eao.escolar.SaeAnioLectivoEAO;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.exceptions.ErrorValidacionGeneral;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostSeleccionEntidadListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PreTransaccionListener;
import edu.sae.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorCursoAnio;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorDocente;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoAnioLectivo;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoMateria;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoMateriaCursoAnio;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoTipoCalificacion;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorRol.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorAnio
		extends BeanMantenedorGenerico<ServicioMantenimientoAnioLectivo, Long, SaeAnioLectivo, SaeAnioLectivoEAO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenimientoAnioLectivo servicioMantenedor;

	private DualListModel<SaeCurso> listaSeleccionCurso;

	private List<SaeCursosAnio> lListaCursoAnio;
	private List<SaeMateria> lListaMateria;
	private List<SaeDocente> lListaDocente;
	private List<SaeTipoCalificacion> lListaCalificacion;
	
	private SaeAnioLectivo anioLectivoSeleccionado;

	@EJB
	private ServicioMantenedorCursoAnio lServicioCursoAnio;

	@EJB
	private ServicioMantenimientoMateria lServicioMateria;

	@EJB
	private ServicioMantenedorDocente lServicioDocente;

	@EJB
	private ServicioMantenimientoTipoCalificacion lServicioTipoCalificacion;

	@EJB
	private ServicioMantenimientoMateriaCursoAnio lServicioMantenimientoMateriaAnioCurso;

	private List<SaeMateriaCursoAnio> lListaMateriaCursoAnio;

	private SaeMateriaCursoAnio lMateriaCursoAnio;

	public BeanMantenedorAnio() {
		super(SaeAnioLectivo.class);
		listaSeleccionCurso = new DualListModel<>();
		lMateriaCursoAnio = new SaeMateriaCursoAnio();
		lListaMateriaCursoAnio = new ArrayList<>();
		addPostConstructuListener(new PostConstructListener() {

			@Override
			public void metodoPostConstruct() {
				lMateriaCursoAnio = new SaeMateriaCursoAnio();
				lMateriaCursoAnio.setlCursoAnio(new SaeCursosAnio());
				lMateriaCursoAnio.setlMateria(new SaeMateria());
				lMateriaCursoAnio.setlDocente(new SaeDocente());
				lMateriaCursoAnio.setlTipoCalificacion(new SaeTipoCalificacion());

				lListaCursoAnio = lServicioCursoAnio.listaObjetosActivos(SaeCursosAnio.class);
				lListaMateria = lServicioMateria.listaObjetosActivos(SaeMateria.class);
				lListaDocente = lServicioDocente.listaObjetosActivos(SaeDocente.class);
				lListaCalificacion = lServicioTipoCalificacion.listaObjetosActivos(SaeTipoCalificacion.class);
				lListaMateriaCursoAnio = lServicioMantenimientoMateriaAnioCurso.listaObjetos(SaeMateriaCursoAnio.class);
			}
		});

		addPostSeleccionRegistroListener(new PostSeleccionEntidadListener<SaeAnioLectivo, Long>() {

			@Override
			public void postSeleccionRegistro(SaeAnioLectivo pEntidadSeleccionada) {
				anioLectivoSeleccionado = pEntidadSeleccionada;
				listaSeleccionCurso = null;
				cargarCursos(pEntidadSeleccionada);
				lMateriaCursoAnio = new SaeMateriaCursoAnio();
				lMateriaCursoAnio.setlCursoAnio(new SaeCursosAnio());
				lMateriaCursoAnio.setlMateria(new SaeMateria());
				lMateriaCursoAnio.setlDocente(new SaeDocente());
				lMateriaCursoAnio.setlTipoCalificacion(new SaeTipoCalificacion());
				String lQuery = "select * from sae_materia_curso_anio where " + "id_curso_anio in ( "
						+ "select id from sae_curso_anio where id_anio = :anioLectivo " + "and estado = 'A' " + ") "
						+ "and estado = 'A'";
				HashMap<String, Object> lParametros = new HashMap<>();
				lParametros.put("anioLectivo", pEntidadSeleccionada.getId());

				lListaMateriaCursoAnio = lServicioMantenimientoMateriaAnioCurso.ejecutarQueryNativoObjeto(lQuery,
						lParametros, SaeMateriaCursoAnio.class);

				String lQueryCursos = "select * from sae_curso_anio where id_anio = :anioLectivo and estado = 'A'";
				HashMap<String, Object> lParametrosCursos = new HashMap<>();
				lParametrosCursos.put("anioLectivo", pEntidadSeleccionada.getId());
				lListaCursoAnio = lServicioCursoAnio.ejecutarQueryNativoObjeto(lQueryCursos, lParametrosCursos,
						SaeCursosAnio.class);
			}
		});

		addPreTransaccionServicioListener(new PreTransaccionListener() {

			@Override
			public void accionPreTransaccion() throws ErrorAccionesPreTransaccion {
				servicioMantenedor.inaactivarAniosLectivos();

			}
		});

	}

	/**
	 * Cargar opciones roles.
	 *
	 * @param pEntidadSeleccionada
	 *            the entidad seleccionada
	 */

	protected ServicioMantenimientoAnioLectivo getServicioMantenedor() {
		return servicioMantenedor;
	}

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Año Lectivo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Año Lectivo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite los Año Lectivo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Año Lectivo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Año Lectivo registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización Año Lectivo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Año Lectivo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	public DualListModel<SaeCurso> getListaSeleccionCurso() {
		return listaSeleccionCurso;
	}

	public void setListaSeleccionCurso(DualListModel<SaeCurso> listaSeleccionCurso) {
		this.listaSeleccionCurso = listaSeleccionCurso;
	}

	private void cargarCursos(SaeAnioLectivo pEntidadSeleccionada) {
		List<SaeCurso> listaOpcionesAsignadas = servicioMantenedor
				.obtenerCursosAsignadosAnio(pEntidadSeleccionada.getId());
		List<SaeCurso> listaOpcionesPorAsignar = servicioMantenedor.obtenerCursosPorAsignarAnio(usuarioAutenticado(),
				pEntidadSeleccionada.getId(), obtenerObjetoSesion(JsfUtil.REFERENCIA_SESION));
		listaSeleccionCurso = new DualListModel<>(listaOpcionesPorAsignar, listaOpcionesAsignadas);
	}

	public void controlTransferencia(TransferEvent pEvento) {

		Long referencia = obtenerObjetoSesion(JsfUtil.REFERENCIA_SESION);
		List<String> lOpcionesTransferidas = (List<String>) pEvento.getItems();
		try {
			if (pEvento.isAdd())

				servicioMantenedor.asigarCurso(lOpcionesTransferidas, usuarioAutenticado(), entidadRegistrar.getId(),
						referencia);

			else {
				if (pEvento.isRemove())
					servicioMantenedor.inactivarCurso(lOpcionesTransferidas, usuarioAutenticado(),
							entidadRegistrar.getId());
			}
			cargarCursos(this.entidadRegistrar);
		} catch (ErrorServicioNegocio e) {
			e.printStackTrace();
			addError(e.getMessage());

		} catch (ErrorValidacionGeneral e) {
			e.printStackTrace();
			addError(e.getMessage());
		}
	}

	public List<SaeCursosAnio> getlListaCursoAnio() {
		return lListaCursoAnio;
	}

	public void setlListaCursoAnio(List<SaeCursosAnio> lListaCursoAnio) {
		this.lListaCursoAnio = lListaCursoAnio;
	}

	public List<SaeMateria> getlListaMateria() {
		return lListaMateria;
	}

	public void setlListaMateria(List<SaeMateria> lListaMateria) {
		this.lListaMateria = lListaMateria;
	}

	public List<SaeDocente> getlListaDocente() {
		return lListaDocente;
	}

	public void setlListaDocente(List<SaeDocente> lListaDocente) {
		this.lListaDocente = lListaDocente;
	}

	public List<SaeTipoCalificacion> getlListaCalificacion() {
		return lListaCalificacion;
	}

	public void setlListaCalificacion(List<SaeTipoCalificacion> lListaCalificacion) {
		this.lListaCalificacion = lListaCalificacion;
	}

	public SaeMateriaCursoAnio getlMateriaCursoAnio() {
		return lMateriaCursoAnio;
	}

	public void setlMateriaCursoAnio(SaeMateriaCursoAnio lMateriaCursoAnio) {
		this.lMateriaCursoAnio = lMateriaCursoAnio;
	}

	public void guardarOActualizarMateria() {
		try {
			
			
			lMateriaCursoAnio.setEstado("A");
			lMateriaCursoAnio.setFechaRegistro(new Date());
			lMateriaCursoAnio.setObservacion("Registro desde la web");
			lMateriaCursoAnio.setAuditoria(usuarioAutenticado());
			lMateriaCursoAnio.setIdReferencia(1L);

			lServicioMantenimientoMateriaAnioCurso.guardarActualizar(lMateriaCursoAnio);

			String lQuery = "select * from sae_materia_curso_anio where " + "id_curso_anio in ( "
					+ "select id from sae_curso_anio where id_anio = :anioLectivo " + "and estado = 'A' " + ") "
					+ "and estado = 'A'";
			HashMap<String, Object> lParametros = new HashMap<>();
			lParametros.put("anioLectivo", anioLectivoSeleccionado.getId());

			lListaMateriaCursoAnio = lServicioMantenimientoMateriaAnioCurso.ejecutarQueryNativoObjeto(lQuery,
					lParametros, SaeMateriaCursoAnio.class);

			lMateriaCursoAnio = new SaeMateriaCursoAnio();
			lMateriaCursoAnio.setlCursoAnio(new SaeCursosAnio());
			lMateriaCursoAnio.setlMateria(new SaeMateria());
			lMateriaCursoAnio.setlDocente(new SaeDocente());
			lMateriaCursoAnio.setlTipoCalificacion(new SaeTipoCalificacion());

		} catch (Throwable e) {
			e.printStackTrace();
			addError("Error al registrar la materia");
		}

	}

	public List<SaeMateriaCursoAnio> getlListaMateriaCursoAnio() {
		return lListaMateriaCursoAnio;
	}

	public void setlListaMateriaCursoAnio(List<SaeMateriaCursoAnio> lListaMateriaCursoAnio) {
		this.lListaMateriaCursoAnio = lListaMateriaCursoAnio;
	}

	public void cambiarEstadoMateriaAnio(ActionEvent lEvento) {
		SaeMateriaCursoAnio lMateriaCursoAnio = (SaeMateriaCursoAnio) lEvento.getComponent().getAttributes()
				.get("MATERIA_CURSO");
		lMateriaCursoAnio.setEstado(lMateriaCursoAnio.getEstado().equals("A") ? "I" : "A");

		try {
			lServicioMantenimientoMateriaAnioCurso.guardarActualizar(lMateriaCursoAnio);
			lListaMateriaCursoAnio = lServicioMantenimientoMateriaAnioCurso.listaObjetos(SaeMateriaCursoAnio.class);
		} catch (Throwable e) {
			e.printStackTrace();
			addError("Error al inactivar la materia");
		}
	}

}
