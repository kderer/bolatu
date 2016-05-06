package com.bolatu.service.api.response.message;

import com.bolatu.service.api.response.BaseServiceResponse;

public interface DeleteInboxMessageResponse extends BaseServiceResponse {
	
	public void setMessageId(String messageId);
	
	public String getMessageId();
	
}
