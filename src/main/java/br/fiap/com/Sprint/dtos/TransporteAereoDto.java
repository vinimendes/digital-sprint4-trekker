package br.fiap.com.Sprint.dtos;

import java.math.BigDecimal;
import java.util.List;

import br.fiap.com.Sprint.models.DestinoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class TransporteAereoDto {


	private List<DestinoModel> cd_destino;
	
	@NotBlank
	private String nm_companhia;
	
	@NotNull
	private BigDecimal vl_passagem;

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
