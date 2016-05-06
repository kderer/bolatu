package com.bolatu.rest.client.service.response.user;

import com.bolatu.db.api.model.UserAuthInfo;
import com.bolatu.rest.client.model.UserAuthInfoImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.user.QueryUserAuthInfoResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class QueryUserAuthInfoResponseImpl extends BaseServiceResponseImpl implements QueryUserAuthInfoResponse {
	
	private UserAuthInfo userAuthInfo;
	
	public QueryUserAuthInfoResponseImpl() {
		
	}
	
	public QueryUserAuthInfoResponseImpl(UserAuthInfo userAuthInfo) {
		this.userAuthInfo = userAuthInfo;
	}

	@Override
	public UserAuthInfo getUserAuthInfo() {
		return userAuthInfo;
	}

	@Override
	@JsonDeserialize(as = UserAuthInfoImpl.class)
	public void setUserAuthInfo(UserAuthInfo userAuthInfo) {
		this.userAuthInfo = (UserAuthInfoImpl)userAuthInfo;
	}

}
