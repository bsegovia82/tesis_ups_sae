package edu.sae.modulo.vista.beans.modulo.aplicacion.servicio;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.sae.modulo.dominio.producto.TiposDetalles;
import edu.sae.modulo.eao.producto.TipoDetalleEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.servicio.producto.ServicioMantenimientoTipoDetalleProducto;

@ManagedBean
@ViewScoped
public class BeanMantenedorTipoDetalle 
extends BeanMantenedorGenerico<ServicioMantenimientoTipoDetalleProducto, Long, TiposDetalles, TipoDetalleEAO>
{
	 @EJB
	 private ServicioMantenimientoTipoDetalleProducto servicioMantenedor;

	public BeanMantenedorTipoDetalle() {
		super(TiposDetalles.class);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	protected ServicioMantenimientoTipoDetalleProducto getServicioMantenedor() {
		// TODO Auto-generated method stub
		return servicioMantenedor;
	}
	
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Tipo Detalle");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Tipo Detalle");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Tipo Detalle");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Tipo Detalle");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Lista de Tipo Detalle");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Tipo Detalle");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Tipo Detalle");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

}
