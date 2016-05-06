package com.bolatu.service.api.request.entry;

import com.bolatu.service.api.request.BaseServiceRequest;

public interface UnlikeEntryRequest extends BaseServiceRequest {
	
	public void setEntryId(String id);
	
	public String getEntryId();
	
	public void setUsername(String username);
	
	public String getUsername();

}
