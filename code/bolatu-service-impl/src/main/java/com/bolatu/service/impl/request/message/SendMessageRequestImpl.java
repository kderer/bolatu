package com.bolatu.service.impl.request.message;

import com.bolatu.db.api.model.Message;
import com.bolatu.db.impl.model.MessageImpl;
import com.bolatu.service.api.request.message.SendMessageRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class SendMessageRequestImpl extends BaseServiceRequestImpl implements SendMessageRequest {

	private MessageImpl message;
	
	public SendMessageRequestImpl() {
		
	}
	
	public SendMessageRequestImpl(Message message) {
		this.message = (MessageImpl) message;
	}
	
	@Override
	@JsonDeserialize(as = MessageImpl.class)
	public void setMessage(Message message) {
		this.message = (MessageImpl)message;
	}

	@Override
	public Message getMessage() {
		return message;
	}
	
}
