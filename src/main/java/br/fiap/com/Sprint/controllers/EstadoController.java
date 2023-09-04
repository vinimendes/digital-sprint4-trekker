package br.fiap.com.Sprint.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fiap.com.Sprint.dtos.EstadoDto;
import br.fiap.com.Sprint.models.EstadoModel;
import br.fiap.com.Sprint.services.EstadoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/estado")
public class EstadoController {

	final EstadoService estadoService;

	
	public EstadoController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveEstado(@RequestBody @Valid EstadoDto estadoDto) {
		
		var EstadoModel = new EstadoModel();
		BeanUtils.copyProperties(estadoDto, EstadoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.save(EstadoModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<EstadoModel>> getAllEstado() {
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneEstado(@PathVariable(value = "id") long id){
		Optional<EstadoModel> EstadoModelOptional = estadoService.findById(id);
		if (!EstadoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(EstadoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEstado(@PathVariable(value="id") long id) {
		Optional<EstadoModel> estadoModelOptional = estadoService.findById(id);
		if(!estadoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado not Found");
		}
		estadoService.delete(estadoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Estado deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEstado(@PathVariable(value = "id") long id,
												@RequestBody @Valid EstadoDto estadoDto){
		Optional<EstadoModel> estadoModelOptional = estadoService.findById(id);
		if(!estadoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado not Found");
		}
		var estadoModel = new EstadoModel();		
		BeanUtils.copyProperties(estadoDto, estadoModel);
		estadoModel.setCd_estado(estadoModelOptional.get().getCd_estado());
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.save(estadoModel));
		
		
	}
	
}