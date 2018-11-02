package edu.sae.modulo.vista.beans.modulo.aplicacion.servicio;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import edu.sae.modulo.dominio.producto.Promociones;
import edu.sae.modulo.eao.producto.PromocionesEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PreTransaccionListener;
import edu.sae.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
import edu.sae.modulo.servicio.producto.ServicioMantenimientoPromociones;

@ManagedBean
@ViewScoped
public class BeanMantenedorPromocion 
extends BeanMantenedorGenerico<ServicioMantenimientoPromociones, Long, Promociones, PromocionesEAO>
{
	 @EJB
	 private ServicioMantenimientoPromociones servicioMantenedor;

	public BeanMantenedorPromocion() {
		super(Promociones.class);
		
		addPreTransaccionServicioListener(new PreTransaccionListener() {

			@Override
			public void accionPreTransaccion() throws ErrorAccionesPreTransaccion {
				if (avatar != null) 
					entidadRegistrar.setImagenReferencia(avatar);
				else 
					System.out.println("No registra avatar");
			}
		});
			
	}

	private byte[] avatar;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	protected ServicioMantenimientoPromociones getServicioMantenedor() {
		// TODO Auto-generated method stub
		return servicioMantenedor;
	}
	
	public void subir(FileUploadEvent event) {
		avatar = event.getFile().getContents();
	}
	
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Promoción");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Promoción");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Promoción");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Promoción");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Lista de Promoción");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Promoción");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Promoción");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	
	

}
