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

import br.fiap.com.Sprint.dtos.RuaDto;
import br.fiap.com.Sprint.models.RuaModel;
import br.fiap.com.Sprint.services.RuaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/rua")
public class RuaController {

	final RuaService ruaService;

	
	public RuaController(RuaService ruaService) {
		this.ruaService = ruaService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveRua(@RequestBody @Valid RuaDto ruaDto) {
		
		var RuaModel = new RuaModel();
		BeanUtils.copyProperties(ruaDto, RuaModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(ruaService.save(RuaModel));
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<RuaModel>> getAllRua() {
		return ResponseEntity.status(HttpStatus.OK).body(ruaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneRua(@PathVariable(value = "id") long id){
		Optional<RuaModel> RuaModelOptional = ruaService.findById(id);
		if (!RuaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(RuaModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRua(@PathVariable(value="id") long id) {
		Optional<RuaModel> ruaModelOptional = ruaService.findById(id);
		if(!ruaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rua not Found");
		}
		ruaService.delete(ruaModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Rua deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateRua(@PathVariable(value = "id") long id,
												@RequestBody @Valid RuaDto ruaDto){
		Optional<RuaModel> ruaModelOptional = ruaService.findById(id);
		if(!ruaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rua not Found");
		}
		var ruaModel = new RuaModel();		
		BeanUtils.copyProperties(ruaDto, ruaModel);
		ruaModel.setCd_rua(ruaModelOptional.get().getCd_rua());
		return ResponseEntity.status(HttpStatus.OK).body(ruaService.save(ruaModel));
		
		
	}
	
}