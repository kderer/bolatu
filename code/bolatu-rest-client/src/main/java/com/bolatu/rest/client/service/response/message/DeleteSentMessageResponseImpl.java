package com.bolatu.rest.client.service.response.message;

import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.message.DeleteSentMessageResponse;

public class DeleteSentMessageResponseImpl extends BaseServiceResponseImpl implements DeleteSentMessageResponse {

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
