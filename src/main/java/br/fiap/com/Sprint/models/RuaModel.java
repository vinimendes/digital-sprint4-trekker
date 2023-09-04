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
@Table(name="T_TKR_RUA")
public class RuaModel implements Serializable{


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_rua;
	
	@ManyToOne
	@JoinColumn
	private BairroModel cd_bairro;
	
	@Column(length = 120, nullable = false)
	private String nm_rua;
	
	@Column(length = 9, nullable = true)
	private String nr_cep;
	
	
	public RuaModel() {}


	public RuaModel(long cd_rua, BairroModel cd_bairro, String nm_rua, String nr_cep) {
		super();
		this.cd_rua = cd_rua;
		this.cd_bairro = cd_bairro;
		this.nm_rua = nm_rua;
		this.nr_cep = nr_cep;
	}


	public long getCd_rua() {
		return cd_rua;
	}


	public void setCd_rua(long cd_rua) {
		this.cd_rua = cd_rua;
	}


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
