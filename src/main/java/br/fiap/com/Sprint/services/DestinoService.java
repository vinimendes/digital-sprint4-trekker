package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import br.fiap.com.Sprint.models.DestinoModel;
import br.fiap.com.Sprint.repositories.DestinoRepository;
import jakarta.transaction.Transactional;

@Service
public class DestinoService {

	final DestinoRepository destinoRepository;
	
	public DestinoService(DestinoRepository destinoRepository) {
		this.destinoRepository = destinoRepository;
	}

	
	@Transactional
	public DestinoModel save(DestinoModel destinoModel) {
		
		return destinoRepository.save(destinoModel);
		
	}
	

	public Optional<DestinoModel> findById(long id) {
		return destinoRepository.findById(id);
	}


	public List<DestinoModel> findAll() {
		return destinoRepository.findAll();
	}


	public void delete(DestinoModel destinoModel) {
		destinoRepository.delete(destinoModel);
	}
	
	
}