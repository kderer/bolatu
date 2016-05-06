package com.bolatu.service.api.response.user;

import com.bolatu.service.api.response.BaseServiceResponse;

public interface ResetPasswordResponse extends BaseServiceResponse {
	
	public void setEmail(String email);
	
	public String getEmail();
	
}
