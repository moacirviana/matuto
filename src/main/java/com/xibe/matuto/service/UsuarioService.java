package com.xibe.matuto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xibe.matuto.domain.Usuario;
import com.xibe.matuto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepo;;
	
	public List<Usuario> findAll(){
		return usuarioRepo.findAll();
	}
	
	public Optional<Usuario> findById(Long id) {
		return usuarioRepo.findById(id);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepo.findByEmail(email);
	}
}
