package edu.sae.modulo.servicio.seguridad;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.aplicacion.OmsOpcione;
import edu.sae.modulo.dominio.aplicacion.OmsRole;
import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.eao.aplicacion.OmsOpcioneEAO;
import edu.sae.modulo.eao.aplicacion.OmsOpcionesRoleEAO;
import edu.sae.modulo.eao.aplicacion.OmsUsuarioEAO;




// TODO: Auto-generated Javadoc
/**
 * The Class ServicioAplicacion.
 */
@Stateless
public class ServicioAplicacion
{

	/** The opciones roles EAO. */
	@EJB
	private OmsOpcionesRoleEAO opcionesRolesEAO;
	
	/** The opciones EAO. */
	@EJB
	private OmsOpcioneEAO opcionesEAO;
	

	
	
	
	/** The usuario EAO. */
	@EJB
	private OmsUsuarioEAO usuarioEAO;
	
	
	
	/**
	 * Obtener menu.
	 *
	 * @param usuario the usuario
	 * @param orientacion the orientacion
	 * @return the list
	 */
	public List<OmsOpcione> obtenerMenu(OmsUsuario usuario, String orientacion) 
	{
		return opcionesRolesEAO.obtenerListaOpcionesRol(usuario.getId(), orientacion);
	}
	
	/**
	 * Obtener menu.
	 *
	 * @param rol the rol
	 * @param orientacion the orientacion
	 * @return the list
	 */
	public List<OmsOpcione> obtenerMenu(OmsRole rol, String orientacion) 
	{
		return opcionesRolesEAO.obtenerListaOpcionesRolUsuario(rol.getId(), orientacion);
	}
	
	
	/**
	 * Verificar permiso opcion.
	 *
	 * @param opcion the opcion
	 * @param usuario the usuario
	 * @return true, if successful
	 */
	public boolean verificarPermisoOpcion(OmsOpcione opcion, OmsUsuario usuario)
	{
		return opcionesEAO.permitirAccesoOpcion(opcion, usuario);
	}
	
	/**
	 * Verificar permiso opcion.
	 *
	 * @param opcion the opcion
	 * @param pIdUsuario the id usuario
	 * @return true, if successful
	 */
	public boolean verificarPermisoOpcion(OmsOpcione opcion, Long pIdUsuario)
	{
		return opcionesEAO.permitirAccesoOpcion(opcion, pIdUsuario);
	}
	
	/**
	 * Verificar permiso opcion.
	 *
	 * @param opcion the opcion
	 * @param pRol the rol
	 * @return true, if successful
	 */
	public boolean verificarPermisoOpcion(OmsOpcione opcion, String pRol)
	{
		return opcionesEAO.permitirAccesoOpcion(opcion, pRol);
	}
	
	
}