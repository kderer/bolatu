package com.bolatu.rest.client.service.request.user;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.user.ResetPasswordRequest;

public class ResetPasswordRequestImpl extends BaseServiceRequestImpl implements ResetPasswordRequest {

	private String email;

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getEmail() {
		return email;
	}

}
