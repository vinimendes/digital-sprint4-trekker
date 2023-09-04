package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.BairroModel;
import br.fiap.com.Sprint.repositories.BairroRepository;
import jakarta.transaction.Transactional;

@Service
public class BairroService {

	final BairroRepository bairroRepository;
	
	public BairroService(BairroRepository bairroRepository) {
		this.bairroRepository = bairroRepository;
	}

	
	@Transactional
	public BairroModel save(BairroModel bairroModel) {
		
		return bairroRepository.save(bairroModel);
		
	}


	public List<BairroModel> findAll() {
		return bairroRepository.findAll();
	}


	public Optional<BairroModel> findById(long id) {
		return bairroRepository.findById(id);
	}


	public void delete(BairroModel bairroModel) {
		bairroRepository.delete(bairroModel);
	}
}
	