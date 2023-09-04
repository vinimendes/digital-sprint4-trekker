package br.fiap.com.Sprint.dtos;

import br.fiap.com.Sprint.models.CidadeModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class BairroDto {


	private CidadeModel cd_cidade;

	@NotBlank
	private String nm_bairro;

	
	
	public CidadeModel getCd_cidade() {
		return cd_cidade;
	}

	public void setCd_cidade(CidadeModel cd_cidade) {
		this.cd_cidade = cd_cidade;
	}

	public String getNm_bairro() {
		return nm_bairro;
	}

	public void setNm_bairro(String nm_bairro) {
		this.nm_bairro = nm_bairro;
	}
	
	
	
}
