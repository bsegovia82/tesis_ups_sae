package edu.sae.modulo.vista.servlet.servicio;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioServletConsulta.
 */
@FunctionalInterface
public interface ServicioServletConsulta {

	/**
	 * Delegacion servlet consulta.
	 *
	 * @param request the request
	 * @param response the response
	 * @param lConexionBaseDatos the l conexion base datos
	 */
	public void delegacionServletConsulta(HttpServletRequest request, HttpServletResponse response, 
			Connection lConexionBaseDatos);
	
}
