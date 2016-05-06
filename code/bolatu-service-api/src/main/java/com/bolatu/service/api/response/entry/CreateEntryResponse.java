package com.bolatu.service.api.response.entry;

import com.bolatu.db.api.model.Entry;
import com.bolatu.service.api.response.BaseServiceResponse;

public interface CreateEntryResponse extends BaseServiceResponse  {
	
	public Entry getEntry();

}
