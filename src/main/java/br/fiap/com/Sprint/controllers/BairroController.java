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

import br.fiap.com.Sprint.dtos.BairroDto;
import br.fiap.com.Sprint.services.BairroService;
import jakarta.validation.Valid;
import br.fiap.com.Sprint.models.BairroModel;


@Controller
@RequestMapping("/bairro")
public class BairroController {

	final BairroService bairroService;
	
	
	public BairroController(BairroService bairroService) {
		this.bairroService = bairroService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveBairro(@RequestBody @Valid BairroDto bairrodto) {
		var BairroModel = new BairroModel();
		BeanUtils.copyProperties(bairrodto, BairroModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroService.save(BairroModel));	
	}
	
	
	@GetMapping
	public ResponseEntity<List<BairroModel>> getAllBairro() {
		return ResponseEntity.status(HttpStatus.OK).body(bairroService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneBairro(@PathVariable(value = "id") long id){
		Optional<BairroModel> BairroModelOptional = bairroService.findById(id);
		if (!BairroModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(BairroModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBairro(@PathVariable(value="id") long id) {
		Optional<BairroModel> bairroModelOptional = bairroService.findById(id);
		if(!bairroModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bairro not Found");
		}
		bairroService.delete(bairroModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Bairro deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBairro(@PathVariable(value = "id") long id,
												@RequestBody @Valid BairroDto bairroDto){
		Optional<BairroModel> bairroModelOptional = bairroService.findById(id);
		if(!bairroModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bairro not Found");
		}
		var bairroModel = new BairroModel();		
		BeanUtils.copyProperties(bairroDto, bairroModel);
		bairroModel.setCd_bairro(bairroModelOptional.get().getCd_bairro());
		return ResponseEntity.status(HttpStatus.OK).body(bairroService.save(bairroModel));
		
		
	}
	
}
