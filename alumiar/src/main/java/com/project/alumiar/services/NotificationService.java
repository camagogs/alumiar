package com.project.alumiar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.alumiar.models.NewsLetter;

@Service
public class NotificationService {
	
	@Autowired
	private NewsLetterService newsService;

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotificaitoin() throws MailException {
		// send email
		SimpleMailMessage mail = new SimpleMailMessage();
		
		Iterable<NewsLetter> emails = newsService.list();
		
		for (NewsLetter user : emails) {
			mail.setTo(user.getEmail());
			mail.setFrom("braulliosoares.bs@gmail.com");
			mail.setSubject("Alumiar! Hora de adotar ;)");
			mail.setText("Olá, tudo bem? Passando pra avisar que chegou mais um bixinho e está disponivel pra adoção. Obrigado");
			
			javaMailSender.send(mail);
		}
		
		
	}
	
}
