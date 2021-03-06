package com.bolatu.service.impl.request.user;

import com.bolatu.service.api.request.user.QueryResetPasswordRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

public class QueryResetPasswordRequestImpl extends BaseServiceRequestImpl implements QueryResetPasswordRequest {

	private String email;
	private String code;

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getCode() {
		return code;
	}

}
