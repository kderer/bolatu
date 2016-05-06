package com.bolatu.rest.client.service.request.user;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.user.UserAuthRequest;

public class UserAuthRequestImpl extends BaseServiceRequestImpl implements UserAuthRequest {
	
	private String username;
	private String password;
	
	public UserAuthRequestImpl(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	

}
