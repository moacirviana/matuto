package com.xibe.matuto.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xibe.matuto.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	@Override
    List<Produto> findAll();
}
