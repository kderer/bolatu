package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.response.user.ResetPasswordResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class ResetPasswordResponseImpl extends BaseServiceResponseImpl implements ResetPasswordResponse {

	private String email;
	
	public ResetPasswordResponseImpl() {
		
	}
	
	public ResetPasswordResponseImpl(BolatuDbException dbEx) {
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
	
	
}
