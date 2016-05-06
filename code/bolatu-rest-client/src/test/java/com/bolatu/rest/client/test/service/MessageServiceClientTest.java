package com.bolatu.rest.client.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.model.MessageImpl;
import com.bolatu.rest.client.service.request.ServiceRequestInfoImpl;
import com.bolatu.rest.client.service.request.message.DeleteInboxMessageRequestImpl;
import com.bolatu.rest.client.service.request.message.DeleteSentMessageRequestImpl;
import com.bolatu.rest.client.service.request.message.QueryInboxRequestImpl;
import com.bolatu.rest.client.service.request.message.ReadMessageRequestImpl;
import com.bolatu.rest.client.service.request.message.SendMessageRequestImpl;
import com.bolatu.rest.client.test.BaseTestConfig;
import com.bolatu.service.api.request.ServiceRequestInfo;
import com.bolatu.service.api.request.message.DeleteInboxMessageRequest;
import com.bolatu.service.api.request.message.DeleteSentMessageRequest;
import com.bolatu.service.api.request.message.QueryInboxRequest;
import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.api.request.message.SendMessageRequest;
import com.bolatu.service.api.response.message.QueryInboxResponse;
import com.bolatu.service.api.response.message.ReadMessageResponse;
import com.bolatu.service.api.response.message.SendMessageResponse;
import com.bolatu.service.api.service.MessageService;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.MessageStatus;
import com.bolatu.util.enumaration.SortDirection;
import com.bolatu.util.enumaration.YesNo;
import com.fasterxml.jackson.core.JsonProcessingException;

public class MessageServiceClientTest extends BaseTestConfig {

	@Autowired
	private MessageService messageService;
	
	@Test
	public void sendMessageTest() {
		
		Message message = new MessageImpl("kadir", "deniz", "aaaammm", "am got memeee");
		
		
		SendMessageRequest request = new SendMessageRequestImpl(message);
		
		SendMessageResponse response = messageService.sendMessage(request);
		
		Assert.assertNotNull(response.getMessage().getContent());		
		
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void queryInboxTest() throws JsonProcessingException {
		QueryInboxRequest queryInboxRequest = new QueryInboxRequestImpl();
		queryInboxRequest.setUsername("abazadeniz");
		queryInboxRequest.addSortRequest(new SortRequest("sentDate", SortDirection.DESC));
		
		QueryInboxResponse queryInboxResponse = messageService.queryInbox(queryInboxRequest);		
		
		List<MessageImpl> messageList = (List<MessageImpl>) queryInboxResponse.getMessageList();		
		
		Assert.assertNotEquals(0, messageList.size());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void readMessageTest() {
		QueryInboxRequest queryInboxRequest = new QueryInboxRequestImpl();
		queryInboxRequest.setUsername("abazadeniz");
		queryInboxRequest.setStatus(MessageStatus.UNREAD.getCode());
		
		QueryInboxResponse queryInboxResponse = messageService.queryInbox(queryInboxRequest);		
		
		List<MessageImpl> messageList = (List<MessageImpl>) queryInboxResponse.getMessageList();
		
		String messageId = messageList.get(0).getId();
		
		ReadMessageRequest request = new ReadMessageRequestImpl();
		request.setMessageId(messageId);
		
		ReadMessageResponse response = messageService.readMessage(request);
		
		Assert.assertEquals(response.getMessage().getStatus(), MessageStatus.READ.getCode());	
	}
	
	@Test
	public void deleteInboxMessageTest() {
		ServiceRequestInfo sri = new ServiceRequestInfoImpl();
		sri.setUsername("abazadeniz");
		
		DeleteInboxMessageRequest request = new DeleteInboxMessageRequestImpl();
		request.setMessageId("56420c01c27bc126b5e27754");
		request.setServiceRequestInfo(sri);
		
		messageService.deleteInboxMessage(request);
		
		ReadMessageRequest readMessageRequest = new ReadMessageRequestImpl();
		readMessageRequest.setMessageId("56420c01c27bc126b5e27754");
		
		char deleted = messageService.readMessage(readMessageRequest).getMessage().getDeletedFromInbox();
		
		Assert.assertEquals(YesNo.YES.getCode(), deleted);
	}
	
	@Test
	public void deleteSentMessageTest() {
		ServiceRequestInfo sri = new ServiceRequestInfoImpl();
		sri.setUsername("abaza31");
		
		DeleteSentMessageRequest request = new DeleteSentMessageRequestImpl();
		request.setMessageId("56420c01c27bc126b5e27754");
		request.setServiceRequestInfo(sri);
		
		messageService.deleteSentMessage(request);
		
		ReadMessageRequest readMessageRequest = new ReadMessageRequestImpl();
		readMessageRequest.setMessageId("56420c01c27bc126b5e27754");
		
		char deleted = messageService.readMessage(readMessageRequest).getMessage().getDeletedFromSent();
		
		Assert.assertEquals(YesNo.YES.getCode(), deleted);
	}
}
