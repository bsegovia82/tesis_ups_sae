package edu.sae.modulo.librerias.vista.beans.oyentes;

import edu.sae.modulo.librerias.vista.exceptions.ErrorValidacionVisual;

@FunctionalInterface
public interface ValidadorIngresoDatosListener 
{
	public void validarDatosIngreso() throws ErrorValidacionVisual;
	//
}
