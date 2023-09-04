package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.RuaModel;
import br.fiap.com.Sprint.repositories.RuaRepository;
import jakarta.transaction.Transactional;

@Service
public class RuaService {

	final RuaRepository ruaRepository;
	
	public RuaService(RuaRepository ruaRepository) {
		this.ruaRepository = ruaRepository;
	}

	
	@Transactional
	public RuaModel save(RuaModel ruaModel) {
		
		return ruaRepository.save(ruaModel);
		
	}
	

	public Optional<RuaModel> findById(long id) {
		return ruaRepository.findById(id);
	}


	public List<RuaModel> findAll() {
		return ruaRepository.findAll();
	}


	public void delete(RuaModel ruaModel) {
		ruaRepository.delete(ruaModel);
	}
	
	
}