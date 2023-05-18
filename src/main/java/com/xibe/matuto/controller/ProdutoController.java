package com.xibe.matuto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xibe.matuto.domain.Produto;
import com.xibe.matuto.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		return  ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN','OPERADOR')")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto produto = service.findById(id);
		return  ResponseEntity.ok(produto);
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> insert(@RequestBody Produto produto){
		produto = service.insert(produto);
		   URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				   .path("/{id}").buildAndExpand(produto.getId()).toUri();
		   return ResponseEntity.created(uri).build();	
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
	   return ResponseEntity.noContent().build();	
	}
	
}
