package com.bolatu.service.api.request.user;

import com.bolatu.service.api.request.BaseServiceRequest;

public interface UserAuthRequest extends BaseServiceRequest {
	
	public String getUsername();
	
	public void setUsername(String username);
	
	public String getPassword();
	
	public void setPassword(String password);

}
