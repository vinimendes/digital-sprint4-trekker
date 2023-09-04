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

import br.fiap.com.Sprint.dtos.UsuarioDto;
import br.fiap.com.Sprint.models.UsuarioModel;
import br.fiap.com.Sprint.services.UsuarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	final UsuarioService usuarioService;

	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
		
		var UsuarioModel = new UsuarioModel();
		BeanUtils.copyProperties(usuarioDto, UsuarioModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(UsuarioModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> getAllUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") long id){
		Optional<UsuarioModel> UsuarioModelOptional = usuarioService.findById(id);
		if (!UsuarioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(UsuarioModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable(value="id") long id) {
		Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
		if(!usuarioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not Found");
		}
		usuarioService.delete(usuarioModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Usuario deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") long id,
												@RequestBody @Valid UsuarioDto usuarioDto){
		Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
		if(!usuarioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not Found");
		}
		var usuarioModel = new UsuarioModel();		
		BeanUtils.copyProperties(usuarioDto, usuarioModel);
		usuarioModel.setCd_usuario(usuarioModelOptional.get().getCd_usuario());
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuarioModel));
		
		
	}
	
}