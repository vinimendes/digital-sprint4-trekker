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

import br.fiap.com.Sprint.dtos.PontoTuristicoDto;
import br.fiap.com.Sprint.models.PontoTuristicoModel;
import br.fiap.com.Sprint.services.PontoTuristicoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pontoturistico")
public class PontoTuristicoController {

	final PontoTuristicoService pontoTuristicoService;

	
	public PontoTuristicoController(PontoTuristicoService pontoTuristicoService) {
		this.pontoTuristicoService = pontoTuristicoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> savePontoTuristico(@RequestBody @Valid PontoTuristicoDto pontoTuristicoDto) {
		
		var PontoTuristicoModel = new PontoTuristicoModel();
		BeanUtils.copyProperties(pontoTuristicoDto, PontoTuristicoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(pontoTuristicoService.save(PontoTuristicoModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<PontoTuristicoModel>> getAllPontoTuristico() {
		return ResponseEntity.status(HttpStatus.OK).body(pontoTuristicoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePontoTuristico(@PathVariable(value = "id") long id){
		Optional<PontoTuristicoModel> PontoTuristicoModelOptional = pontoTuristicoService.findById(id);
		if (!PontoTuristicoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(PontoTuristicoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePontoTuristico(@PathVariable(value="id") long id) {
		Optional<PontoTuristicoModel> pontoTuristicoModelOptional = pontoTuristicoService.findById(id);
		if(!pontoTuristicoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PontoTuristico not Found");
		}
		pontoTuristicoService.delete(pontoTuristicoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("PontoTuristico deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePontoTuristico(@PathVariable(value = "id") long id,
												@RequestBody @Valid PontoTuristicoDto pontoTuristicoDto){
		Optional<PontoTuristicoModel> pontoTuristicoModelOptional = pontoTuristicoService.findById(id);
		if(!pontoTuristicoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PontoTuristico not Found");
		}
		var pontoTuristicoModel = new PontoTuristicoModel();		
		BeanUtils.copyProperties(pontoTuristicoDto, pontoTuristicoModel);
		pontoTuristicoModel.setCd_pt_turistico(pontoTuristicoModelOptional.get().getCd_pt_turistico());
		return ResponseEntity.status(HttpStatus.OK).body(pontoTuristicoService.save(pontoTuristicoModel));
		
		
	}
	
}