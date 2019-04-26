package com.pedrodantas.cursomc.services;



import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.pedrodantas.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {
	
	@Autowired
	private TemplateEngine engine;
	
	@Autowired
	private JavaMailSender jms;

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
	
	protected String htmlFromTemplatePedido(Pedido obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		return engine.process("email/confirmacaoPedido", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		try {
		MimeMessage mm = preparedMimeMessageFromPedido(obj);
		sendHtmlEmail(mm);	
		}catch(MessagingException E) {
			sendOrderConfirmationEmail(obj);
		}
	}

	private MimeMessage preparedMimeMessageFromPedido(Pedido obj) throws MessagingException {
		MimeMessage mimeMessage = jms.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage,true);
		mmh.setTo(obj.getCliente().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Pedido confirmado : " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj), true);
		return mimeMessage;
	}
}
