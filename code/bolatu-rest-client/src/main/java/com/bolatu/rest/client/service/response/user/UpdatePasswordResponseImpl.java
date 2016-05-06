package com.bolatu.rest.client.service.response.user;

import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.user.UpdatePasswordResponse;

public class UpdatePasswordResponseImpl extends BaseServiceResponseImpl implements UpdatePasswordResponse {
	
	private String email;
	
	public UpdatePasswordResponseImpl() {
		
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
}
