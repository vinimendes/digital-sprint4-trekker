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
@Table(name = "T_TKR_ENDERECO")
public class EnderecoModel implements Serializable{
	

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_endereco;
	
	@ManyToOne
	@JoinColumn
	private RuaModel cd_rua;
	
	@Column(precision = 5)
	private int nr_residencia;
	
	public EnderecoModel() {}

	public EnderecoModel(long cd_endereco, RuaModel cd_rua, int nr_residencia) {
		super();
		this.cd_endereco = cd_endereco;
		this.cd_rua = cd_rua;
		this.nr_residencia = nr_residencia;
	}

	public long getCd_endereco() {
		return cd_endereco;
	}

	public void setCd_endereco(long cd_endereco) {
		this.cd_endereco = cd_endereco;
	}

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
