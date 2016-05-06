package com.bolatu.web.mobile.managed.action;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.service.request.message.DeleteSentMessageRequestImpl;
import com.bolatu.rest.client.service.request.message.ReadMessageRequestImpl;
import com.bolatu.service.api.request.message.DeleteSentMessageRequest;
import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.api.response.message.DeleteSentMessageResponse;
import com.bolatu.service.api.response.message.ReadMessageResponse;
import com.bolatu.service.api.service.MessageService;
import com.bolatu.util.constant.BolatuServiceReturnCodes;
import com.bolatu.util.enumaration.MessageStatus;
import com.bolatu.web.mobile.lazydata.LazySentboxFetcher;

@Component
@ManagedBean(name="sentboxAction")
@Scope("view")
public class SentboxAction extends BaseAction {

	@Autowired
	private MessageService messageService;
	
	private LazySentboxFetcher lazySentboxFetcher;
	
	private Message messageToDelete; 
	
	@PostConstruct
	public void init() {
		lazySentboxFetcher = new LazySentboxFetcher(messageService, sessionBean.getLoggedInUsername());	
	}	
	
	public String readMessage() {
		Message selecetedMessage = sessionBean.getSelectedSentMessage();
		
		if (selecetedMessage.getStatus() != MessageStatus.READ.getCode()) {
			ReadMessageRequest readMessageRequest = new ReadMessageRequestImpl();
			readMessageRequest.setMessageId(selecetedMessage.getId());
			ReadMessageResponse response = messageService.readMessage(readMessageRequest);
			
			if (BolatuServiceReturnCodes.SUCCESS.equals(response.getResultCode())) {
				selecetedMessage.setStatus(MessageStatus.READ.getCode());
			}
		}
		
		return "/message/sentbox/message.xhtml";
	}
	
	public void deleteMessage() {
		DeleteSentMessageRequest request = new DeleteSentMessageRequestImpl();
		request.setMessageId(messageToDelete.getId());
		
		DeleteSentMessageResponse response = messageService.deleteSentMessage(request);
		prepareResult(response, false, null);		
	}
	
	public void deleteReadMessage() {
		DeleteSentMessageRequest request = new DeleteSentMessageRequestImpl();
		request.setMessageId(messageToDelete.getId());
		
		DeleteSentMessageResponse response = messageService.deleteSentMessage(request);
		prepareResult(response, true, "/message/sentbox/list.xhtml");
	}

	public LazySentboxFetcher getLazySentboxFetcher() {
		return lazySentboxFetcher;
	}

	public Message getMessageToDelete() {
		return messageToDelete;
	}

	public void setMessageToDelete(Message messageToDelete) {
		this.messageToDelete = messageToDelete;
	}
	
}
