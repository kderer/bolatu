package com.bolatu.service.api.response.message;

import com.bolatu.db.api.model.Message;
import com.bolatu.service.api.response.BaseServiceResponse;

public interface SendMessageResponse extends BaseServiceResponse {
	
	public void setMessage(Message message);
	
	public Message getMessage();

}
