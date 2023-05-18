package com.xibe.matuto.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xibe.matuto.domain.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	@Override
    List<Categoria> findAll();
}
