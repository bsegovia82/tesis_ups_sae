package edu.sae.modulo.servicio.seguridad;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.eao.aplicacion.OmsUsuarioEAO;






// TODO: Auto-generated Javadoc
/**
 * The Class ServicioAutenticacion.
 */
@Stateless
public class ServicioAutenticacion
{
	
	/** The pb usuario. */
	@EJB
	private OmsUsuarioEAO pbUsuario;



	
	
	/**
	 * Autenticar.
	 *
	 * @param pUsuario the usuario
	 * @param pClave the clave
	 * @return the oms usuario
	 */
	public OmsUsuario autenticar(String pUsuario, String pClave) {
		
		
		OmsUsuario usuario = pbUsuario.buscarUsuario(pUsuario);
		
		if(usuario==null){
			System.err.println("El usuario no existe");
			return null;
		}
		
		if (usuario.getUsuario()==null || usuario.getUsuario()=="")
		{
			System.err.println("El usuario no existe");
			return null;
		}
		
		if (!usuario.getClave().equals(pClave))
		{
			System.err.println("La clave no es la correcta");
			return null;
		}
		return usuario;
	}

}
