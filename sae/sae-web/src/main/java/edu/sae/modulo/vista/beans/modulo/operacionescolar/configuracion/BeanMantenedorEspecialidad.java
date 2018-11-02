package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.sae.modulo.dominio.empresa.OmsoEspecialidad;
import edu.sae.modulo.eao.empresa.OmsoEspecialidadEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import edu.sae.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import edu.sae.modulo.servicio.escolar.ServicioMantenedorEspecialidad;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorEspecialidad.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorEspecialidad
		extends BeanMantenedorGenerico<ServicioMantenedorEspecialidad, Long, OmsoEspecialidad, OmsoEspecialidadEAO> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenedorEspecialidad servicioMantenedor;

	/** The l lista especialidad. */
	private List<OmsoEspecialidad> lListaEspecialidad;

	/**
	 * Instantiates a new bean mantenedor especialidad.
	 */
	public BeanMantenedorEspecialidad() {
		super(OmsoEspecialidad.class);
		addPostTransaccion(new PostTransaccionListener() {
			@Override
			public void metodoPostTransaccion() {
				
			}
		});

		addPostConstructuListener(new PostConstructListener() {

			@Override
			public void metodoPostConstruct() {
				lListaEspecialidad = servicioMantenedor.listaObjetosActivos(OmsoEspecialidad.class);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#getServicioMantenedor()
	 */
	protected ServicioMantenedorEspecialidad getServicioMantenedor() {
		return servicioMantenedor;
	}

	/* (non-Javadoc)
	 * @see com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico#cargarListaEtiquetas()
	 */
	@Override
	protected void cargarListaEtiquetas() {

		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Empleados Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);

	}

	/**
	 * Gets the l lista especialidad.
	 *
	 * @return the l lista especialidad
	 */
	public List<OmsoEspecialidad> getlListaEspecialidad() {
		return lListaEspecialidad;
	}

	/**
	 * Sets the l lista especialidad.
	 *
	 * @param lListaEspecialidad the new l lista especialidad
	 */
	public void setlListaEspecialidad(List<OmsoEspecialidad> lListaEspecialidad) {
		this.lListaEspecialidad = lListaEspecialidad;
	}

}
