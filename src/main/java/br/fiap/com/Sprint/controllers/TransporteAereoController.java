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

import br.fiap.com.Sprint.dtos.TransporteAereoDto;
import br.fiap.com.Sprint.models.TransporteAereoModel;
import br.fiap.com.Sprint.services.TransporteAereoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/transporteaereo")
public class TransporteAereoController {

	final TransporteAereoService transporteAereoService;

	
	public TransporteAereoController(TransporteAereoService transporteAereoService) {
		this.transporteAereoService = transporteAereoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveTransporteAereo(@RequestBody @Valid TransporteAereoDto transporteAereoDto) {
		
		var TransporteAereoModel = new TransporteAereoModel();
		BeanUtils.copyProperties(transporteAereoDto, TransporteAereoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(transporteAereoService.save(TransporteAereoModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<TransporteAereoModel>> getAllTransporteAereo() {
		return ResponseEntity.status(HttpStatus.OK).body(transporteAereoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTransporteAereo(@PathVariable(value = "id") long id){
		Optional<TransporteAereoModel> TransporteAereoModelOptional = transporteAereoService.findById(id);
		if (!TransporteAereoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(TransporteAereoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTransporteAereo(@PathVariable(value="id") long id) {
		Optional<TransporteAereoModel> transporteAereoModelOptional = transporteAereoService.findById(id);
		if(!transporteAereoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TransporteAereo not Found");
		}
		transporteAereoService.delete(transporteAereoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("TransporteAereo deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTransporteAereo(@PathVariable(value = "id") long id,
												@RequestBody @Valid TransporteAereoDto transporteAereoDto){
		Optional<TransporteAereoModel> transporteAereoModelOptional = transporteAereoService.findById(id);
		if(!transporteAereoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TransporteAereo not Found");
		}
		var transporteAereoModel = new TransporteAereoModel();		
		BeanUtils.copyProperties(transporteAereoDto, transporteAereoModel);
		transporteAereoModel.setCd_transp_aereo(transporteAereoModelOptional.get().getCd_transp_aereo());
		return ResponseEntity.status(HttpStatus.OK).body(transporteAereoService.save(transporteAereoModel));
		
		
	}
	
}