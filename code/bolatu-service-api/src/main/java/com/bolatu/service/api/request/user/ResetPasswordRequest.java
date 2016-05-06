package com.bolatu.service.api.request.user;

import com.bolatu.service.api.request.BaseServiceRequest;


public interface ResetPasswordRequest extends BaseServiceRequest {
	
	public void setEmail(String email);
	
	public String getEmail();
}
