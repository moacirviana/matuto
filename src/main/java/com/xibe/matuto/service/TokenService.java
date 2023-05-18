package com.xibe.matuto.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xibe.matuto.domain.Usuario;

@Service
public class TokenService {
	public String gerarToken(Usuario usuario) {
		return JWT.create()
				.withIssuer("Produtos")
				.withSubject(usuario.getEmail())
				.withClaim("id", usuario.getId())
				.withExpiresAt(LocalDateTime.now()
						.plusMinutes(10)
						.toInstant(ZoneOffset.of("-04:00"))
				 ).sign(Algorithm.HMAC512("secret"));
				 
						
	}
}
