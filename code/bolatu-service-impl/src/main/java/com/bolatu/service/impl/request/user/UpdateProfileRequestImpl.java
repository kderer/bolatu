package com.bolatu.service.impl.request.user;

import com.bolatu.db.api.model.User;
import com.bolatu.db.impl.model.UserImpl;
import com.bolatu.service.api.request.user.UpdateProfileRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class UpdateProfileRequestImpl extends BaseServiceRequestImpl implements UpdateProfileRequest {
	private User user;
	
	@Override
	@JsonDeserialize(as = UserImpl.class)
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}	
}
