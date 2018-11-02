package edu.sae.modulo.librerias.vista.beans.oyentes;

import edu.sae.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;

@FunctionalInterface
public interface PreTransaccionListener 
{

	public void accionPreTransaccion() throws ErrorAccionesPreTransaccion;
	
}
