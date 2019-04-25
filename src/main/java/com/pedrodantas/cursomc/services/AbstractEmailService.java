package com.pedrodantas.cursomc.services;



import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.pedrodantas.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {

	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = preparedSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}
	
	@Value("{default.sender}")
	private String sender;

	protected SimpleMailMessage preparedSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm =  new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! código:"+obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	
}
