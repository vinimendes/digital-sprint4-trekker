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

import br.fiap.com.Sprint.dtos.ComidaDto;
import br.fiap.com.Sprint.models.ComidaModel;
import br.fiap.com.Sprint.services.ComidaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/comida")
public class ComidaController {

	final ComidaService comidaService;
	
	
	public ComidaController(ComidaService comidaService) {
		this.comidaService = comidaService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveComida(@RequestBody @Valid ComidaDto comidaDto) {
		
		var ComidaModel = new ComidaModel();
		BeanUtils.copyProperties(comidaDto, ComidaModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(comidaService.save(ComidaModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<ComidaModel>> getAllComida() {
		return ResponseEntity.status(HttpStatus.OK).body(comidaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneComida(@PathVariable(value = "id") long id){
		Optional<ComidaModel> ComidaModelOptional = comidaService.findById(id);
		if (!ComidaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ComidaModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteComida(@PathVariable(value="id") long id) {
		Optional<ComidaModel> comidaModelOptional = comidaService.findById(id);
		if(!comidaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comida not Found");
		}
		comidaService.delete(comidaModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Comida deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateComida(@PathVariable(value = "id") long id,
												@RequestBody @Valid ComidaDto comidaDto){
		Optional<ComidaModel> comidaModelOptional = comidaService.findById(id);
		if(!comidaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comida not Found");
		}
		var comidaModel = new ComidaModel();		
		BeanUtils.copyProperties(comidaDto, comidaModel);
		comidaModel.setCd_comida(comidaModelOptional.get().getCd_comida());
		return ResponseEntity.status(HttpStatus.OK).body(comidaService.save(comidaModel));
		
		
	}
	
}
