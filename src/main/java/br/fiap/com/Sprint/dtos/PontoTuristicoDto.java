package br.fiap.com.Sprint.dtos;

import java.util.List;

import br.fiap.com.Sprint.models.DestinoModel;
import br.fiap.com.Sprint.models.EnderecoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PontoTuristicoDto {


	private List<DestinoModel> cd_destino;
	
	
	private EnderecoModel cd_endereco;
	
	@NotBlank
	private String nm_pt_turistico;

	public List<DestinoModel> getCd_destino() {
		return cd_destino;
	}

	public void setCd_destino(List<DestinoModel> cd_destino) {
		this.cd_destino = cd_destino;
	}

	public EnderecoModel getCd_endereco() {
		return cd_endereco;
	}

	public void setCd_endereco(EnderecoModel cd_endereco) {
		this.cd_endereco = cd_endereco;
	}

	public String getNm_pt_turistico() {
		return nm_pt_turistico;
	}

	public void setNm_pt_turistico(String nm_pt_turistico) {
		this.nm_pt_turistico = nm_pt_turistico;
	}
	
	
	
}
