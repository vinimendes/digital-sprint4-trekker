package br.fiap.com.Sprint.models;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="T_TKR_HOTEL")
public class HotelModel implements Serializable{


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_hotel;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private DestinoModel cd_destino;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private EnderecoModel cd_endereco;
	
	@Column(nullable = false, length = 150)
	private String nm_hotel;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal vl_diaria;

	
	public HotelModel() {}
	
	public HotelModel(long cd_hotel, DestinoModel cd_destino, EnderecoModel cd_endereco, String nm_hotel,
			BigDecimal vl_diaria) {
		super();
		this.cd_hotel = cd_hotel;
		this.cd_destino = cd_destino;
		this.cd_endereco = cd_endereco;
		this.nm_hotel = nm_hotel;
		this.vl_diaria = vl_diaria;
	}

	public long getCd_hotel() {
		return cd_hotel;
	}

	public void setCd_hotel(long cd_hotel) {
		this.cd_hotel = cd_hotel;
	}

	public DestinoModel getCd_destino() {
		return cd_destino;
	}

	public void setCd_destino(DestinoModel cd_destino) {
		this.cd_destino = cd_destino;
	}

	public EnderecoModel getCd_endereco() {
		return cd_endereco;
	}

	public void setCd_endereco(EnderecoModel cd_endereco) {
		this.cd_endereco = cd_endereco;
	}

	public String getNm_hotel() {
		return nm_hotel;
	}

	public void setNm_hotel(String nm_hotel) {
		this.nm_hotel = nm_hotel;
	}

	public BigDecimal getVl_diaria() {
		return vl_diaria;
	}

	public void setVl_diaria(BigDecimal vl_diaria) {
		this.vl_diaria = vl_diaria;
	}

	
	

	
	
	
}
