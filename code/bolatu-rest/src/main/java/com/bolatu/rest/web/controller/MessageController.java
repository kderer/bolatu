package com.bolatu.rest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolatu.service.api.response.message.DeleteInboxMessageResponse;
import com.bolatu.service.api.response.message.DeleteSentMessageResponse;
import com.bolatu.service.api.response.message.QueryInboxResponse;
import com.bolatu.service.api.response.message.QuerySentboxResponse;
import com.bolatu.service.api.response.message.ReadMessageResponse;
import com.bolatu.service.api.response.message.SendMessageResponse;
import com.bolatu.service.api.service.MessageService;
import com.bolatu.service.impl.request.message.DeleteInboxMessageRequestImpl;
import com.bolatu.service.impl.request.message.DeleteSentMessageRequestImpl;
import com.bolatu.service.impl.request.message.QueryInboxRequestImpl;
import com.bolatu.service.impl.request.message.QuerySentboxRequestImpl;
import com.bolatu.service.impl.request.message.ReadMessageRequestImpl;
import com.bolatu.service.impl.request.message.SendMessageRequestImpl;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public SendMessageResponse sendMessage(@RequestBody SendMessageRequestImpl sendMessageRequest) {
		
		return messageService.sendMessage(sendMessageRequest);	
		
	}
	
	@RequestMapping(value = "/inbox", method = RequestMethod.POST)
	public QueryInboxResponse queryInbox(@RequestBody QueryInboxRequestImpl queryInboxRequest) {
		
		return messageService.queryInbox(queryInboxRequest);	
		
	}
	
	@RequestMapping(value = "/sentbox", method = RequestMethod.POST)
	public QuerySentboxResponse queryInbox(@RequestBody QuerySentboxRequestImpl querySentboxRequest) {
		
		return messageService.querySentbox(querySentboxRequest);	
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public ReadMessageResponse queryInbox(@RequestBody ReadMessageRequestImpl readMessageRequest) {
		
		return messageService.readMessage(readMessageRequest);	
		
	}
	
	@RequestMapping(value = "/deleteInboxMessage", method = RequestMethod.POST)
	public DeleteInboxMessageResponse deleteFromInbox(@RequestBody DeleteInboxMessageRequestImpl deleteInboxMessageRequest) {
		
		return messageService.deleteInboxMessage(deleteInboxMessageRequest);	
		
	}
	
	@RequestMapping(value = "/deleteSentMessage", method = RequestMethod.POST)
	public DeleteSentMessageResponse deleteFromSent(@RequestBody DeleteSentMessageRequestImpl deleteSentMessageRequest) {
		
		return messageService.deleteSentMessage(deleteSentMessageRequest);	
		
	}

}
