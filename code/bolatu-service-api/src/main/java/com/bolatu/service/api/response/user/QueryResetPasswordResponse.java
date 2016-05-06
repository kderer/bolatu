package com.bolatu.service.api.response.user;

import com.bolatu.service.api.response.BaseServiceResponse;

public interface QueryResetPasswordResponse extends BaseServiceResponse {
	
	public void setEmail(String email);
	
	public String getEmail();
	
	public void setCode(String code);
	
	public String getCode();
	
}
