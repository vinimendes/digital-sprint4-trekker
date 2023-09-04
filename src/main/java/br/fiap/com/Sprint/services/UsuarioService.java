package br.fiap.com.Sprint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.fiap.com.Sprint.models.UsuarioModel;
import br.fiap.com.Sprint.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	
	@Transactional
	public UsuarioModel save(UsuarioModel usuarioModel) {
		
		return usuarioRepository.save(usuarioModel);
		
	}
	
	public List<UsuarioModel> findAll() {
		
		return usuarioRepository.findAll();
		
	}


	public Optional<UsuarioModel> findById(long id) {

		return usuarioRepository.findById(id);
		
	}

	@Transactional
	public void delete(UsuarioModel usuarioModel) {
		
		usuarioRepository.delete(usuarioModel);
	}
	
}