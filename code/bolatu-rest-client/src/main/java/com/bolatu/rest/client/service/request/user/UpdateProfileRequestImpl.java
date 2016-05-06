package com.bolatu.rest.client.service.request.user;

import com.bolatu.db.api.model.User;
import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.user.UpdateProfileRequest;

public class UpdateProfileRequestImpl extends BaseServiceRequestImpl implements UpdateProfileRequest {
	private User user;
	
	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}	
}
