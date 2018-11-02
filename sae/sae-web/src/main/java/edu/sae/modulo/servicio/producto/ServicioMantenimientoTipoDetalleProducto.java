package edu.sae.modulo.servicio.producto;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.producto.TiposDetalles;
import edu.sae.modulo.eao.producto.TipoDetalleEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoTipoDetalleProducto 
extends
ServicioMantenedorControlAuditoria<TipoDetalleEAO, TiposDetalles, Long>
{

	@EJB
	private TipoDetalleEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected TipoDetalleEAO getCrud() {
		return crud;
	}

}
