package com.bolatu.service.api.request.entry;

import com.bolatu.service.api.request.BaseServiceRequest;

public interface DeleteEntryRequest extends BaseServiceRequest {
	
	public void setUsername(String username);
	
	public String getUsername();
	
	public void setEntryId(String entryId);
	
	public String getEntryId();

}
