package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.User;
import com.bolatu.service.api.response.user.UserProfileResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class UserProfileResponseImpl  extends BaseServiceResponseImpl implements UserProfileResponse{

	private User user;
	
	public UserProfileResponseImpl() {
		
	}
	
	public UserProfileResponseImpl(BolatuDbException dbEx) {
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
