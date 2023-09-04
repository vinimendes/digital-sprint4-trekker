package br.fiap.com.Sprint.dtos;

import br.fiap.com.Sprint.models.EstadoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class CidadeDto {


	private EstadoModel estado;
	
	@NotBlank
	private String nm_cidade;

	public EstadoModel getEstado() {
		return estado;
	}

	public void setEstado(EstadoModel estado) {
		this.estado = estado;
	}

	public String getNm_cidade() {
		return nm_cidade;
	}

	public void setNm_cidade(String nm_cidade) {
		this.nm_cidade = nm_cidade;
	}
	
	
}
