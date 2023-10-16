package com.xibe.matuto.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class AppController {
	
	@GetMapping
	public ResponseEntity<StandardError> home(HttpServletRequest request){
    	StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.OK.value(), "Nenhum", "Bem vindo, projeto spring demo", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.OK).body(err);    	
    }
	
}
