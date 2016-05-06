package com.bolatu.service.api.response.user;

import com.bolatu.db.api.model.UserAuthInfo;
import com.bolatu.service.api.response.BaseServiceResponse;

public interface QueryUserAuthInfoResponse extends BaseServiceResponse {
	
	public UserAuthInfo getUserAuthInfo();
	
	public void setUserAuthInfo(UserAuthInfo userAuthInfo);

}
