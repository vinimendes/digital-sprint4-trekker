package br.fiap.com.Sprint.dtos;

import java.math.BigDecimal;

import br.fiap.com.Sprint.models.DestinoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ComidaDto {


	private DestinoModel cd_destino;
	
	@NotBlank
	private String nm_comida;
	
	@NotNull
	private BigDecimal vl_comida;

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
