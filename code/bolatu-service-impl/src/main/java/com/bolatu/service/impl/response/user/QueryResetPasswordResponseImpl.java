package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.response.user.QueryResetPasswordResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class QueryResetPasswordResponseImpl extends BaseServiceResponseImpl implements QueryResetPasswordResponse {

	private String email;
	private String code;
	
	public QueryResetPasswordResponseImpl() {
		
	}
	
	public QueryResetPasswordResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
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
