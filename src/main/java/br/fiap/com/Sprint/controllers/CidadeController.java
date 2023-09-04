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

import br.fiap.com.Sprint.dtos.CidadeDto;
import br.fiap.com.Sprint.services.CidadeService;
import br.fiap.com.Sprint.models.CidadeModel;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

	final CidadeService cidadeService;
	
	
	public CidadeController(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	@PostMapping()
	public ResponseEntity<Object> saveCidade(@RequestBody @Valid CidadeDto cidadeDto) {
		var CidadeModel = new CidadeModel();
		BeanUtils.copyProperties(cidadeDto, CidadeModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.save(CidadeModel));
	}
	
	@GetMapping
	public ResponseEntity<List<CidadeModel>> getAllCidade() {
		return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCidade(@PathVariable(value = "id") long id){
		Optional<CidadeModel> CidadeModelOptional = cidadeService.findById(id);
		if (!CidadeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(CidadeModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCidade(@PathVariable(value="id") long id) {
		Optional<CidadeModel> cidadeModelOptional = cidadeService.findById(id);
		if(!cidadeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade not Found");
		}
		cidadeService.delete(cidadeModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cidade deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCidade(@PathVariable(value = "id") long id,
												@RequestBody @Valid CidadeDto cidadeDto){
		Optional<CidadeModel> cidadeModelOptional = cidadeService.findById(id);
		if(!cidadeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade not Found");
		}
		var cidadeModel = new CidadeModel();		
		BeanUtils.copyProperties(cidadeDto, cidadeModel);
		cidadeModel.setCd_cidade(cidadeModelOptional.get().getCd_cidade());
		return ResponseEntity.status(HttpStatus.OK).body(cidadeService.save(cidadeModel));
		
		
	}
	
}
