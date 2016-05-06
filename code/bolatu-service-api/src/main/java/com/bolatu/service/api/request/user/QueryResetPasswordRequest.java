package com.bolatu.service.api.request.user;

import com.bolatu.service.api.request.BaseServiceRequest;


public interface QueryResetPasswordRequest extends BaseServiceRequest {
	
	public void setEmail(String email);
	
	public String getEmail();
	
	public void setCode(String code);
	
	public String getCode();
}
