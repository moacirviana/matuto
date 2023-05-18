package com.xibe.matuto.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.xibe.matuto.domain.Usuario;

@Service
public class TokenService {
	
	private String secret = "Minh@CHAv3S3cret@";
	
	public String gerarToken(Usuario usuario) {
		return JWT.create()
				.withIssuer("Produtos")
				.withSubject(usuario.getEmail())
				.withClaim("id", usuario.getId())
				.withExpiresAt(LocalDateTime.now()
						.plusSeconds(120)
						.toInstant(ZoneOffset.of("-04:00"))
				 ).sign(Algorithm.HMAC512(secret));
				 
						
	}

	public String getSubject(String token) {
		try {
			return JWT.require(Algorithm.HMAC512(secret))
					.withIssuer("Produtos")
					.build().verify(token).getSubject();	
		} catch (TokenExpiredException e) {
			 throw new TokenExpiredException("Token JWT inválido ou expirado!", Instant.now());
		}		
		
	}
}
