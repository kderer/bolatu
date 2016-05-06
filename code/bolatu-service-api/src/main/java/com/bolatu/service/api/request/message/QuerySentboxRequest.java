package com.bolatu.service.api.request.message;

import com.bolatu.service.api.request.BaseServiceRequest;
import com.bolatu.service.api.request.PageableRequest;

public interface QuerySentboxRequest extends PageableRequest, BaseServiceRequest {
	
	public void setUsername(String userName);
	
	public String getUsername();
	
}
