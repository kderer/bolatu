package com.bolatu.service.api.request.user;

import com.bolatu.service.api.request.BaseServiceRequest;


public interface UpdatePasswordRequest extends BaseServiceRequest {
	
	public void setPassword(String password);
	
	public String getPassword();
	
	public void setEmail(String email);
	
	public String getEmail();
	
	public String getCode();
	
	public void setCode(String code);
}
