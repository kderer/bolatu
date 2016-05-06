package com.bolatu.service.impl.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.model.Message;
import com.bolatu.db.impl.model.MessageImpl;
import com.bolatu.service.api.request.ServiceRequestInfo;
import com.bolatu.service.api.request.message.DeleteInboxMessageRequest;
import com.bolatu.service.api.request.message.DeleteSentMessageRequest;
import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.api.request.message.SendMessageRequest;
import com.bolatu.service.api.response.message.ReadMessageResponse;
import com.bolatu.service.api.response.message.SendMessageResponse;
import com.bolatu.service.api.service.MessageService;
import com.bolatu.service.impl.request.ServiceRequestInfoImpl;
import com.bolatu.service.impl.request.message.DeleteInboxMessageRequestImpl;
import com.bolatu.service.impl.request.message.DeleteSentMessageRequestImpl;
import com.bolatu.service.impl.request.message.ReadMessageRequestImpl;
import com.bolatu.service.impl.request.message.SendMessageRequestImpl;
import com.bolatu.util.enumaration.YesNo;

public class MessageServiceTest extends BaseTestConfig {
	
	@Autowired
	private MessageService messageService;
	
	@Test
	public void testSendMessage() {
		Message message = new MessageImpl("kadir", "deniz", "aq", "am got meme");
		
		SendMessageRequest request = new SendMessageRequestImpl(message);
		
		SendMessageResponse response = messageService.sendMessage(request);
		
		Assert.assertNotNull(response.getMessage());
	}
	
	
	@Test
	public void testReadMessage() {
		ReadMessageRequest readMessageRequest = new ReadMessageRequestImpl();
		readMessageRequest.setMessageId("asdasd");
		
		ReadMessageResponse response = messageService.readMessage(readMessageRequest);
		
		Assert.assertNotNull(response.getMessage());		
	}
	
	@Test
	public void deleteInboxMessageTest() {
		ServiceRequestInfo sri = new ServiceRequestInfoImpl();
		sri.setUsername("abazadeniz");
		
		DeleteInboxMessageRequest request = new DeleteInboxMessageRequestImpl();
		request.setMessageId("5641f6f4c27b66f810c0cd5d");
		request.setServiceRequestInfo(sri);
		
		messageService.deleteInboxMessage(request);
		
		ReadMessageRequest readMessageRequest = new ReadMessageRequestImpl();
		readMessageRequest.setMessageId("5641f6f4c27b66f810c0cd5d");
		
		char deleted = messageService.readMessage(readMessageRequest).getMessage().getDeletedFromInbox();
		
		Assert.assertEquals(YesNo.YES.getCode(), deleted);
	}
	
	@Test
	public void deleteSentMessageTest() {
		ServiceRequestInfo sri = new ServiceRequestInfoImpl();
		sri.setUsername("abaza31");
		
		DeleteSentMessageRequest request = new DeleteSentMessageRequestImpl();
		request.setMessageId("5641f6f4c27b66f810c0cd5d");
		request.setServiceRequestInfo(sri);
		
		messageService.deleteSentMessage(request);
		
		ReadMessageRequest readMessageRequest = new ReadMessageRequestImpl();
		readMessageRequest.setMessageId("5641f6f4c27b66f810c0cd5d");
		
		char deleted = messageService.readMessage(readMessageRequest).getMessage().getDeletedFromSent();
		
		Assert.assertEquals(YesNo.YES.getCode(), deleted);
	}
	
	

}
