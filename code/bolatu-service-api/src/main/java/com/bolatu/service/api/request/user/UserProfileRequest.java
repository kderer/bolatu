package com.bolatu.service.api.request.user;

import com.bolatu.service.api.request.BaseServiceRequest;

public interface UserProfileRequest extends BaseServiceRequest {
	
	public String getUsername();
	
	public void setUsername(String username);
	

}
