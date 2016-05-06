package com.bolatu.util.test;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.util.email.Email;
import com.bolatu.util.email.EmailWithTemplate;
import com.bolatu.util.email.MailSendService;
import com.bolatu.util.enumaration.MailTemplate;

public class MailSendServiceTest extends BaseTestConfig {
	
	@Autowired
	private MailSendService mailSendService;
	
	@Test
	public void testSendEmail() {
		
		Email email = new Email();
		email.addToToList("kderer@hotmail.com");
		email.setFrom("kderer@hotmail.com");
		email.setSubject("Bolatu Test Email");
		email.setBody("Body body body");
		
		mailSendService.sendMail(email);
	}
	
	@Test
	public void testSendEmailWithTemplate() {
		
		EmailWithTemplate email = new EmailWithTemplate();
		email.addToToList("kderer@hotmail.com");
		email.setFrom("kderer@hotmail.com");
		email.setSubject("Bolatu Test Email");
		email.setTemplate(MailTemplate.SIGNUP);
		email.addAttachment(new File("C:\\d2f42068.ini"));
		email.getDataMap().put("username", "abaza31");
		email.getDataMap().put("signupConfirmationParameters", "mail=kderer@hotmail.com&"
				+ "hash=316931693169316931693169316931693169");		
		
		mailSendService.sendMailWithTemplate(email);
	}
	
	
	

}
