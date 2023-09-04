package br.fiap.com.Sprint.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.HotelModel;
import br.fiap.com.Sprint.repositories.HotelRepository;
import jakarta.transaction.Transactional;

@Service
public class HotelService {

	final HotelRepository hotelRepository;
	
	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	
	@Transactional
	public HotelModel save(HotelModel hotelModel) {
		
		return hotelRepository.save(hotelModel);
		
	}
	

	public Optional<HotelModel> findById(long id) {
		return hotelRepository.findById(id);
	}


	public List<HotelModel> findAll() {
		return hotelRepository.findAll();
	}


	public void delete(HotelModel hotelModel) {
		hotelRepository.delete(hotelModel);
	}
	
	
}
