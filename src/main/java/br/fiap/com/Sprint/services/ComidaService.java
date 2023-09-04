package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.ComidaModel;
import br.fiap.com.Sprint.repositories.ComidaRepository;
import jakarta.transaction.Transactional;

@Service
public class ComidaService {

	final ComidaRepository comidaRepository;
	
	public ComidaService(ComidaRepository comidaRepository) {
		this.comidaRepository = comidaRepository;
	}

	
	@Transactional
	public ComidaModel save(ComidaModel comidaModel) {
		
		return comidaRepository.save(comidaModel);
		
	}


	public Optional<ComidaModel> findById(long id) {
		return comidaRepository.findById(id);
	}


	public List<ComidaModel> findAll() {
		return comidaRepository.findAll();
	}


	public void delete(ComidaModel comidaModel) {
		comidaRepository.delete(comidaModel);
	}
	
	
}