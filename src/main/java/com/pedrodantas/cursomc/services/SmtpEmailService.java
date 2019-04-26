package com.pedrodantas.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.pedrodantas.cursomc.domain.Pedido;

public class SmtpEmailService extends AbstractEmailService{

	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender jms;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("enviando e-mail...");
		mailSender.send(msg);
		LOG.info("E-mail enviado");
		
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("enviando e-mail html...");
		jms.send(msg);
		LOG.info("E-mail enviado");
	}

}
