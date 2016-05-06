package com.bolatu.service.api.request.user;

import com.bolatu.service.api.request.BaseServiceRequest;


public interface ResendConfirmationCodeRequest extends BaseServiceRequest {
	
	public void setUsername(String user);
	
	public String getUsername();
}
