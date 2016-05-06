package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.User;
import com.bolatu.service.api.response.user.UserConfirmationResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class UserConfirmationResponseImpl extends BaseServiceResponseImpl implements UserConfirmationResponse{
	
	private User user;
	
	public UserConfirmationResponseImpl() {
		
	}
	
	public UserConfirmationResponseImpl(BolatuDbException dbEx) {
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
