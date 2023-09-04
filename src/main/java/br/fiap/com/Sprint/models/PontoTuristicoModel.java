package br.fiap.com.Sprint.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="T_TKR_PONTO_TURISTICO")
public class PontoTuristicoModel implements Serializable{
	

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cd_pt_turistico;
	
	@OneToMany
	@JoinColumn(nullable = false)
	private List<DestinoModel> cd_destino;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private EnderecoModel cd_endereco;
	
	@Column(length = 300, nullable = false)
	private String nm_pt_turistico;
	
	public PontoTuristicoModel() {}

	public PontoTuristicoModel(long cd_pt_turistico, List<DestinoModel> cd_destino, EnderecoModel cd_endereco,
			String nm_pt_turistico) {
		super();
		this.cd_pt_turistico = cd_pt_turistico;
		this.cd_destino = cd_destino;
		this.cd_endereco = cd_endereco;
		this.nm_pt_turistico = nm_pt_turistico;
	}



	public long getCd_pt_turistico() {
		return cd_pt_turistico;
	}

	public void setCd_pt_turistico(long cd_pt_turistico) {
		this.cd_pt_turistico = cd_pt_turistico;
	}
	
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
