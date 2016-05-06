package com.bolatu.service.impl.request.user;

import com.bolatu.service.api.request.user.UpdatePasswordRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

public class UpdatePasswordRequestImpl extends BaseServiceRequestImpl implements UpdatePasswordRequest {

	private String code;
	private String password;
	private String email;
	
	public UpdatePasswordRequestImpl() {
	
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}
	
}
