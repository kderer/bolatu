package com.bolatu.rest.client.service.response.message;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.model.MessageImpl;
import com.bolatu.rest.client.service.request.message.ReadMessageRequestImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.api.response.message.ReadMessageResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ReadMessageResponseImpl extends BaseServiceResponseImpl implements
		ReadMessageResponse {
	
	private ReadMessageRequest readMessageRequest;
	private Message message;
	
	public ReadMessageResponseImpl() {
		
	}

	@Override
	@JsonDeserialize(as = ReadMessageRequestImpl.class)
	public void setRequest(ReadMessageRequest request) {
		this.readMessageRequest = request;
	}

	@Override
	public ReadMessageRequest getRequest() {
		return readMessageRequest;
	}

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
