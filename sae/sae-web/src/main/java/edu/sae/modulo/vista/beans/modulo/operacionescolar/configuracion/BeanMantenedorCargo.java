package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.sae.modulo.dominio.aplicacion.OmsRole;
import edu.sae.modulo.dominio.empresa.OmsoCargo;
import edu.sae.modulo.eao.empresa.OmsoCargoEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorCargo;
import edu.sae.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorRol;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorCargo.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorCargo
		extends BeanMantenedorGenerico<ServicioMantenedorCargo, Long, OmsoCargo, OmsoCargoEAO> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenedorCargo servicioMantenedor;

	/** The servicio mantenedor rol. */
	@EJB
	private ServicioMantenedorRol servicioMantenedorRol;

	/** The lista roles. */
	private List<OmsRole> listaRoles;

	/**
	 * Instantiates a new bean mantenedor cargo.
	 */
	public BeanMantenedorCargo() {
		super(OmsoCargo.class);
		this.entidadRegistrar.setRolDefault(new OmsRole());
		addPostConstructuListener(new PostConstructListener() {
			@Override
			public void metodoPostConstruct() {
				
				listaRoles = servicioMantenedorRol.ejecutarQueryNativoObjeto("select * from ONIX_ROLES where seleccionable = 'S' and estado = 'A' and ambito in ( 'E', 'A') ", new HashMap<>(), OmsRole.class);
				
				
				entidadRegistrar.setRolDefault(new OmsRole());
			}
		});

		addPostTransaccion(new PostTransaccionListener() {

			@Override
			public void metodoPostTransaccion() {
				entidadRegistrar.setRolDefault(new OmsRole());

			}
		});
		
		addPostEventoInicializacion(() -> 
		{
			entidadRegistrar.setRolDefault(new OmsRole());
		});

	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#getServicioMantenedor()
	 */
	@Override
	protected ServicioMantenedorCargo getServicioMantenedor() {
		return servicioMantenedor;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#cargarListaEtiquetas()
	 */
	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Cargos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Cargos registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Cargos registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
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
}
