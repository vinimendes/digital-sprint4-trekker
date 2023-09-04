package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.fiap.com.Sprint.models.CidadeModel;
import br.fiap.com.Sprint.repositories.CidadeRepository;
import jakarta.transaction.Transactional;

@Service
public class CidadeService {

	final CidadeRepository cidadeRepository;

	
	public CidadeService(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
	}

	
	@Transactional
	public CidadeModel save(CidadeModel cidadeModel) {		
		return cidadeRepository.save(cidadeModel);
	}


	public List<CidadeModel> findAll() {
		return cidadeRepository.findAll();
	}


	public Optional<CidadeModel> findById(long id) {
		return cidadeRepository.findById(id);
	}


	public void delete(CidadeModel cidadeModel) {
		cidadeRepository.delete(cidadeModel);
	}
	
	
}
