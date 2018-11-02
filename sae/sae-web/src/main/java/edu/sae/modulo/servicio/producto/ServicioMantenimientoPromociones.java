package edu.sae.modulo.servicio.producto;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.producto.Promociones;
import edu.sae.modulo.eao.producto.PromocionesEAO;
import edu.sae.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenimientoPromociones 
extends
ServicioMantenedorControlAuditoria<PromocionesEAO, Promociones, Long>
{

	@EJB
	private PromocionesEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		
		
	}

	@Override
	protected PromocionesEAO getCrud() {
		return crud;
	}
	
}
