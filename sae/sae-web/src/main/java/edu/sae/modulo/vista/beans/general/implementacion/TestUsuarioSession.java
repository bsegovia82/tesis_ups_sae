package edu.sae.modulo.vista.beans.general.implementacion;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import edu.sae.modulo.librerias.vista.interfaces.IUsuarioSession;



// TODO: Auto-generated Javadoc
/**
 * The Class TestUsuarioSession.
 */
@ITestUsuarioSession
@SessionScoped
public class TestUsuarioSession implements IUsuarioSession<OmsUsuario>, Serializable
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The usuario. */
	private OmsUsuario usuario;

	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.interfaces.IUsuarioSession#setUsuarioSession(java.io.Serializable)
	 */
	public void setUsuarioSession(OmsUsuario usuario) {
		this.usuario = usuario;
	}
	
	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.interfaces.IUsuarioSession#getUsuarioSession()
	 */
	public OmsUsuario getUsuarioSession() {
		
		return this.usuario;
	}

}
