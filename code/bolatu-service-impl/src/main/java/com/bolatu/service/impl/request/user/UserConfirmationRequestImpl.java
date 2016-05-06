package com.bolatu.service.impl.request.user;

import com.bolatu.service.api.request.user.UserConfirmationRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

public class UserConfirmationRequestImpl extends BaseServiceRequestImpl implements UserConfirmationRequest{
	
	private String username;
	private String confirmationHash;
	
	public UserConfirmationRequestImpl() {
		
	}
	
	public UserConfirmationRequestImpl(String username, String confirmationHash){
		this.username = username;
		this.confirmationHash = confirmationHash;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getConfirmationHash() {
		return confirmationHash;
	}

	public void setConfirmationHash(String confirmationHash) {
		this.confirmationHash = confirmationHash;
	}
	

}
