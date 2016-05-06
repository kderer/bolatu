package com.bolatu.service.api.response.message;

import com.bolatu.db.api.model.Message;
import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.api.response.BaseServiceResponse;

public interface ReadMessageResponse extends BaseServiceResponse {
	
	public void setRequest(ReadMessageRequest request);
	public ReadMessageRequest getRequest();
	
	public void setMessage(Message message);
	public Message getMessage();
	
}
