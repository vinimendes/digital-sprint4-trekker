package br.fiap.com.Sprint.dtos;

import br.fiap.com.Sprint.models.BairroModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RuaDto {

	

	private BairroModel cd_bairro;
	
	@NotBlank
	private String nm_rua;
	
	@NotBlank
	private String nr_cep;

	public BairroModel getCd_bairro() {
		return cd_bairro;
	}

	public void setCd_bairro(BairroModel cd_bairro) {
		this.cd_bairro = cd_bairro;
	}

	public String getNm_rua() {
		return nm_rua;
	}

	public void setNm_rua(String nm_rua) {
		this.nm_rua = nm_rua;
	}

	public String getNr_cep() {
		return nr_cep;
	}

	public void setNr_cep(String nr_cep) {
		this.nr_cep = nr_cep;
	}
	
	
	
}
