package edu.sae.modulo.librerias.vista.beans.oyentes;

import java.io.Serializable;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@FunctionalInterface
public interface PostSeleccionEntidadListener<ENTIDAD extends EntidadBaseAuditable<Id>, Id extends Serializable>
{

	public void postSeleccionRegistro(ENTIDAD pEntidadSeleccionada);
	
}
