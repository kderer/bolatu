package com.bolatu.service.impl.response.message;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.response.message.DeleteInboxMessageResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class DeleteInboxMessageResponseImpl extends BaseServiceResponseImpl implements DeleteInboxMessageResponse {

	private String messageId;
	
	public DeleteInboxMessageResponseImpl() {
	
	}
	
	public DeleteInboxMessageResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
	
	public DeleteInboxMessageResponseImpl(String messageId) {
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
