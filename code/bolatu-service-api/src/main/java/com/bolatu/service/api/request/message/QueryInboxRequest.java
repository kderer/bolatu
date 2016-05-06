package com.bolatu.service.api.request.message;

import com.bolatu.service.api.request.BaseServiceRequest;
import com.bolatu.service.api.request.PageableRequest;

public interface QueryInboxRequest extends PageableRequest, BaseServiceRequest {
	
	public void setUsername(String userName);
	
	public String getUsername();
	
	public void setStatus(Character status);
	
	public Character getStatus();
	
}
