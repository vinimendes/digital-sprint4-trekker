package br.fiap.com.Sprint.models;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="T_TKR_COMIDA")
public class ComidaModel implements Serializable{


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_comida;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private DestinoModel cd_destino;
	
	@Column(length = 120, nullable = false)
	private String nm_comida;
	
	@Column(precision = 6, scale = 2, nullable = false)
	private BigDecimal vl_comida;

	public ComidaModel() {}

	public ComidaModel(long cd_comida, DestinoModel cd_destino, String nm_comida, BigDecimal vl_comida) {
		super();
		this.cd_comida = cd_comida;
		this.cd_destino = cd_destino;
		this.nm_comida = nm_comida;
		this.vl_comida = vl_comida;
	}

	public long getCd_comida() {
		return cd_comida;
	}

	public void setCd_comida(long cd_comida) {
		this.cd_comida = cd_comida;
	}

	public DestinoModel getCd_destino() {
		return cd_destino;
	}

	public void setCd_destino(DestinoModel cd_destino) {
		this.cd_destino = cd_destino;
	}

	public String getNm_comida() {
		return nm_comida;
	}

	public void setNm_comida(String nm_comida) {
		this.nm_comida = nm_comida;
	}

	public BigDecimal getVl_comida() {
		return vl_comida;
	}

	public void setVl_comida(BigDecimal vl_comida) {
		this.vl_comida = vl_comida;
	}
	
	
	
	
	
	
	
}
