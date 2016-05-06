package com.bolatu.rest.client.service.request.user;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.user.ResendConfirmationCodeRequest;

public class ResendConfirmationCodeRequestImpl extends BaseServiceRequestImpl implements ResendConfirmationCodeRequest {

	private String username;

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
