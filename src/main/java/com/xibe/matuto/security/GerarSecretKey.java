package com.xibe.matuto.security;

import java.security.SecureRandom;
import java.util.Base64;

public class GerarSecretKey {

	public static void main(String[] args) {
		int keySize = 64;

	    // Crie um array de bytes com o tamanho especificado
	    byte[] keyBytes = new byte[keySize];

	    // Gere bytes aleatórios usando um gerador seguro
	    SecureRandom secureRandom = new SecureRandom();
	    secureRandom.nextBytes(keyBytes);

	    // Converta os bytes em uma string base64
	    String secretKey = Base64.getEncoder().encodeToString(keyBytes);
	    System.out.println(secretKey);

	}

}
