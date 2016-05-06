package com.bolatu.service.impl.request.message;

import com.bolatu.service.api.request.message.DeleteSentMessageRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

public class DeleteSentMessageRequestImpl extends BaseServiceRequestImpl implements DeleteSentMessageRequest {

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
