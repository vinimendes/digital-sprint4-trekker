package br.fiap.com.Sprint.dtos;

import jakarta.validation.constraints.NotBlank;

public class EstadoDto {

	@NotBlank
	private String nm_estado;

	public String getNm_estado() {
		return nm_estado;
	}

	public void setNm_estado(String nm_estado) {
		this.nm_estado = nm_estado;
	}
	
	
	
}
