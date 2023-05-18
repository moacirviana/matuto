package com.xibe.matuto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xibe.matuto.domain.Usuario;
import com.xibe.matuto.repositories.UsuarioRepository;
import com.xibe.matuto.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepo;
	
	public List<Usuario> findAll(){
		return usuarioRepo.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepo.findById(id); 
    	return obj.orElseThrow(() -> new ObjectNotFoundException( 
    		      "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));  
		
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepo.findByEmail(email);
	}
}
