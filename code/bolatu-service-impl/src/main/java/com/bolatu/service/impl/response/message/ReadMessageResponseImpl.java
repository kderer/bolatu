package com.bolatu.service.impl.response.message;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.Message;
import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.api.response.message.ReadMessageResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class ReadMessageResponseImpl extends BaseServiceResponseImpl implements
		ReadMessageResponse {
	
	private ReadMessageRequest readMessageRequest;
	private Message message;
	
	public ReadMessageResponseImpl() {
		
	}
	
	public ReadMessageResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
	
	public ReadMessageResponseImpl(ReadMessageRequest readMessageRequest, Message message) {
		this.readMessageRequest = readMessageRequest;
		this.message = message;
	}

	@Override
	public void setRequest(ReadMessageRequest request) {
		this.readMessageRequest = request;
	}

	@Override
	public ReadMessageRequest getRequest() {
		return readMessageRequest;
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
