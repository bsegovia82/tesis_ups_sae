package edu.sae.modulo.dominio.escolar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "SAE_TIPO_CALIFICACION")
public class SaeTipoCalificacion extends EntidadBaseAuditable<Long> implements Serializable
{
	private static final long serialVersionUID = 1L;
	private  String lDescripcionTipo;

	@GeneratedValue(generator = "secTipoCalificacion", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secTipoCalificacion", allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_TIPO_CALIFICACION")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);	
	}

	public String getlDescripcionTipo() {
		return lDescripcionTipo;
	}

	public void setlDescripcionTipo(String lDescripcionTipo) {
		this.lDescripcionTipo = lDescripcionTipo;
	}
	
	

}
