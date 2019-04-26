package com.pedrodantas.cursomc.domain.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedrodantas.cursomc.services.DbService;
import com.pedrodantas.cursomc.services.EmailService;
import com.pedrodantas.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DbService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		if(!"create".equals(strategy)) {
			return false;
		}
		dbService.instantiateTestDataBase();	
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
