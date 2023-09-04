package br.fiap.com.Sprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fiap.com.Sprint.models.DestinoModel;

@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, Long>{

}
