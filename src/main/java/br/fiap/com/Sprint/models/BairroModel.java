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
@Table(name = "T_TKR_BAIRRO")
public class BairroModel implements Serializable{
	

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_bairro;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn()
	private CidadeModel cd_cidade;

	@Column(length = 150, nullable = false)
	private String nm_bairro;
	
	
	public BairroModel() {}


	public BairroModel(long cd_bairro, CidadeModel cd_cidade, String nm_bairro) {
		super();
		this.cd_bairro = cd_bairro;
		this.cd_cidade = cd_cidade;
		this.nm_bairro = nm_bairro;
	}


	public long getCd_bairro() {
		return cd_bairro;
	}


	public void setCd_bairro(long cd_bairro) {
		this.cd_bairro = cd_bairro;
	}


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
