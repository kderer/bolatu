package com.bolatu.rest.client.service.response.user;

import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.user.QueryResetPasswordResponse;

public class QueryResetPasswordResponseImpl extends BaseServiceResponseImpl implements QueryResetPasswordResponse {

	private String email;
	private String code;
	
	public QueryResetPasswordResponseImpl() {
		
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
