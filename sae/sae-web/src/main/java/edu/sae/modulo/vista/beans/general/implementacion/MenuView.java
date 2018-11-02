package edu.sae.modulo.vista.beans.general.implementacion;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

import edu.sae.modulo.dominio.aplicacion.OmsOpcione;
import edu.sae.modulo.librerias.vista.anotaciones.ITestParseMenu;
import edu.sae.modulo.librerias.vista.anotaciones.ITestServicioMenuOpcionesHorizontal;
import edu.sae.modulo.librerias.vista.interfaces.IServiciosMenu;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuView.
 */
@Named("menuView")
@RequestScoped
public class MenuView implements Serializable {

	/** The descripcion opcion. */

	private String descripcionOpcion;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The opciones menu. */
	@Inject
	@ITestServicioMenuOpcionesHorizontal
	private IServiciosMenu<OmsOpcione> opcionesMenu;

	/** The parse menu. */
	@Inject
	@ITestParseMenu
	private TestParseMenu parseMenu;

	/** The model. */
	private MenuModel model;

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
		model = parseMenu.parseMenuOpciones(opcionesMenu.getMenuOpciones());

	}

	/**
	 * Display list.
	 *
	 * @param event the event
	 */
	public void displayList(ActionEvent event) {
		MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
		descripcionOpcion = menuItem.getParams().get("descripcion").get(0);
		System.out.println(descripcionOpcion);
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
	 * Mensaje.
	 */
	public void Mensaje() {
		addMessage("Exito", "Ud a dado un clik");
	}

	/**
	 * Metodo post seleccion menu.
	 */
	public void metodoPostSeleccionMenu() {

	}

	/**
	 * Save.
	 */
	public void save() {
		addMessage("Success", "Data saved");
	}

	/**
	 * Update.
	 */
	public void update() {
		addMessage("Success", "Data updated");
	}

	/**
	 * Delete.
	 */
	public void delete() {
		addMessage("Success", "Data deleted");
	}

	/**
	 * Adds the message.
	 *
	 * @param summary the summary
	 * @param detail the detail
	 */
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Gets the descripcion opcion.
	 *
	 * @return the descripcion opcion
	 */
	public String getDescripcionOpcion() {
		return descripcionOpcion;
	}

	/**
	 * Sets the descripcion opcion.
	 *
	 * @param descripcionOpcion the new descripcion opcion
	 */
	public void setDescripcionOpcion(String descripcionOpcion) {
		this.descripcionOpcion = descripcionOpcion;
	}
}
