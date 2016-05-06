package com.bolatu.rest.client.service.response.user;

import com.bolatu.db.api.model.User;
import com.bolatu.rest.client.model.UserImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.user.UpdateProfileResponse;

public class UpdateProfileResponseImpl extends BaseServiceResponseImpl implements UpdateProfileResponse {
	private UserImpl user;
	
	public UpdateProfileResponseImpl() {
		
	}

	@Override
	public User getUser() {
		return user;
	}	
}
