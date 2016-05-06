package com.bolatu.rest.client.service.response.user;

import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.user.ResetPasswordResponse;

public class ResetPasswordResponseImpl extends BaseServiceResponseImpl implements ResetPasswordResponse {

	private String email;
	
	public ResetPasswordResponseImpl() {
		
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getEmail() {
		return email;
	}
	
	
}
