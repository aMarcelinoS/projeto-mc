package com.alexandre.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alexandre.cursomc.services.DBService;
import com.alexandre.cursomc.services.EmailService;
import com.alexandre.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}	
	
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	
	//Retorna uma instância de SmtpEmailService
//	@Bean
//	public EmailService mailService() {
//		return new SmtpEmailService();
//	}
}
