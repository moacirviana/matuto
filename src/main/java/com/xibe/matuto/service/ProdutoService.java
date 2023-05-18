package com.xibe.matuto.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.xibe.matuto.domain.Produto;
import com.xibe.matuto.repositories.ProdutoRepository;
import com.xibe.matuto.service.exceptions.DataIntegrityException;
import com.xibe.matuto.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id){
		Optional<Produto> obj = produtoRepository.findById(id); 
    	return obj.orElseThrow(() -> new ObjectNotFoundException( 
    		      "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));  
	}
	
	@Transactional
    public Produto insert(Produto obj) {
    	obj.setId(null);
    	obj = produtoRepository.save(obj);
   	   return obj;
    }
	
	public void delete(Long id) {
		Produto p = produtoRepository.findById(id).get();
    	try {
    		produtoRepository.delete(p);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma Cliente que possui pedidos cadastrados!");
		}
    }
}
