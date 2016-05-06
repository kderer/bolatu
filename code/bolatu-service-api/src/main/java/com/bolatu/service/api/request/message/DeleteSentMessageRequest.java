package com.bolatu.service.api.request.message;

import com.bolatu.service.api.request.BaseServiceRequest;

public interface DeleteSentMessageRequest extends BaseServiceRequest {
	
	public void setMessageId(String messageId);
	
	public String getMessageId();

}
