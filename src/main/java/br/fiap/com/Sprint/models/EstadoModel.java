package br.fiap.com.Sprint.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_TKR_ESTADO")
public class EstadoModel implements Serializable{


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_estado;
	
	@Column(length = 2, nullable = false)
	private String nm_estado;
	
	
	
	public EstadoModel () {}

	public EstadoModel(long cd_estado, String nm_estado) {
		super();
		this.cd_estado = cd_estado;
		this.nm_estado = nm_estado;
	}

	public long getCd_estado() {
		return cd_estado;
	}

	public void setCd_estado(long cd_estado) {
		this.cd_estado = cd_estado;
	}

	public String getNm_estado() {
		return nm_estado;
	}

	public void setNm_estado(String nm_estado) {
		this.nm_estado = nm_estado;
	}
	
	
	
}
