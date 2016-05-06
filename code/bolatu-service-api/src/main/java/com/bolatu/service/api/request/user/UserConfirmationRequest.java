package com.bolatu.service.api.request.user;

import com.bolatu.service.api.request.BaseServiceRequest;

public interface UserConfirmationRequest extends BaseServiceRequest {

	public String getUsername();
	public void setUsername(String username);

	public String getConfirmationHash();
	public void setConfirmationHash(String confirmationHash);
	
}
