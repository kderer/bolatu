package com.bolatu.rest.client.service.response.user;

import com.bolatu.db.api.model.User;
import com.bolatu.rest.client.model.UserImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.user.UserProfileResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class UserProfileResponseImpl  extends BaseServiceResponseImpl implements UserProfileResponse{

	private User user;
	
	@Override
	public User getUser() {
		return user;
	}

	@Override
	@JsonDeserialize(as = UserImpl.class)
	public void setUser(User user) {
		this.user = user;		
	}
	
}
