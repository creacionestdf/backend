package com.porfolio.backend.security.service;

import com.porfolio.backend.security.entity.Usuario;
import com.porfolio.backend.security.repository.iUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	iUsuarioRepository iusuarioRepository;
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
		return iusuarioRepository.findByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByEmail(String email) {
		return iusuarioRepository.existsByEmail(email);
	}
	
	public void save(Usuario usuario) {	iusuarioRepository.save(usuario); }
}
