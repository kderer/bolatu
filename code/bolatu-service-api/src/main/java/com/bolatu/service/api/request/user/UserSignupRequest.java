package com.bolatu.service.api.request.user;

import com.bolatu.service.api.request.BaseServiceRequest;


public interface UserSignupRequest extends BaseServiceRequest {
	
	public void setUsername(String user);
	
	public String getUsername();
	
	public void setPassword(String password);
	
	public String getPassword();
	
	public void setEmail(String email);
	
	public String getEmail();
}
