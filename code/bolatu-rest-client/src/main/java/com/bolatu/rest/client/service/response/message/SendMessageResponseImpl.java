package com.bolatu.rest.client.service.response.message;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.model.MessageImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.message.SendMessageResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class SendMessageResponseImpl extends BaseServiceResponseImpl implements
		SendMessageResponse {

	private Message message;
	
	@Override
	@JsonDeserialize(as = MessageImpl.class)
	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public Message getMessage() {
		return message;
	}

}
