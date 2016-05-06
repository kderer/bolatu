package com.bolatu.web.mobile.managed.action;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.model.MessageImpl;
import com.bolatu.rest.client.service.request.message.SendMessageRequestImpl;
import com.bolatu.rest.client.service.service.MessageServiceClient;
import com.bolatu.service.api.request.message.SendMessageRequest;
import com.bolatu.service.api.response.message.SendMessageResponse;
import com.bolatu.web.mobile.managed.SessionBean;

@Component
@ManagedBean(name="messageAction")
@Scope("request")
public class MessageAction extends BaseAction {

	@Autowired
	private MessageServiceClient messageServiceClient;
	
	@Autowired
	private SessionBean sessionBean;
	
	private Message message = new MessageImpl();	
	
	public String doReplyInitAction() {
		message.setSender(sessionBean.getSelectedMessage().getReceiver());
		message.setReceiver(sessionBean.getSelectedMessage().getSender());
		message.setTitle(getI18NText("label.inboxmessage.replyPrefix") + 
				sessionBean.getSelectedMessage().getTitle());
		message.setParentId(sessionBean.getSelectedMessage().getId());
		
		return "/message/send.xhtml";
	}
	
	public void doSendMessageAction() {
		
		message.setSender(sessionBean.getLoggedInUsername());
		
		SendMessageRequest sendMessageRequest = new SendMessageRequestImpl(message);
		SendMessageResponse response = messageServiceClient.sendMessage(sendMessageRequest);
		
		prepareResult(response, true, "/message/sentbox/list.xhtml");		
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(MessageImpl message) {
		this.message = message;
	}
	
}
