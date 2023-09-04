package br.fiap.com.Sprint.dtos;

import java.math.BigDecimal;

import br.fiap.com.Sprint.models.DestinoModel;
import br.fiap.com.Sprint.models.EnderecoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HotelDto {


	private DestinoModel cd_destino;

	private EnderecoModel cd_endereco;
	@NotBlank
	private String nm_hotel;
	@NotNull
	private BigDecimal vl_diaria;
	
	
	
	
	
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
	
	
	
	
}
