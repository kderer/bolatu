package com.bolatu.service.api.request.message;

import com.bolatu.service.api.request.BaseServiceRequest;

public interface DeleteInboxMessageRequest extends BaseServiceRequest {
	
	public void setMessageId(String messageId);
	
	public String getMessageId();

}
