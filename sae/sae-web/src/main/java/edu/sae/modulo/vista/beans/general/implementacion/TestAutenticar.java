package edu.sae.modulo.vista.beans.general.implementacion;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.librerias.generales.UtilEncriptarDataSource;
import edu.sae.modulo.librerias.vista.anotaciones.ITestAutenticacion;
import edu.sae.modulo.librerias.vista.interfaces.IServiciosAutenticacion;
import edu.sae.modulo.servicio.seguridad.ServicioAutenticacion;
import edu.sae.modulo.vista.beans.general.autenticacion.BeanLogin;



// TODO: Auto-generated Javadoc
/**
 * The Class TestAutenticar.
 */
@ITestAutenticacion
@RequestScoped
public class TestAutenticar implements IServiciosAutenticacion<OmsUsuario, BeanLogin>
{
	
	/** The autenticar. */
	@EJB
	private ServicioAutenticacion autenticar;
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.interfaces.IServiciosAutenticacion#autenticar(java.io.Serializable)
	 */
	public OmsUsuario autenticar(BeanLogin datosAutenticar) throws Exception
	{
		OmsUsuario usuari = null;
		try{
			
			
			usuari = autenticar.autenticar(datosAutenticar.getUsuario().toUpperCase(),  UtilEncriptarDataSource.encode(datosAutenticar.getClave()));
		
		
		}catch(Exception e){
			throw new Exception("No existe");
		}
		
		return usuari;
		
	}
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.interfaces.IServiciosAutenticacion#autenticarDominio(java.io.Serializable)
	 */
	public boolean autenticarDominio(BeanLogin datosAutenticar){
		
		return true;
	}
}
