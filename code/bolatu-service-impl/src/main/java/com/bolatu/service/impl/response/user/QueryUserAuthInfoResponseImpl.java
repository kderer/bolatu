package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.UserAuthInfo;
import com.bolatu.db.impl.model.UserAuthInfoImpl;
import com.bolatu.service.api.response.user.QueryUserAuthInfoResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class QueryUserAuthInfoResponseImpl extends BaseServiceResponseImpl implements QueryUserAuthInfoResponse {
	
	private UserAuthInfo userAuthInfo;
	
	public QueryUserAuthInfoResponseImpl() {
		
	}
	
	public QueryUserAuthInfoResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
	
	public QueryUserAuthInfoResponseImpl(UserAuthInfo userAuthInfo) {
		this.userAuthInfo = userAuthInfo;
	}

	@Override
	public UserAuthInfo getUserAuthInfo() {
		return userAuthInfo;
	}

	@Override
	public void setUserAuthInfo(UserAuthInfo userAuthInfo) {
		this.userAuthInfo = (UserAuthInfoImpl)userAuthInfo;
	}

}
