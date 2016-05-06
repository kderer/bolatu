package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.User;
import com.bolatu.service.api.response.user.UserAuthResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class UserAuthResponseImpl extends BaseServiceResponseImpl implements UserAuthResponse {
	
	private User user;
	
	public UserAuthResponseImpl() {
		
	}
	
	public UserAuthResponseImpl(BolatuDbException dbEx) {
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
