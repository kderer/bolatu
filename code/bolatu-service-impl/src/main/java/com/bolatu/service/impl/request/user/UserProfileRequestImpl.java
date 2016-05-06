package com.bolatu.service.impl.request.user;

import com.bolatu.service.api.request.user.UserProfileRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

public class UserProfileRequestImpl extends BaseServiceRequestImpl implements UserProfileRequest{
	
	private String username;
	
	public UserProfileRequestImpl() {
		
	}
	
	public UserProfileRequestImpl(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
		
	}
	

}
