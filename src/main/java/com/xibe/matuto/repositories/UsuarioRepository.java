package com.xibe.matuto.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xibe.matuto.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	@Override
    List<Usuario> findAll();
	
	Usuario findByEmail(String email);
}
