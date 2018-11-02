package edu.sae.modulo.vista.beans.modulo.aplicacion.configuracion;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.sae.modulo.dominio.aplicacion.OmgIcono;
import edu.sae.modulo.eao.aplicacion.OmgIconoEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorIcono;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorIcono.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorIcono 
extends BeanMantenedorGenerico<ServicioMantenedorIcono, Long, OmgIcono, OmgIconoEAO>
{

	/**
	 * Instantiates a new bean mantenedor icono.
	 */
	public BeanMantenedorIcono() {
		super( OmgIcono.class);
		addPostTransaccion(new PostTransaccionListener() {
			@Override
			public void metodoPostTransaccion() {
				
			}
		});
	}

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The l servicio. */
	@EJB
	private ServicioMantenedorIcono lServicio;
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#cargarListaEtiquetas()
	 */
	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Íconos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Íconos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Íconos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Íconos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Íconos registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Íconos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Íconos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Íconos registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#getServicioMantenedor()
	 */
	@Override
	protected ServicioMantenedorIcono getServicioMantenedor() {
		return lServicio;
	}

}
