package edu.sae.modulo.vista.beans.general.implementacion;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import edu.sae.modulo.dominio.aplicacion.OmsOpcione;
import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.librerias.vista.anotaciones.ITestServicioMenuOpcionesHorizontal;
import edu.sae.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import edu.sae.modulo.librerias.vista.interfaces.IGuardiaUsuarioSession;
import edu.sae.modulo.librerias.vista.interfaces.IServiciosMenu;
import edu.sae.modulo.librerias.vista.interfaces.IUsuarioSession;
import edu.sae.modulo.servicio.seguridad.ServicioAplicacion;


// TODO: Auto-generated Javadoc
/**
 * The Class TestServiciosMenuHorizontal.
 */
@ITestServicioMenuOpcionesHorizontal
@RequestScoped
public class TestServiciosMenuHorizontal implements IServiciosMenu<OmsOpcione>
{

	/** The parametro obtener opciones. */
	@Inject
	@ITestUsuarioSession
	private IUsuarioSession<OmsUsuario> parametroObtenerOpciones;
	
	/** The servicio aplicacion. */
	@EJB
	private ServicioAplicacion servicioAplicacion;
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.interfaces.IServiciosMenu#getMenuOpciones()
	 */
	public List<OmsOpcione> getMenuOpciones() 
	{
		return servicioAplicacion.obtenerMenu(parametroObtenerOpciones.getUsuarioSession(), IGuardiaUsuarioSession.TIPO_MENU);
	}
	
}
