package com.bolatu.service.impl.response.message;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.response.message.DeleteSentMessageResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class DeleteSentMessageResponseImpl extends BaseServiceResponseImpl implements DeleteSentMessageResponse {

	private String messageId; 
	
	public DeleteSentMessageResponseImpl() {
		
	}
	
	public DeleteSentMessageResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
	
	public DeleteSentMessageResponseImpl(String messageId) {
		this.messageId = messageId;
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
