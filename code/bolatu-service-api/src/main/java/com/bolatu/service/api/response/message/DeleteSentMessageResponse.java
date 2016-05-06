package com.bolatu.service.api.response.message;

import com.bolatu.service.api.response.BaseServiceResponse;

public interface DeleteSentMessageResponse extends BaseServiceResponse {
	
	public void setMessageId(String messageId);
	
	public String getMessageId();
	
}
