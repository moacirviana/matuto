package com.xibe.matuto.security;

import org.springframework.security.core.context.SecurityContextHolder;

import com.xibe.matuto.domain.Usuario;

public class UserService {
	public static Usuario authenticated() {
		try {
			//System.out.println("UserSErvice  ==>> " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
			return (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
