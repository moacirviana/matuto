package com.xibe.matuto.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.xibe.matuto.service.DBH2Service;

@Configuration
@Profile("h2")
public class TestH2Config {
	@Autowired
	private DBH2Service dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		//dbService.instantiateTestDatabase();
		return true;
	}
}
