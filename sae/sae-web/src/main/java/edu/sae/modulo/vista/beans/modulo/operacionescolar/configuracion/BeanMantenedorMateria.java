package edu.sae.modulo.vista.beans.modulo.operacionescolar.configuracion;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.sae.modulo.dominio.escolar.SaeMateria;
import edu.sae.modulo.eao.escolar.SaeMateriaEAO;
import edu.sae.modulo.librerias.vista.JsfUtil;
import edu.sae.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import edu.sae.modulo.librerias.vista.beans.NombresEtiquetas;
import edu.sae.modulo.servicio.escolar.ServicioMantenimientoMateria;

// TODO: Auto-generated Javadoc
/**
 * The Class BeanMantenedorRol.
 */
@ManagedBean
@ViewScoped
public class BeanMantenedorMateria extends BeanMantenedorGenerico<ServicioMantenimientoMateria, Long, SaeMateria, SaeMateriaEAO> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The servicio mantenedor. */
	@EJB
	private ServicioMantenimientoMateria servicioMantenedor;


	public BeanMantenedorMateria() {
		super(SaeMateria.class);
	}

	/**
	 * Cargar opciones roles.
	 *
	 * @param pEntidadSeleccionada the entidad seleccionada
	 */
	
	protected ServicioMantenimientoMateria getServicioMantenedor() {
		return servicioMantenedor;
	}

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Materia");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Materia");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite los Materias");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Materia");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Materias registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización Materia");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Materia");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	
}
