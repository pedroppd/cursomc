package com.pedrodantas.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class EmailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preechimento obrigatório!")
	@Email(message = "E-mail inválido")
	private String email;
	
	
	
	private EmailDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
