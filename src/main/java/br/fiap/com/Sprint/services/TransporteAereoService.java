package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.TransporteAereoModel;
import br.fiap.com.Sprint.repositories.TransporteAereoRepository;
import jakarta.transaction.Transactional;

@Service
public class TransporteAereoService {

	final TransporteAereoRepository transporteAereoRepository;
	
	public TransporteAereoService(TransporteAereoRepository transporteAereoRepository) {
		this.transporteAereoRepository = transporteAereoRepository;
	}

	
	@Transactional
	public TransporteAereoModel save(TransporteAereoModel transporteAereoModel) {
		
		return transporteAereoRepository.save(transporteAereoModel);
		
	}
	

	public Optional<TransporteAereoModel> findById(long id) {
		return transporteAereoRepository.findById(id);
	}


	public List<TransporteAereoModel> findAll() {
		return transporteAereoRepository.findAll();
	}


	public void delete(TransporteAereoModel transporteAereoModel) {
		transporteAereoRepository.delete(transporteAereoModel);
	}
	
	
}
