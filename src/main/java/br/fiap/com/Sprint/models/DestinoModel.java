package br.fiap.com.Sprint.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="T_TKR_DESTINO")
public class DestinoModel implements Serializable{
	

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_destino;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private UsuarioModel cd_usuario;
	
	@Column(length = 120, nullable = false)
	private String nm_destino;
	
	@Column(precision = 3, nullable = false)
	private int qt_dias;

	@Column(length = 2, nullable = false)
	private String nm_partida;
	
	
	public DestinoModel() {}


	public DestinoModel(long cd_destino, UsuarioModel cd_usuario, String nm_destino, int qt_dias, String nm_partida) {
		super();
		this.cd_destino = cd_destino;
		this.cd_usuario = cd_usuario;
		this.nm_destino = nm_destino;
		this.qt_dias = qt_dias;
		this.nm_partida = nm_partida;
	}


	public long getCd_destino() {
		return cd_destino;
	}


	public void setCd_destino(long cd_destino) {
		this.cd_destino = cd_destino;
	}


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
