package edu.sae.modulo.librerias.servicio.oyentes;

import java.io.Serializable;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@FunctionalInterface
public interface PreLlenadoRegistroListener <ENTIDAD extends EntidadBaseAuditable<Id>, Id extends Serializable>{

	public void preCargaDatosRegistro(ENTIDAD entidad);
	
}
