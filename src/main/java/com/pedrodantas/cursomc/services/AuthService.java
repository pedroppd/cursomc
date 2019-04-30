package com.pedrodantas.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pedrodantas.cursomc.domain.Cliente;
import com.pedrodantas.cursomc.repositories.ClienteRepository;
import com.pedrodantas.cursomc.services.exception.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService es;
	
	private Random rand = new Random();
	 public void sendNewPassword(String email) {
		 Cliente cliente = clienteRepository.findByEmail(email);
		 
		 if(cliente == null) {
			 throw new ObjectNotFoundException("E-mail não encontrado :(");
		 }
		 
		 String newpass = newPassword();
		 cliente.setSenha(pe.encode(newpass));
	 
		 clienteRepository.save(cliente);
		 es.sendNewPasswordEmail(cliente, newpass);
	 }

	 
	 
	private String newPassword() {
		char[] vet = new char[10];
		for(int i=0; i<0; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}



	private char randomChar() {
		int opt = rand.nextInt(3);
		
		if(opt == 0) { //Gera um digito
			return (char) (rand.nextInt(10) + 48);
		}else if(opt==1) {//Gera leta maiúscula
			return (char) (rand.nextInt(26) + 65);
		}else {             //Gera letra minúscula
			return (char) (rand.nextInt(26) + 97);
		}
		
	}
	 
}
