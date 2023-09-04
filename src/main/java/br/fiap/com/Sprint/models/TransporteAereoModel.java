package br.fiap.com.Sprint.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="T_TKR_TRANSPORTE_AEREO")
public class TransporteAereoModel implements Serializable{
	

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_transp_aereo;
	
	@OneToMany
	@JoinColumn(nullable = false)
	private List<DestinoModel> cd_destino;
	
	@Column(length = 150, nullable = false)
	private String nm_companhia;
	
	@Column(precision = 9, scale = 2, nullable = false)
	private BigDecimal vl_passagem;
	
	
	public TransporteAereoModel() {}


	public TransporteAereoModel(long cd_transp_aereo, List<DestinoModel> cd_destino, String nm_companhia,
			BigDecimal vl_passagem) {
		super();
		this.cd_transp_aereo = cd_transp_aereo;
		this.cd_destino = cd_destino;
		this.nm_companhia = nm_companhia;
		this.vl_passagem = vl_passagem;
	}


	public long getCd_transp_aereo() {
		return cd_transp_aereo;
	}


	public void setCd_transp_aereo(long cd_transp_aereo) {
		this.cd_transp_aereo = cd_transp_aereo;
	}


	public List<DestinoModel> getCd_destino() {
		return cd_destino;
	}


	public void setCd_destino(List<DestinoModel> cd_destino) {
		this.cd_destino = cd_destino;
	}


	public String getNm_companhia() {
		return nm_companhia;
	}


	public void setNm_companhia(String nm_companhia) {
		this.nm_companhia = nm_companhia;
	}


	public BigDecimal getVl_passagem() {
		return vl_passagem;
	}


	public void setVl_passagem(BigDecimal vl_passagem) {
		this.vl_passagem = vl_passagem;
	}
	
	
	

}
