package br.fiap.com.Sprint.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "T_TKR_CIDADE")
public class CidadeModel implements Serializable{


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_cidade;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_estado")
	private EstadoModel estado;
	
	@Column(length = 100)
	private String nm_cidade;
	
	
	public CidadeModel() {}


	public CidadeModel(long cd_cidade, EstadoModel cd_estado, String nm_cidade) {
		super();
		this.cd_cidade = cd_cidade;
		this.estado = cd_estado;
		this.nm_cidade = nm_cidade;
	}


	public long getCd_cidade() {
		return cd_cidade;
	}


	public void setCd_cidade(long cd_cidade) {
		this.cd_cidade = cd_cidade;
	}


	public EstadoModel getCd_estado() {
		return estado;
	}


	public void setCd_estado(EstadoModel cd_estado) {
		this.estado = cd_estado;
	}


	public String getNm_cidade() {
		return nm_cidade;
	}


	public void setNm_cidade(String nm_cidade) {
		this.nm_cidade = nm_cidade;
	}

	
	
	
}
