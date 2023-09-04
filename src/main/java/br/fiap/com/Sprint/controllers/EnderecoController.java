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

import br.fiap.com.Sprint.dtos.EnderecoDto;
import br.fiap.com.Sprint.models.EnderecoModel;
import br.fiap.com.Sprint.services.EnderecoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	final EnderecoService enderecoService;

	
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveEndereco(@RequestBody @Valid EnderecoDto enderecoDto) {
		
		var EnderecoModel = new EnderecoModel();
		BeanUtils.copyProperties(enderecoDto, EnderecoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(EnderecoModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<EnderecoModel>> getAllEndereco() {
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneEndereco(@PathVariable(value = "id") long id){
		Optional<EnderecoModel> EnderecoModelOptional = enderecoService.findById(id);
		if (!EnderecoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(EnderecoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEndereco(@PathVariable(value="id") long id) {
		Optional<EnderecoModel> enderecoModelOptional = enderecoService.findById(id);
		if(!enderecoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco not Found");
		}
		enderecoService.delete(enderecoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Endereco deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEndereco(@PathVariable(value = "id") long id,
												@RequestBody @Valid EnderecoDto enderecoDto){
		Optional<EnderecoModel> enderecoModelOptional = enderecoService.findById(id);
		if(!enderecoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco not Found");
		}
		var enderecoModel = new EnderecoModel();		
		BeanUtils.copyProperties(enderecoDto, enderecoModel);
		enderecoModel.setCd_endereco(enderecoModelOptional.get().getCd_endereco());
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(enderecoModel));
		
		
	}
	
}