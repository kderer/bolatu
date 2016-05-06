package com.bolatu.service.impl.request.message;

import com.bolatu.service.api.request.message.DeleteInboxMessageRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

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
