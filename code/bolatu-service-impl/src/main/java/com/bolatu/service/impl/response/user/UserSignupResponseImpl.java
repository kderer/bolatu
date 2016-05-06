package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.User;
import com.bolatu.service.api.response.user.UserSignupResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class UserSignupResponseImpl extends BaseServiceResponseImpl implements UserSignupResponse {

	private User user;
	
	public UserSignupResponseImpl() {
		
	}
	
	public UserSignupResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
