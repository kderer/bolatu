package com.bolatu.service.impl.request.user;

import com.bolatu.service.api.request.user.ResetPasswordRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

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
