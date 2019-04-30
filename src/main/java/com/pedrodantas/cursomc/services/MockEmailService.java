package com.pedrodantas.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.pedrodantas.cursomc.domain.Cliente;
import com.pedrodantas.cursomc.domain.Pedido;

public class MockEmailService extends AbstractEmailService{
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de e-mail...");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado");
		
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de e-mail html...");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado");
		
	}

	

}
