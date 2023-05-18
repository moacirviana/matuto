package com.xibe.matuto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xibe.matuto.domain.Usuario;
import com.xibe.matuto.domain.dto.Login;
import com.xibe.matuto.service.TokenService;

@RestController
public class AuthController {
	
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Autowired
  TokenService tokenService;
	
  @PostMapping("/login")
  public String login(@RequestBody Login login) {
	  UsernamePasswordAuthenticationToken usernamePassword = 
			  new UsernamePasswordAuthenticationToken(login.login(), login.senha());
	  Authentication authenticate = authenticationManager.authenticate(usernamePassword);
	  var usuario = (Usuario)authenticate.getPrincipal();
	  
	  return tokenService.gerarToken(usuario);
  }
  
}
