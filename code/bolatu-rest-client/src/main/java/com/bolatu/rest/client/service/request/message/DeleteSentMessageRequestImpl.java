package com.bolatu.rest.client.service.request.message;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.message.DeleteSentMessageRequest;

public class DeleteSentMessageRequestImpl extends BaseServiceRequestImpl implements DeleteSentMessageRequest {

	private String messageId;
	
	public DeleteSentMessageRequestImpl() {
		
	}

	@Override
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public String getMessageId() {
		return messageId;
	}	
	
}
