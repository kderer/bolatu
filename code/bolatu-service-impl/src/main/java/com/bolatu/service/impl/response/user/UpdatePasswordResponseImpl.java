package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.response.user.UpdatePasswordResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class UpdatePasswordResponseImpl extends BaseServiceResponseImpl implements UpdatePasswordResponse {
	
	private String email;
	
	public UpdatePasswordResponseImpl() {
		
	}
	
	public UpdatePasswordResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
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
