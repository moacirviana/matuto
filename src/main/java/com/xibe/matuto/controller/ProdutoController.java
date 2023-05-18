package com.xibe.matuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		return  ResponseEntity.ok(service.findById(id).get());
	}
	
}
