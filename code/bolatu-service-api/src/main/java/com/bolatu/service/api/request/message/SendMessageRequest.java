package com.bolatu.service.api.request.message;

import com.bolatu.db.api.model.Message;
import com.bolatu.service.api.request.BaseServiceRequest;

public interface SendMessageRequest extends BaseServiceRequest {
	
	public void setMessage(Message message);
	
	public Message getMessage();

}
