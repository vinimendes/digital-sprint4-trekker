package br.fiap.com.Sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fiap.com.Sprint.models.EstadoModel;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long>{

	
	
}
