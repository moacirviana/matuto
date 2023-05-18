package com.xibe.matuto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xibe.matuto.domain.Usuario;
import com.xibe.matuto.domain.dto.Login;
import com.xibe.matuto.security.TokenService;
import com.xibe.matuto.security.UserService;

@RestController
public class AuthController {
	
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Autowired
  TokenService tokenService;
  

  @PostMapping("/login")
  public String login(@RequestBody Login login) {
	  UsernamePasswordAuthenticationToken usernamePassword = 
			  new UsernamePasswordAuthenticationToken(login.getLogin(), login.getSenha());
	  Authentication authentication = authenticationManager.authenticate(usernamePassword);
	  var usuario = (Usuario)authentication.getPrincipal();
	  return tokenService.gerarToken(usuario);
  }
  
  @PostMapping("/logout")
  public ResponseEntity<String> logout(HttpServletRequest request) {
      request.getSession().invalidate();
      return ResponseEntity.ok("Logout realizado com sucesso");
  }
  
  @PostMapping("/refresh_token")
  public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
	  Usuario usuario = UserService.authenticated();
	  System.out.println(usuario.toString());
	  String newToken = tokenService.gerarToken(usuario);
	  response.addHeader("Authorization", "Bearer " + newToken);
	  return ResponseEntity.noContent().build();
  }
  
}
