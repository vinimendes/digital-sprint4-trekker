package br.fiap.com.Sprint.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fiap.com.Sprint.models.HotelModel;


@Repository
public interface HotelRepository extends JpaRepository<HotelModel, Long>{

	
	
}
