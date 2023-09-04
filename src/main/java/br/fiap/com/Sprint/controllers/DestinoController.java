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

import br.fiap.com.Sprint.dtos.DestinoDto;
import br.fiap.com.Sprint.models.DestinoModel;
import br.fiap.com.Sprint.services.DestinoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	final DestinoService destinoService;
	
	
	public DestinoController(DestinoService destinoService) {
		this.destinoService = destinoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveDestino(@RequestBody @Valid DestinoDto destinoDto) {
		
		var DestinoModel = new DestinoModel();
		BeanUtils.copyProperties(destinoDto, DestinoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(destinoService.save(DestinoModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<DestinoModel>> getAllDestino() {
		return ResponseEntity.status(HttpStatus.OK).body(destinoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneDestino(@PathVariable(value = "id") long id){
		Optional<DestinoModel> DestinoModelOptional = destinoService.findById(id);
		if (!DestinoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(DestinoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDestino(@PathVariable(value="id") long id) {
		Optional<DestinoModel> destinoModelOptional = destinoService.findById(id);
		if(!destinoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino not Found");
		}
		destinoService.delete(destinoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Destino deleted.");
	}
	
	
}