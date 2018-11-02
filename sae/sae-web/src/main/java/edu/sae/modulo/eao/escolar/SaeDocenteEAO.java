package edu.sae.modulo.eao.escolar;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.sae.modulo.dominio.escolar.SaeDocente;
import edu.sae.modulo.eao.OnixEAO;

// TODO: Auto-generated Javadoc
/**
 * The Class OmsoEmpleadoEAO.
 */
@Stateless
@LocalBean
public class SaeDocenteEAO extends OnixEAO<SaeDocente, Long> 
{

	/**
	 * Buscar empleado por id persona.
	 *
	 * @param idPersona the id persona
	 * @return the omso empleado
	 */
	public SaeDocente buscarEmpleadoPorIdPersona (Long idPersona)
	{
		String query = "select modelo from SaeDocente modelo "
				+ "where modelo.persona.id = :idPersona";
		
		Query qry =  getAdminEntidad().createQuery(query);
		
		qry.setParameter("idPersona", idPersona);
		
		List<SaeDocente> listaEmpleados = qry.getResultList();
		
		if(!listaEmpleados.isEmpty())
		{
			return listaEmpleados.get(0);
		}else
		{
			return null;
		}
		
	}
	
}
