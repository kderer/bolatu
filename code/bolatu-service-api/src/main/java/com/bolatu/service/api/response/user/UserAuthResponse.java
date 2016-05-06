package com.bolatu.service.api.response.user;

import com.bolatu.db.api.model.User;
import com.bolatu.service.api.response.BaseServiceResponse;

public interface UserAuthResponse extends BaseServiceResponse {
	
	public User getUser();

	public void setUser(User user);		
	
}
