package edu.sae.modulo.servicio.producto;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.producto.Producto;
import edu.sae.modulo.eao.producto.ProductoEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoProducto 
extends
ServicioMantenedorControlAuditoria<ProductoEAO, Producto, Long>
{

	@EJB
	private ProductoEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ProductoEAO getCrud() {
		return crud;
	}

}
