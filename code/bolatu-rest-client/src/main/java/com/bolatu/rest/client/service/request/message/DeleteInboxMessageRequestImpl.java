package com.bolatu.rest.client.service.request.message;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.message.DeleteInboxMessageRequest;

public class DeleteInboxMessageRequestImpl extends BaseServiceRequestImpl implements DeleteInboxMessageRequest {

	private String messageId;

	@Override
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public String getMessageId() {
		return messageId;
	}	
	
}
