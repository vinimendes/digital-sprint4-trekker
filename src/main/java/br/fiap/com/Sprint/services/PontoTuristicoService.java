package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.PontoTuristicoModel;
import br.fiap.com.Sprint.repositories.PontoTuristicoRepository;
import jakarta.transaction.Transactional;

@Service
public class PontoTuristicoService {

	final PontoTuristicoRepository pontoTuristicoRepository;
	
	public PontoTuristicoService(PontoTuristicoRepository pontoTuristicoRepository) {
		this.pontoTuristicoRepository = pontoTuristicoRepository;
	}

	
	@Transactional
	public PontoTuristicoModel save(PontoTuristicoModel pontoTuristicoModel) {
		
		return pontoTuristicoRepository.save(pontoTuristicoModel);
		
	}
	

	public Optional<PontoTuristicoModel> findById(long id) {
		return pontoTuristicoRepository.findById(id);
	}


	public List<PontoTuristicoModel> findAll() {
		return pontoTuristicoRepository.findAll();
	}


	public void delete(PontoTuristicoModel pontoTuristicoModel) {
		pontoTuristicoRepository.delete(pontoTuristicoModel);
	}
	
}