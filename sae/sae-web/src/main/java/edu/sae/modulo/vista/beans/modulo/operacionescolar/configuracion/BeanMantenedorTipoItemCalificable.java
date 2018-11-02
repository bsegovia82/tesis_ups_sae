package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.sae.modulo.dominio.escolar.SaeAnioLectivo;
import edu.sae.modulo.dominio.escolar.SaeCursosAnio;
import edu.sae.modulo.dominio.escolar.SaeTipoItemsCalificables;
import edu.sae.modulo.eao.escolar.SaeTipoItemsCalificablesEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostInicializacionEntidad;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostSeleccionEntidadListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PreTransaccionListener;
import edu.sae.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorCursoAnio;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoAnioLectivo;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoTipoItemCalificables;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorRol.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorTipoItemCalificable extends
		BeanMantenedorGenerico<ServicioMantenimientoTipoItemCalificables, Long, SaeTipoItemsCalificables, SaeTipoItemsCalificablesEAO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenimientoTipoItemCalificables servicioMantenedor;

	@EJB
	private ServicioMantenimientoAnioLectivo lServicioMantenimientoAnio;

	@EJB
	private ServicioMantenedorCursoAnio lServicioCursoAnio;

	private List<SaeCursosAnio> lCursoAnio;
	private SaeAnioLectivo lAnioLectivo;
	private List<SaeTipoItemsCalificables> lListaTipoItems;
	private SaeTipoItemsCalificables lTipoItemPadre;

	public BeanMantenedorTipoItemCalificable() {
		super(SaeTipoItemsCalificables.class);

		addPostConstructuListener(new PostConstructListener() {

			@Override
			public void metodoPostConstruct() {
				List<SaeAnioLectivo> lListaAnios = lServicioMantenimientoAnio.listaObjetosActivos(SaeAnioLectivo.class);
				if (lListaAnios.isEmpty()) {
					lCursoAnio = new ArrayList<>();
				} else {
					lAnioLectivo = lListaAnios.get(0);
					String lQuery = "select * from sae_curso_anio where id_anio = :idAnio and estado = 'A'";
					HashMap<String, Object> lParametros = new HashMap<>();
					lParametros.put("idAnio", lAnioLectivo.getId());
					lCursoAnio = lServicioCursoAnio.ejecutarQueryNativoObjeto(lQuery, lParametros, SaeCursosAnio.class);
				}
				lTipoItemPadre = new SaeTipoItemsCalificables();
				entidadRegistrar.setlAnioLectivo(lAnioLectivo);
				entidadRegistrar.setlCursoAnio(new SaeCursosAnio());
				lListaTipoItems = servicioMantenedor.listaObjetosActivos(SaeTipoItemsCalificables.class);
			}
		});

		addPostEventoInicializacion(new PostInicializacionEntidad() {

			@Override
			public void eventoPostInicializacion() {
				entidadRegistrar = new SaeTipoItemsCalificables();
				entidadRegistrar.setlAnioLectivo(lAnioLectivo);
				entidadRegistrar.setlCursoAnio(new SaeCursosAnio());
				lListaTipoItems = servicioMantenedor.listaObjetosActivos(SaeTipoItemsCalificables.class);
				lTipoItemPadre = new SaeTipoItemsCalificables();
			}
		});
		
		addPreTransaccionServicioListener(new PreTransaccionListener() {
			
			@Override
			public void accionPreTransaccion() throws ErrorAccionesPreTransaccion {
				
				if (lTipoItemPadre.getId()==-1)
				{
					entidadRegistrar.setlItemPadre(null);
				}
				else
				{
					entidadRegistrar.setlItemPadre(lTipoItemPadre);
				}
				
			}
		});

		addPostTransaccion(new PostTransaccionListener() {

			@Override
			public void metodoPostTransaccion() {
				entidadRegistrar = new SaeTipoItemsCalificables();
				entidadRegistrar.setlAnioLectivo(lAnioLectivo);
				entidadRegistrar.setlCursoAnio(new SaeCursosAnio());
				lListaTipoItems = servicioMantenedor.listaObjetosActivos(SaeTipoItemsCalificables.class);
				lTipoItemPadre = new SaeTipoItemsCalificables();
			}
		});
		
		addPostSeleccionRegistroListener(new PostSeleccionEntidadListener<SaeTipoItemsCalificables, Long>() {
			
			@Override
			public void postSeleccionRegistro(SaeTipoItemsCalificables pEntidadSeleccionada) {
				lTipoItemPadre = entidadRegistrar.getlItemPadre();
				
			}
		});
	}

	/**
	 * Cargar opciones roles.
	 *
	 * @param pEntidadSeleccionada
	 *            the entidad seleccionada
	 */

	protected ServicioMantenimientoTipoItemCalificables getServicioMantenedor() {
		return servicioMantenedor;
	}

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Item Calificables");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Item Calificables");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite los Item Calificables");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Item Calificables");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Item Calificables registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización Item Calificables");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Item Calificables");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	public List<SaeCursosAnio> getlCursoAnio() {
		return lCursoAnio;
	}

	public void setlCursoAnio(List<SaeCursosAnio> lCursoAnio) {
		this.lCursoAnio = lCursoAnio;
	}

	public SaeAnioLectivo getlAnioLectivo() {
		return lAnioLectivo;
	}

	public void setlAnioLectivo(SaeAnioLectivo lAnioLectivo) {
		this.lAnioLectivo = lAnioLectivo;
	}

	public List<SaeTipoItemsCalificables> getlListaTipoItems() {
		return lListaTipoItems;
	}

	public void setlListaTipoItems(List<SaeTipoItemsCalificables> lListaTipoItems) {
		this.lListaTipoItems = lListaTipoItems;
	}

	public SaeTipoItemsCalificables getlTipoItemPadre() {
		return lTipoItemPadre;
	}

	public void setlTipoItemPadre(SaeTipoItemsCalificables lTipoItemPadre) {
		this.lTipoItemPadre = lTipoItemPadre;
	}
	
	

}
