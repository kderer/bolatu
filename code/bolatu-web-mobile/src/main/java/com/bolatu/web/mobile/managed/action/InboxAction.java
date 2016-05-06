package com.bolatu.web.mobile.managed.action;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.service.request.message.DeleteInboxMessageRequestImpl;
import com.bolatu.rest.client.service.request.message.ReadMessageRequestImpl;
import com.bolatu.service.api.request.message.DeleteInboxMessageRequest;
import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.api.response.message.DeleteInboxMessageResponse;
import com.bolatu.service.api.response.message.ReadMessageResponse;
import com.bolatu.service.api.service.MessageService;
import com.bolatu.util.constant.BolatuServiceReturnCodes;
import com.bolatu.util.enumaration.MessageStatus;
import com.bolatu.web.mobile.lazydata.LazyInboxFetcher;

@Component
@ManagedBean(name="inboxAction")
@Scope("view")
public class InboxAction extends BaseAction {

	@Autowired
	private MessageService messageService;
	
	private LazyInboxFetcher lazyInboxFetcher;
	
	private Message messageToDelete; 
	
	@PostConstruct
	public void init() {
		lazyInboxFetcher = new LazyInboxFetcher(messageService, sessionBean.getLoggedInUsername());	
	}	
	
	public String doReadAction() {
		if (sessionBean.getSelectedMessage().getStatus() != MessageStatus.READ.getCode()) {
			ReadMessageRequest readMessageRequest = new ReadMessageRequestImpl();
			readMessageRequest.setMessageId(sessionBean.getSelectedMessage().getId());
			ReadMessageResponse response = messageService.readMessage(readMessageRequest);
			
			if (BolatuServiceReturnCodes.SUCCESS.equals(response.getResultCode())) {
				sessionBean.getSelectedMessage().setStatus(MessageStatus.READ.getCode());
			}
		}
		
		return "/message/inbox/message.xhtml";
	}
	
	public void deleteMessage() {
		DeleteInboxMessageRequest request = new DeleteInboxMessageRequestImpl();
		request.setMessageId(messageToDelete.getId());
		
		DeleteInboxMessageResponse response = messageService.deleteInboxMessage(request);
		prepareResult(response, false, null);		
	}
	
	public void deleteReadMessage() {
		DeleteInboxMessageRequest request = new DeleteInboxMessageRequestImpl();
		request.setMessageId(messageToDelete.getId());
		
		DeleteInboxMessageResponse response = messageService.deleteInboxMessage(request);
		prepareResult(response, true, "/message/inbox/list.xhtml");		
	}

	public LazyInboxFetcher getLazyInboxFetcher() {
		return lazyInboxFetcher;
	}
	
	public Message getMessageToDelete() {
		return messageToDelete;
	}

	public void setMessageToDelete(Message messageToDelete) {
		this.messageToDelete = messageToDelete;
	}
}
