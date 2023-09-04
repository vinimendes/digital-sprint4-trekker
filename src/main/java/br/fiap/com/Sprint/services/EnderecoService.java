package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.EnderecoModel;
import br.fiap.com.Sprint.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {

	final EnderecoRepository enderecoRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	
	@Transactional
	public EnderecoModel save(EnderecoModel enderecoModel) {
		
		return enderecoRepository.save(enderecoModel);
		
	}
	

	public Optional<EnderecoModel> findById(long id) {
		return enderecoRepository.findById(id);
	}


	public List<EnderecoModel> findAll() {
		return enderecoRepository.findAll();
	}


	public void delete(EnderecoModel enderecoModel) {
		enderecoRepository.delete(enderecoModel);
	}
	
	
}