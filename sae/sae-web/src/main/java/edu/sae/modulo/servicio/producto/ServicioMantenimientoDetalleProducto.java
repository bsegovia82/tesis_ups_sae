package edu.sae.modulo.servicio.producto;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.producto.DetalleProducto;
import edu.sae.modulo.eao.producto.DetalleProductoEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoDetalleProducto 
extends
ServicioMantenedorControlAuditoria<DetalleProductoEAO, DetalleProducto, Long>
{

	@EJB
	private DetalleProductoEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected DetalleProductoEAO getCrud() {
		return crud;
	}

	public void eliminarDetalleProducto(DetalleProducto producto) {
		
		crud.getAdminEntidad().createNativeQuery("delete from ONIX_DETALLE_PRODUCTO where id = :idDet").setParameter("idDet", producto.getId()).executeUpdate();
		
	}

}
