package edu.sae.modulo.eao.aplicacion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.sae.modulo.dominio.aplicacion.OmsBitacora;
import edu.sae.modulo.eao.OnixEAO;

// TODO: Auto-generated Javadoc
/**
 * The Class OmsBitacoraEAO.
 */
@Stateless
@LocalBean
public class OmsBitacoraEAO extends OnixEAO<OmsBitacora, Long> {
	
	/**
	 * Obtener lista bitacoras.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<OmsBitacora> obtenerListaBitacoras()
	{
		String strQuery = "select * from ONIX_BITACORA g where g.fecha_registro > sysdate - 3 order by g.fecha_registro desc ";
		Query query = adminEntidad.createNativeQuery(strQuery, OmsBitacora.class);
		return query.getResultList();
	}
	
	/**
	 * Obtener lista bitacoras hoy.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<OmsBitacora> obtenerListaBitacorasHoy()
	{
		String strQuery = "select * from ONIX_BITACORA g where g.fecha_registro > sysdate - 1 order by g.fecha_registro desc ";
		Query query = adminEntidad.createNativeQuery(strQuery, OmsBitacora.class);
		return query.getResultList();
	}
	
}
