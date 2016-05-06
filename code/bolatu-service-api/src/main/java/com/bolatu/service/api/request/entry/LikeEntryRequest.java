package com.bolatu.service.api.request.entry;

import com.bolatu.service.api.request.BaseServiceRequest;

public interface LikeEntryRequest extends BaseServiceRequest {
	
	public void setEntryId(String id);
	
	public String getEntryId();
	
	public void setUsername(String userNickname);
	
	public String getUsername();

}
