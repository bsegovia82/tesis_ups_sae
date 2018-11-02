package edu.sae.modulo.eao.aplicacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.sae.modulo.dominio.aplicacion.OmsUsuariosRole;
import edu.sae.modulo.eao.OnixEAO;

// TODO: Auto-generated Javadoc
/**
 * The Class OmsUsuariosRoleEAO.
 */
@Stateless
@LocalBean
public class OmsUsuariosRoleEAO extends OnixEAO<OmsUsuariosRole, Long> {

	/**
	 * Eliminar usuario rol.
	 *
	 * @param idUsuario the id usuario
	 */
	public void eliminarUsuarioRol(Long idUsuario) {
		String lsQuery = "delete from " + "ONIX_Usuarios_Roles where id_usuario = :idUsuario ";
		Query query = adminEntidad.createNativeQuery(lsQuery);
		query.setParameter("idUsuario", idUsuario);
		query.executeUpdate();
	}

}
