package com.bolatu.service.impl.response.message;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.Message;
import com.bolatu.db.impl.model.MessageImpl;
import com.bolatu.service.api.response.message.SendMessageResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class SendMessageResponseImpl extends BaseServiceResponseImpl implements
		SendMessageResponse {

	private MessageImpl message;
	
	public SendMessageResponseImpl() {
		
	}
	
	public SendMessageResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
	
	@Override
	public void setMessage(Message message) {
		this.message = (MessageImpl)message;
	}

	@Override
	public Message getMessage() {
		return message;
	}

}
