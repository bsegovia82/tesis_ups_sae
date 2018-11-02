package edu.sae.modulo.librerias.seguridad.loginmodule.servicios;

import java.util.List;

import edu.sae.modulo.librerias.generales.excepciones.ExcepcionLogin;

public interface IServiciosLoginModule 
{
	String getClaveUsuario(String pUsuario);
	List<String> getNombreRoles(String pUsuario);
	boolean validarUsuarioPassword(String pUsuario,String pPassword) throws ExcepcionLogin;
	
}   
   