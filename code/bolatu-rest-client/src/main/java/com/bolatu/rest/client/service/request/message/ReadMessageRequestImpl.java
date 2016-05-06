package com.bolatu.rest.client.service.request.message;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.message.ReadMessageRequest;

public class ReadMessageRequestImpl extends BaseServiceRequestImpl implements ReadMessageRequest {
	
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
