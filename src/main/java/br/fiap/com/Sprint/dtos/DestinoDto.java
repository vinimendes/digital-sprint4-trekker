package br.fiap.com.Sprint.dtos;

import br.fiap.com.Sprint.models.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class DestinoDto {


	private UsuarioModel cd_usuario;
	
	@NotBlank
	private String nm_destino;
	
	@NotNull
	private int qt_dias;

	@NotBlank
	private String nm_partida;

	public UsuarioModel getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(UsuarioModel cd_usuario) {
		this.cd_usuario = cd_usuario;
	}

	public String getNm_destino() {
		return nm_destino;
	}

	public void setNm_destino(String nm_destino) {
		this.nm_destino = nm_destino;
	}

	public int getQt_dias() {
		return qt_dias;
	}

	public void setQt_dias(int qt_dias) {
		this.qt_dias = qt_dias;
	}

	public String getNm_partida() {
		return nm_partida;
	}

	public void setNm_partida(String nm_partida) {
		this.nm_partida = nm_partida;
	}
	
	
	
}
