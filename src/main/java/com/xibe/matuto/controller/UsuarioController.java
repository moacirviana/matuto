package com.xibe.matuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xibe.matuto.domain.Usuario;
import com.xibe.matuto.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		return  ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		return  ResponseEntity.ok(service.findById(id).get());
	}
	
	
}
