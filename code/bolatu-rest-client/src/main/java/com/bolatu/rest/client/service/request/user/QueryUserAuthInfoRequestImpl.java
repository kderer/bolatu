package com.bolatu.rest.client.service.request.user;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.user.QueryUserAuthInfoRequest;

public class QueryUserAuthInfoRequestImpl extends BaseServiceRequestImpl implements QueryUserAuthInfoRequest {

	private String username;
	
	public QueryUserAuthInfoRequestImpl() {
		
	}
	
	public QueryUserAuthInfoRequestImpl(String username) {
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
