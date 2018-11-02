package edu.sae.modulo.vista.beans.modulo.aplicacion.seguridad;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.menu.MenuModel;

import edu.sae.modulo.dominio.aplicacion.OmsRole;
import edu.sae.modulo.dominio.aplicacion.OmsUsuario;
import edu.sae.modulo.eao.aplicacion.OmsUsuarioEAO;
import edu.sae.modulo.librerias.exceptions.ErrorServicioNegocio;
import edu.sae.modulo.librerias.exceptions.ErrorValidacionGeneral;
import edu.sae.modulo.librerias.generales.UtilEncriptarDataSource;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.anotaciones.ITestParseMenu;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostCierreDialogo;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostSeleccionEntidadListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PreTransaccionListener;
import edu.sae.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
import edu.sae.modulo.librerias.vista.interfaces.IGuardiaUsuarioSession;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;
import edu.sae.modulo.servicio.seguridad.ServicioAplicacion;
import edu.sae.modulo.vista.beans.general.implementacion.TestParseMenu;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorUsuario.
 */
@ManagedBean
@ViewScoped  
public class BeanMantenedorUsuario
		extends BeanMantenedorGenerico<ServicioMantenedorUsuario, Long, OmsUsuario, OmsUsuarioEAO> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenedorUsuario servicioMantenedor;

	/** The avatar. */
	private byte[] avatar;

	/** The roles seleccionadas. */
	private Long[] rolesSeleccionadas;

	/** The lista roles. */
	private List<OmsRole> listaRoles;

	/** The lista seleccion rol. */
	private DualListModel<String> listaSeleccionRol;

	/** The l contrasenia nueva. */
	private String lContraseniaNueva;

	/** The Constant ES_NUEVO. */
	protected static final String ES_NUEVO = "S";

	/** The servicio aplicacion. */
	@EJB
	private ServicioAplicacion servicioAplicacion;
	
	/** The parse menu. */
	@Inject
	@ITestParseMenu
	private TestParseMenu parseMenu;

	/** The model. */
	private MenuModel model;
	
	/**
	 * Instantiates a new bean mantenedor usuario.
	 */
	public BeanMantenedorUsuario() {
		super(OmsUsuario.class);
		//super.entidadRegistrar.setClave(JsfUtil.CLAVE_INICIAL_DEFAULT);
		listaSeleccionRol = new DualListModel<>();
		lContraseniaNueva = "";
		setNombreAtributoCambioEstado("ENTIDAD_CAMBIAR");
		setNombreAtributoDialogoAlterno("DIALOGO_ALTERNO");
		
		
		addPostTransaccion(new PostTransaccionListener() {

			@Override
			public void metodoPostTransaccion() {
				//entidadRegistrar.setClave(JsfUtil.CLAVE_INICIAL_DEFAULT);
				rolesSeleccionadas = null;
				lContraseniaNueva = null;
			}
		});

		addPostSeleccionRegistroListener(new PostSeleccionEntidadListener<OmsUsuario, Long>() {
			@Override
			public void postSeleccionRegistro(OmsUsuario pEntidadSeleccionada) {
				rolesSeleccionadas = null;
				cargatListaRoles(pEntidadSeleccionada);
				model = parseMenu.parseMenuOpciones(servicioAplicacion.obtenerMenu(pEntidadSeleccionada, IGuardiaUsuarioSession.TIPO_MENU),pEntidadSeleccionada.getId());
			}
		});

		addPreTransaccionServicioListener(new PreTransaccionListener() {

			@Override
			public void accionPreTransaccion() throws ErrorAccionesPreTransaccion {
				try {
					if (rolesSeleccionadas != null && rolesSeleccionadas.length != 0) {
						for (Long idRol : rolesSeleccionadas) {
							entidadRegistrar.agregarRol(servicioMantenedor.obtenerRolPorID(idRol));
						}
					}

				} catch (Throwable e) {
					e.printStackTrace();
					throw new ErrorAccionesPreTransaccion("Imposible registrar los roles");
				}

				if (avatar != null) {

					entidadRegistrar.setImagenReferencia(avatar);

				} else {
					System.out.println("No registra avatar");
				}

				lContraseniaNueva = lContraseniaNueva == null ? "" : lContraseniaNueva;
				if (lContraseniaNueva.length() > 0) {
					entidadRegistrar.setEsNuevo(ES_NUEVO);
					try {
						entidadRegistrar.setClave(UtilEncriptarDataSource.encode(lContraseniaNueva));
					} catch (Throwable lError) {
						throw new ErrorAccionesPreTransaccion("Error al encriptar la contraseña");
					}
				}

			}
		});

		addPostConstructuListener(new PostConstructListener() {

			@Override
			public void metodoPostConstruct() {
				
				listaRoles = getServicioMantenedor().listaRoles();
			}
		});

		addPostEventoCierroDialogo(new PostCierreDialogo() {

			@Override
			public void eventosCierreDialogo() {
				lContraseniaNueva = null;

			}
		});

	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#getServicioMantenedor()
	 */
	protected ServicioMantenedorUsuario getServicioMantenedor() {
		return servicioMantenedor;
	}

	/**
	 * Cargat lista roles.
	 *
	 * @param pEntidadSeleccionada the entidad seleccionada
	 */
	private void cargatListaRoles(OmsUsuario pEntidadSeleccionada) {
		List<String> listaOpcionesAsignadas = servicioMantenedor.obtenerRolesAsignados(pEntidadSeleccionada.getId());
		List<String> listaOpcionesPorAsignar = servicioMantenedor.obtenerRolesPorAsignar(usuarioAutenticado(),
				pEntidadSeleccionada.getId());
		listaSeleccionRol = new DualListModel<>(listaOpcionesPorAsignar, listaOpcionesAsignadas);
	}

	/**
	 * Gets the usuario actual.
	 *
	 * @return the usuario actual
	 */
	public OmsUsuario getUsuarioActual() {
		return getEntidadRegistrar();
	}

	/**
	 * Sets the usuario actual.
	 *
	 * @param usuarioActual the new usuario actual
	 */
	public void setUsuarioActual(OmsUsuario usuarioActual) {
		setEntidadRegistrar(usuarioActual);
	}

	/**
	 * Gets the lista roles.
	 *
	 * @return the lista roles
	 */
	public List<OmsRole> getListaRoles() {
		return listaRoles;
	}

	/**
	 * Sets the lista roles.
	 *
	 * @param listaRoles the new lista roles
	 */
	public void setListaRoles(List<OmsRole> listaRoles) {
		this.listaRoles = listaRoles;
	}

	/**
	 * Gets the roles seleccionadas.
	 *
	 * @return the roles seleccionadas
	 */
	public Long[] getRolesSeleccionadas() {
		return rolesSeleccionadas;
	}

	/**
	 * Sets the roles seleccionadas.
	 *
	 * @param rolesSeleccionadas the new roles seleccionadas
	 */
	public void setRolesSeleccionadas(Long[] rolesSeleccionadas) {
		this.rolesSeleccionadas = rolesSeleccionadas;
	}

	/**
	 * Gets the avatar.
	 *
	 * @return the avatar
	 */
	public byte[] getAvatar() {
		return avatar;
	}

	/**
	 * Sets the avatar.
	 *
	 * @param avatar the new avatar
	 */
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	/**
	 * Subir.
	 *
	 * @param event the event
	 */
	public void subir(FileUploadEvent event) {
		avatar = event.getFile().getContents();
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#cargarListaEtiquetas()
	 */
	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Usuarios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Usuarios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(),
				"Desde esta opción, se pueden editar o crear usuarios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Usuario");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Usuarios registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización Usuario");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos usuario");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);

	}

	/**
	 * Gets the lista seleccion rol.
	 *
	 * @return the lista seleccion rol
	 */
	public DualListModel<String> getListaSeleccionRol() {
		return listaSeleccionRol;
	}

	/**
	 * Sets the lista seleccion rol.
	 *
	 * @param listaSeleccionRol the new lista seleccion rol
	 */
	public void setListaSeleccionRol(DualListModel<String> listaSeleccionRol) {
		this.listaSeleccionRol = listaSeleccionRol;
	}

	/**
	 * Control transferencia.
	 *
	 * @param pEvento the evento
	 */
	public void controlTransferencia(TransferEvent pEvento) {

		Long referencia = obtenerObjetoSesion(JsfUtil.REFERENCIA_SESION);
		List<String> lRolesTransferidas = (List<String>) pEvento.getItems();
		try {
			if (pEvento.isAdd())

				servicioMantenedor.asigarRoles(lRolesTransferidas, usuarioAutenticado(), entidadRegistrar.getId(),
						referencia);

			else {
				if (pEvento.isRemove() && servicioMantenedor.inactivarRoles(lRolesTransferidas, usuarioAutenticado(),
						entidadRegistrar.getId()) > 0) {
					addError("El usuario debe pernecer por lo menos a un rol");
				}
			}
			cargatListaRoles(entidadRegistrar);
		} catch (ErrorServicioNegocio e) {
			e.printStackTrace();
			addError(e.getMessage());

		} catch (ErrorValidacionGeneral e) {
			e.printStackTrace();
			addError(e.getMessage());
		}

	}
	
	/**
	 * Gets the l contrasenia nueva.
	 *
	 * @return the l contrasenia nueva
	 */
	public String getlContraseniaNueva() {
		return lContraseniaNueva;
	}
	
	/**
	 * Sets the l contrasenia nueva.
	 *
	 * @param lContraseniaNueva the new l contrasenia nueva
	 */
	public void setlContraseniaNueva(String lContraseniaNueva) {
		this.lContraseniaNueva = lContraseniaNueva;
	}
	
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public MenuModel getModel() {
		return model;
	}
	
	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(MenuModel model) {
		this.model = model;
	}
	

}
