package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.EstadoModel;
import br.fiap.com.Sprint.repositories.EstadoRepository;
import jakarta.transaction.Transactional;

@Service
public class EstadoService {

	final EstadoRepository estadoRepository;
	
	public EstadoService(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	
	@Transactional
	public EstadoModel save(EstadoModel estadoModel) {
		
		return estadoRepository.save(estadoModel);
		
	}
	

	public Optional<EstadoModel> findById(long id) {
		return estadoRepository.findById(id);
	}


	public List<EstadoModel> findAll() {
		return estadoRepository.findAll();
	}


	public void delete(EstadoModel estadoModel) {
		estadoRepository.delete(estadoModel);
	}
	
	
}