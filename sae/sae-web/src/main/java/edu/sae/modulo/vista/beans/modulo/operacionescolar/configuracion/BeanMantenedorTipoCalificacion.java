package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.sae.modulo.dominio.escolar.SaeTipoCalificacion;
import edu.sae.modulo.eao.escolar.SaeTipoCalificacionEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoTipoCalificacion;

@ManagedBean
@ViewScoped
public class BeanMantenedorTipoCalificacion extends 
BeanMantenedorGenerico<ServicioMantenimientoTipoCalificacion, Long, SaeTipoCalificacion, 
SaeTipoCalificacionEAO> {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenimientoTipoCalificacion servicioMantenedor;


	public BeanMantenedorTipoCalificacion() {
		super(SaeTipoCalificacion.class);
	}

	/**
	 * Cargar opciones roles.
	 *
	 * @param pEntidadSeleccionada the entidad seleccionada
	 */
	
	protected ServicioMantenimientoTipoCalificacion getServicioMantenedor() {
		return servicioMantenedor;
	}

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Tipo Calificación");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Tipo Calificación");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite los Tipos Calificación");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Tipo Calificación");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Tipo Calificación registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización Tipo Calificación");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Tipo Calificación");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	
}
