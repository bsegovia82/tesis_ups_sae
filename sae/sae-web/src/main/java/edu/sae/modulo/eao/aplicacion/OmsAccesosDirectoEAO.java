package edu.sae.modulo.eao.aplicacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.aplicacion.OmsAccesosDirecto;
import edu.sae.modulo.eao.OnixEAO;

// TODO: Auto-generated Javadoc
/**
 * The Class OmsAccesosDirectoEAO.
 */
@Stateless
@LocalBean
public class OmsAccesosDirectoEAO extends OnixEAO<OmsAccesosDirecto, Long> {

	/**
	 * Obtener acceso.
	 *
	 * @param idAcceso the id acceso
	 * @return the oms accesos directo
	 */
	public OmsAccesosDirecto obtenerAcceso(Long idAcceso) {
		return obtenerObjetoPorPk(idAcceso, OmsAccesosDirecto.class);
	}

}
