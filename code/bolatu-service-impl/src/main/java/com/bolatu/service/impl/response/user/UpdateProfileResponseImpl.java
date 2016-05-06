package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.User;
import com.bolatu.service.api.response.user.UpdateProfileResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class UpdateProfileResponseImpl extends BaseServiceResponseImpl implements UpdateProfileResponse {
	private User user;
	
	public UpdateProfileResponseImpl() {
		
	}
	
	public UpdateProfileResponseImpl(User user) {
		this.user = user;
	}
	
	public UpdateProfileResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}

	@Override
	public User getUser() {
		return user;
	}	
}
