package com.bolatu.service.api.request.entry;

import com.bolatu.db.api.model.Entry;
import com.bolatu.service.api.request.BaseServiceRequest;

public interface CreateEntryRequest extends BaseServiceRequest {
	
	public void setUsername(String username);
	
	public String getUsername();
	
	public void setEntry(Entry entry);
	
	public Entry getEntry();

}
