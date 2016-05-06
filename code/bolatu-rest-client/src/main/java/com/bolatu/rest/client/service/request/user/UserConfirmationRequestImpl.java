package com.bolatu.rest.client.service.request.user;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.user.UserConfirmationRequest;

public class UserConfirmationRequestImpl extends BaseServiceRequestImpl implements UserConfirmationRequest{
	
	private String username;
	private String confirmationHash;
	
	public UserConfirmationRequestImpl(String username, String confirmationHash){
		this.username = username;
		this.confirmationHash = confirmationHash;
	}	

	public String getConfirmationHash() {
		return confirmationHash;
	}

	public void setConfirmationHash(String confirmationHash) {
		this.confirmationHash = confirmationHash;
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
