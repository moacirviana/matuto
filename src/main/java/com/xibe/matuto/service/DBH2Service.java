package com.xibe.matuto.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xibe.matuto.domain.Produto;
import com.xibe.matuto.domain.Usuario;
import com.xibe.matuto.domain.enums.Perfil;
import com.xibe.matuto.repositories.ProdutoRepository;
import com.xibe.matuto.repositories.UsuarioRepository;

@Service
public class DBH2Service {
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDatabase() throws ParseException {
	
		Produto p1 = new Produto();
		p1.setDescricao("Frango Crispy");
		p1.setValor(BigDecimal.valueOf(40.40));
		p1.setTitulo("frango");
		Produto p2 = new Produto();
		p2.setDescricao("Vaca atolada 1 Pessoa");
		p2.setValor(BigDecimal.valueOf(45.50));
		p2.setTitulo("carne");
		Produto p3 = new Produto();
		p3.setDescricao("Picanha na Brasa 2 Pessoas");
		p3.setValor(BigDecimal.valueOf(112.99));
		p3.setTitulo("carne");
		Produto p4 = new Produto();
		p4.setDescricao("Tambaqui Assado 3 pessoas");
		p4.setValor(BigDecimal.valueOf(46.50));
		p4.setTitulo("peixe");
		Produto p5 = new Produto();
		p5.setDescricao("Agua 350ml");
		p5.setValor(BigDecimal.valueOf(58.50));
		p5.setTitulo("bebida");
		Produto p6 = new Produto();
		p6.setDescricao("Cerveja 600ml");
		p6.setValor(BigDecimal.valueOf(63.50));
		p6.setTitulo("bebida");
		Produto p7 = new Produto();
		p7.setDescricao("Suco Graviola Jarra 1L");
		p7.setValor(BigDecimal.valueOf(15.00));
		p7.setTitulo("bebida");
		Produto p8 = new Produto();
		p8.setDescricao("Creme de cupuacu com chocolate");
		p8.setValor(BigDecimal.valueOf(6.40));
		p8.setTitulo("sobremesa");
		produtoRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
		
		
		Usuario u = new Usuario();
		u.setEmail("user1@company.com");
		u.setNome("User01");
		u.setAtivo(1);
		u.addPerfil(Perfil.OPERADOR);
		u.setSenha(pe.encode("123456"));
		Usuario u2 = new Usuario();
		u2.setEmail("admin@company.com");
		u2.setNome("Admin");
		u2.addPerfil(Perfil.ADMIN);
		u2.setAtivo(1);
		u2.setSenha(pe.encode("12345678"));
		usuarioRepo.saveAll(Arrays.asList(u, u2));
		
		
	}
}
