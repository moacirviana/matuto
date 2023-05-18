package com.xibe.matuto.service.exceptions;

public class TokenExpiredException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TokenExpiredException (String msg) {
		super(msg);
	}
	
	public TokenExpiredException(String msg, Throwable cause) {
		super (msg, cause);
	}

}