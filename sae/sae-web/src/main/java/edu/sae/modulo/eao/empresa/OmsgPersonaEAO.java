package edu.sae.modulo.eao.empresa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.sae.modulo.dominio.empresa.OmsgPersona;
import edu.sae.modulo.eao.OnixEAO;

/**
 * The Class OmsgPersonaEAO.
 */
@Stateless
@LocalBean
public class OmsgPersonaEAO extends OnixEAO<OmsgPersona, Long> {

}
