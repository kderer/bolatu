package com.bolatu.service.api.request.user;

import com.bolatu.db.api.model.User;
import com.bolatu.service.api.request.BaseServiceRequest;


public interface UpdateProfileRequest extends BaseServiceRequest {
	
	public void setUser(User user);
	
	public User getUser();
}
