package com.bolatu.rest.client.service.request.message;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.message.SendMessageRequest;

public class SendMessageRequestImpl extends BaseServiceRequestImpl implements SendMessageRequest {

	private Message message;
	
	public SendMessageRequestImpl(Message message) {
		this.message = message;
	}
	
	@Override
	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public Message getMessage() {
		return message;
	}
	
	
}
