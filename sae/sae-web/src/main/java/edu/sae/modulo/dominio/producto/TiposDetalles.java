package edu.sae.modulo.dominio.producto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;


@Entity
@Table(name="ONIX_TIPO_DETALLE_PRODUCTO")
@NamedQuery(name="TiposDetalles.findAll", query="SELECT p FROM TiposDetalles p")
public class TiposDetalles extends EntidadBaseAuditable<Long> implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lTipoDetalle;
	
	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(generator = "TiposDetallesProd", strategy = GenerationType.SEQUENCE)
   	@SequenceGenerator(name = "TiposDetallesProd", allocationSize = 1, initialValue = 1, 
   	sequenceName = "SEC_TIP_DET_PRODUCTO")
	public Long getId() {
		return id;
	}

	
	
	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable)idReferencia);
	}



	public String getlTipoDetalle() {
		return lTipoDetalle;
	}



	public void setlTipoDetalle(String lTipoDetalle) {
		this.lTipoDetalle = lTipoDetalle;
	}
	
	
	
}
