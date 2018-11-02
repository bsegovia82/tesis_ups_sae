package edu.sae.modulo.vista.beans.general.autenticacion;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import edu.sae.modulo.dominio.aplicacion.OmsRole;
import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.dominio.aplicacion.OmsUsuariosRole;
import edu.sae.modulo.librerias.generales.UtilEncriptarDataSource;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.anotaciones.ITestAutenticacion;
import edu.sae.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import edu.sae.modulo.librerias.vista.beans.ManagedBeanGenerico;
import edu.sae.modulo.librerias.vista.interfaces.IGuardiaUsuarioSession;
import edu.sae.modulo.librerias.vista.interfaces.IServiciosAutenticacion;
import edu.sae.modulo.librerias.vista.interfaces.IUsuarioSession;
import edu.sae.modulo.servicio.seguridad.ServiciosMantenimientoSeguridad;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanLogin.
 */
@ManagedBean(name = "beanLogin")
@ViewScoped
public class BeanLogin extends ManagedBeanGenerico {
	
	/** The usuario session. */

	@Inject
	@ITestUsuarioSession
	private IUsuarioSession<OmsUsuario> usuarioSession;


	/** The camb contrase 1. */
	private String cambContrase1;
	
	/** The camb contrase 2. */
	private String cambContrase2;

	/** The autenticador. */
	@Inject
	@ITestAutenticacion
	private IServiciosAutenticacion<OmsUsuario, BeanLogin> autenticador;

	/** The servicios mantenimiento seguridad. */
	@EJB
	private ServiciosMantenimientoSeguridad serviciosMantenimientoSeguridad;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The usuario. */
	private String usuario;
	
	/** The clave. */
	private String clave;

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the clave.
	 *
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Sets the clave.
	 *
	 * @param clave the new clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Login.
	 *
	 * @return the string
	 */
	public String login() {
		try {
			if (this.isAutenticado())
				this.getHttpServletRequest().logout();
			this.getHttpServletRequest().login(usuario.toUpperCase(), UtilEncriptarDataSource.encode(clave));
			OmsUsuario usuario = autenticador.autenticar(this);
			if (usuario == null) {
				addError("USUARIO/CLAVE Invalidos");
				return "";
			}
			if ("I".equals(usuario.getEstado())) {
				addError("Usuario Inactivo");
				return "";
			}
			usuario.setRolesAsignados(rolesUsuario(usuario));
			OmsRole lRolPrincipal = rolPrincipalUsuario(usuario);
			usuario.setRolPrincipal(lRolPrincipal == null ? "SIN ROL PRINCIPAL " : lRolPrincipal.getRol());
			usuarioSession.setUsuarioSession(usuario);
			generarSemillaSegura(usuario);

			agregarObjetoSesion(JsfUtil.REFERENCIA_SESION, usuario.getIdReferencia());

			/*return lRolPrincipal != null && lRolPrincipal.getlPaginaPrincipal() != null
					? lRolPrincipal.getlPaginaPrincipal() : IGuardiaUsuarioSession.PAGINA_PRINCIPAL_RED;*/
			return IGuardiaUsuarioSession.PAGINA_PRINCIPAL_RED;

		} catch (Throwable e) {

			addError("USUARIO/CLAVE Invalidos");
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Recuperar clave.
	 *
	 * @param evento the evento
	 */
	public void recuperarClave(ActionEvent evento) {

	}

	/**
	 * Contactar admin.
	 *
	 * @param evento the evento
	 */
	public void contactarAdmin(ActionEvent evento) {

	}

	/**
	 * Roles usuario.
	 *
	 * @param usuario the usuario
	 * @return the string
	 */
	private String rolesUsuario(OmsUsuario usuario) {

		List<OmsUsuariosRole> listaUsuariosRoles = usuario.getPriUsuariosRoles();
		String roles = "";
		for (OmsUsuariosRole rol : listaUsuariosRoles) {
			if (rol.getEstado().equals("A")) {
				roles = roles + rol.getPriRole().getRol() + ", ";
			}
		}

		return roles;
	}

	/**
	 * Rol principal usuario.
	 *
	 * @param usuario the usuario
	 * @return the oms role
	 */
	private OmsRole rolPrincipalUsuario(OmsUsuario usuario) {

		List<OmsUsuariosRole> listaUsuariosRoles = usuario.getPriUsuariosRoles();
		OmsRole lRol = null;
		for (OmsUsuariosRole rol : listaUsuariosRoles) {
			String lTipoRol = rol.getPriRole().getTipoRol() == null ? "" : rol.getPriRole().getTipoRol();

			if (lTipoRol.equals("P")) {
				lRol = rol.getPriRole();
			}
		}

		return lRol;
	}

	/**
	 * Generar semilla segura.
	 *
	 * @param usuario the usuario
	 */
	private void generarSemillaSegura(OmsUsuario usuario) {
		try {
			((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).setAttribute(
					IGuardiaUsuarioSession.SEMILLA, UtilEncriptarDataSource.encode(usuario.getUsuario().toUpperCase()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the usuario session.
	 *
	 * @return the usuario session
	 */
	public IUsuarioSession<OmsUsuario> getUsuarioSession() {
		return usuarioSession;
	}

	/**
	 * Sets the usuario session.
	 *
	 * @param usuarioSession the new usuario session
	 */
	public void setUsuarioSession(IUsuarioSession<OmsUsuario> usuarioSession) {
		this.usuarioSession = usuarioSession;
	}

	/**
	 * Logout.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void logout() throws IOException {

		try {
			this.getHttpServletRequest().logout();
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		ec.redirect(ec.getRequestContextPath() + IGuardiaUsuarioSession.PAGINA_LOGIN_RED);
	}

	/**
	 * Cerrar ventana.
	 *
	 * @param evento the evento
	 */
	public void cerrarVentana(ActionEvent evento) {

		// if
		// (!serviciosMantenimientoSeguridad.obtenerUsuarioTot(usuarioSession.getUsuarioSession().getUsuario())
		// .getClave().equals(usuarioSession.getUsuarioSession().getClave()))
		if (!("S").equals(serviciosMantenimientoSeguridad
				.obtenerUsuarioTot(usuarioSession.getUsuarioSession().getUsuario()).getEsNuevo()))

			try {
				logout();
			} catch (IOException e) {
				e.printStackTrace();
			}

		else
			RequestContext.getCurrentInstance().execute("PF('dlg2')."
					+ (("S".equals(usuarioSession.getUsuarioSession().getEsNuevo()) ? "show" : "hide") + "();"));

	}

	/**
	 * Cambiar contrasenia.
	 *
	 * @param evento the evento
	 */
	public void cambiarContrasenia(ActionEvent evento) {

		if (!cambContrase1.equals(cambContrase2)) {
			addError("Las contraseñas no coninciden");
			return;
		}

		if (cambContrase1.length() < 8) {
			addError("Ingrese una contraseña de 8 caracteres mínimo");
			return;
		}

		try {
			OmsUsuario usuarioBASE = serviciosMantenimientoSeguridad
					.obtenerUsuarioTot(usuarioSession.getUsuarioSession().getUsuario());
			usuarioBASE.setClave(UtilEncriptarDataSource.encode(cambContrase1));
			usuarioBASE.setEsNuevo("N");
			serviciosMantenimientoSeguridad.cambioClaveUsuario(usuarioBASE);
			addMensaje("Su contraseña fue cambiada con éxito");
		} catch (Throwable e) {
			addError("Imposible realizar el cambio de contraseña");
			e.printStackTrace();
		}
	}

	/**
	 * Gets the camb contrase 1.
	 *
	 * @return the camb contrase 1
	 */
	public String getCambContrase1() {
		return cambContrase1;
	}

	/**
	 * Sets the camb contrase 1.
	 *
	 * @param cambContrase1 the new camb contrase 1
	 */
	public void setCambContrase1(String cambContrase1) {
		this.cambContrase1 = cambContrase1;
	}

	/**
	 * Gets the camb contrase 2.
	 *
	 * @return the camb contrase 2
	 */
	public String getCambContrase2() {
		return cambContrase2;
	}

	/**
	 * Sets the camb contrase 2.
	 *
	 * @param cambContrase2 the new camb contrase 2
	 */
	public void setCambContrase2(String cambContrase2) {
		this.cambContrase2 = cambContrase2;
	}
}
