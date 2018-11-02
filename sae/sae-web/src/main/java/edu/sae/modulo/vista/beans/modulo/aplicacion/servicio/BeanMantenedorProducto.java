package edu.sae.modulo.vista.beans.modulo.aplicacion.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.sae.modulo.dominio.producto.DetalleProducto;
import edu.sae.modulo.dominio.producto.Producto;
import edu.sae.modulo.dominio.producto.TiposDetalles;
import edu.sae.modulo.eao.producto.ProductoEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.servicio.producto.ServicioMantenimientoDetalleProducto;
import edu.sae.modulo.servicio.producto.ServicioMantenimientoProducto;
import edu.sae.modulo.servicio.producto.ServicioMantenimientoTipoDetalleProducto;

@ManagedBean
@ViewScoped
public class BeanMantenedorProducto
		extends BeanMantenedorGenerico<ServicioMantenimientoProducto, Long, Producto, ProductoEAO> {
	@EJB
	private ServicioMantenimientoProducto servicioMantenedor;

	@EJB
	private ServicioMantenimientoTipoDetalleProducto servicioTipoDetalle;

	@EJB
	private ServicioMantenimientoDetalleProducto lServicioDetalle;

	private List<TiposDetalles> lTiposDetallesProd;

	private DetalleProducto lDetalleproductoActual;

	private String[] diasSeleccionadas;

	private List<String> diasASeleccionar;

	private List<DetalleProducto> lListaDetallesProducto;

	public BeanMantenedorProducto() {
		super(Producto.class);

		addPostConstructuListener(new PostConstructListener() {

			@Override
			public void metodoPostConstruct() {
				lDetalleproductoActual = new DetalleProducto();
				lDetalleproductoActual.setlTipoDetalle(new TiposDetalles());
				lTiposDetallesProd = servicioTipoDetalle.listaObjetosActivos(TiposDetalles.class);
				diasASeleccionar = new ArrayList<>();
				diasASeleccionar.add("LUNES");
				diasASeleccionar.add("MARTES");
				diasASeleccionar.add("MIERCOLES");
				diasASeleccionar.add("JUEVES");
				diasASeleccionar.add("VIERNES");
				diasASeleccionar.add("SABADO");
				diasASeleccionar.add("DOMINGO");
				lListaDetallesProducto = new ArrayList<>();
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ServicioMantenimientoProducto getServicioMantenedor() {
		// TODO Auto-generated method stub
		return servicioMantenedor;
	}

	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Servicios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Servicios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Servicios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Productos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Lista de Servicios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Servicios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Servicios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	public DetalleProducto getlDetalleproductoActual() {
		return lDetalleproductoActual;
	}

	public void setlDetalleproductoActual(DetalleProducto lDetalleproductoActual) {
		this.lDetalleproductoActual = lDetalleproductoActual;
	}

	public List<TiposDetalles> getlTiposDetallesProd() {
		return lTiposDetallesProd;
	}

	public void setlTiposDetallesProd(List<TiposDetalles> lTiposDetallesProd) {
		this.lTiposDetallesProd = lTiposDetallesProd;
	}

	public String[] getDiasSeleccionadas() {
		return diasSeleccionadas;
	}

	public void setDiasSeleccionadas(String[] diasSeleccionadas) {
		this.diasSeleccionadas = diasSeleccionadas;
	}

	public List<String> getDiasASeleccionar() {
		return diasASeleccionar;
	}

	public void setDiasASeleccionar(List<String> diasASeleccionar) {
		this.diasASeleccionar = diasASeleccionar;
	}

	public List<DetalleProducto> getlListaDetallesProducto() {
		return lListaDetallesProducto;
	}

	public void setlListaDetallesProducto(List<DetalleProducto> lListaDetallesProducto) {
		this.lListaDetallesProducto = lListaDetallesProducto;
	}

	public void cargarDetallesProductos(ActionEvent lEvento) {
		Producto producto = (Producto) lEvento.getComponent().getAttributes().get("PRODUCTO");

		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idProd", producto.getId());

		lDetalleproductoActual.setlProducto(producto);

		lListaDetallesProducto = lServicioDetalle.ejecutarQueryNativoObjeto(
				"select * from onix_detalle_producto where id_producto = :idProd", lParametros, DetalleProducto.class);
	}
	
	public void eliminarDetallesProductos(ActionEvent lEvento) {
		DetalleProducto producto = (DetalleProducto) lEvento.getComponent().getAttributes().get("DET_PRODUCTO");
		
		Long lId = producto.getlProducto().getId();
		
		lServicioDetalle.eliminarDetalleProducto(producto);
		
		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idProd", producto.getId());
		
		lListaDetallesProducto = lServicioDetalle.ejecutarQueryNativoObjeto(
				"select * from onix_detalle_producto where id_producto = :idProd", lParametros, DetalleProducto.class);
	}

	public void registrarDetalle() {
		try {
			Long lid = lDetalleproductoActual.getlProducto().getId();
			lDetalleproductoActual.setEstado("A");
			lDetalleproductoActual.setFechaRegistro(new Date());
			lDetalleproductoActual.setAuditoria(usuarioAutenticado());

			for (String lDia : diasSeleccionadas) {
				switch (lDia) {
				case "LUNES":
					lDetalleproductoActual.setlLunes("LUNES");
					break;
				case "MARTES":
					lDetalleproductoActual.setlMartes("MARTES");
					break;

				case "MIERCOLES":
					lDetalleproductoActual.setlMiercoles("MIERCOLES");
					break;

				case "JUEVES":
					lDetalleproductoActual.setlJuves("JUEVES");
					break;
				case "VIERNES":
					lDetalleproductoActual.setlViernes("VIERNES");
					break;
				case "SABADO":
					lDetalleproductoActual.setlSabado("SABADO");
					break;
				case "DOMINGO":
					lDetalleproductoActual.setlDomingo("DOMINGO");
					break;

				}
			}

			lServicioDetalle.guardarActualizar(lDetalleproductoActual);

			diasSeleccionadas = null;

			HashMap<String, Object> lParametros = new HashMap<>();
			lParametros.put("idProd", lid);
			lListaDetallesProducto = lServicioDetalle.ejecutarQueryNativoObjeto(
					"select * from onix_detalle_producto where id_producto = :idProd", lParametros,
					DetalleProducto.class);
			lDetalleproductoActual = new DetalleProducto();
			lDetalleproductoActual.setlTipoDetalle(new TiposDetalles());
			lDetalleproductoActual .setlProducto(servicioMantenedor.obtenerObjtoPK(lid, Producto.class));
		} catch (Exception e) {
			e.printStackTrace();
			addMensajeAdvertencia("Imposible realizar el insert del detalle");
		}
	}

}
