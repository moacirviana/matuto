package com.xibe.matuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xibe.matuto.repositories.UsuarioRepository;

@Service
public class AutheticationService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepo.findByEmail(username);
	}

}
