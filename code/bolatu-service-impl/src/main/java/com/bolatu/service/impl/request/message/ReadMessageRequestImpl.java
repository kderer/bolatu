package com.bolatu.service.impl.request.message;

import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

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
