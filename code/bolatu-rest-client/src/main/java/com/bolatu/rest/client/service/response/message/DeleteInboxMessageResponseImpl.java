package com.bolatu.rest.client.service.response.message;

import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.message.DeleteInboxMessageResponse;

public class DeleteInboxMessageResponseImpl extends BaseServiceResponseImpl implements DeleteInboxMessageResponse {

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
