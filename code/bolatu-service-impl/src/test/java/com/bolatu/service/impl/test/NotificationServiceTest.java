package com.bolatu.service.impl.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.model.SignupConfirmation;
import com.bolatu.db.impl.model.SignupConfirmationImpl;
import com.bolatu.service.api.service.NotificationService;

public class NotificationServiceTest extends BaseTestConfig {
	
	@Autowired
	private NotificationService notificationService;
	
	@Test
	public void testSendConfirmation() {
		SignupConfirmation confirmation = new SignupConfirmationImpl();		
		confirmation.setConfirmationCode("316931693169316931693169");
		confirmation.setUsername("abaza31");
		confirmation.setEmail("kderer@hotmail.com");
		
		notificationService.sendConfirmation(confirmation);
	}

}
