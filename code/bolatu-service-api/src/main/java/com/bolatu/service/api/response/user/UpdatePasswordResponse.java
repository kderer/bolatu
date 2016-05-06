package com.bolatu.service.api.response.user;

import com.bolatu.service.api.response.BaseServiceResponse;

public interface UpdatePasswordResponse extends BaseServiceResponse {
	
	public String getEmail();
	
	public void setEmail(String email);
	
}
