package edu.sae.modulo.dominio.escolar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.sae.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "SAE_DET_TIPO_CALIFICACION")
public class SaeDetallesTipoCalificacion extends EntidadBaseAuditable<Long> implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private String lValorCalificable;
	
	private SaeTipoCalificacion lTipoCalificacion;

	@GeneratedValue(generator = "secDetTipoCal", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secDetTipoCal", allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_DET_TIPO_CALIF")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setIdReferencia(Long idReferencia) {
		super.setIdReferencia((Serializable) idReferencia);
	}

	public String getlValorCalificable() {
		return lValorCalificable;
	}

	public void setlValorCalificable(String lValorCalificable) {
		this.lValorCalificable = lValorCalificable;
	}

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_CALIFICACION")
	public SaeTipoCalificacion getlTipoCalificacion() {
		return lTipoCalificacion;
	}

	public void setlTipoCalificacion(SaeTipoCalificacion lTipoCalificacion) {
		this.lTipoCalificacion = lTipoCalificacion;
	}
	
	

}
