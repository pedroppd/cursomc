package com.pedrodantas.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.pedrodantas.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
