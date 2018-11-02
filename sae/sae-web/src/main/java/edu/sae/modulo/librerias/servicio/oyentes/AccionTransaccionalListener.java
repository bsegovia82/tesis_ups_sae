package edu.sae.modulo.librerias.servicio.oyentes;

import java.io.Serializable;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.exceptions.ErrorValidacionGeneral;

@FunctionalInterface
public interface AccionTransaccionalListener<ENTIDAD extends EntidadBaseAuditable<Id>, Id extends Serializable> {

	public void controlTransaccional(ENTIDAD entidad) throws ErrorServicioNegocio, ErrorValidacionGeneral;
}
