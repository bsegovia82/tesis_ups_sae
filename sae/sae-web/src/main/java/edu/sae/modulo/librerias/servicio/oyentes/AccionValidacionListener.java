package edu.sae.modulo.librerias.servicio.oyentes;

import java.io.Serializable;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;

@FunctionalInterface
public interface AccionValidacionListener<ENTIDAD extends EntidadBaseAuditable<Id>, Id extends Serializable> {

	public void validacionTransaccional(ENTIDAD entidad) throws ErrorServicioNegocio;

}
