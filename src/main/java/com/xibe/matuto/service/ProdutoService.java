package com.xibe.matuto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xibe.matuto.domain.Produto;
import com.xibe.matuto.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> findById(Long id){
		return produtoRepository.findById(id);
	}
}
