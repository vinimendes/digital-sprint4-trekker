package br.fiap.com.Sprint.dtos;

import br.fiap.com.Sprint.models.RuaModel;
import jakarta.validation.constraints.NotNull;

public class EnderecoDto {


	private RuaModel cd_rua;
	
	@NotNull
	private int nr_residencia;

	public RuaModel getCd_rua() {
		return cd_rua;
	}

	public void setCd_rua(RuaModel cd_rua) {
		this.cd_rua = cd_rua;
	}

	public int getNr_residencia() {
		return nr_residencia;
	}

	public void setNr_residencia(int nr_residencia) {
		this.nr_residencia = nr_residencia;
	}
	
	
	
}

