package com.bolatu.service.api.response.user;

import com.bolatu.db.api.model.User;
import com.bolatu.service.api.response.BaseServiceResponse;

public interface UpdateProfileResponse extends BaseServiceResponse {
	
	public User getUser();
	
}
