package com.bolatu.rest.client.service.response.entry;

import com.bolatu.db.api.model.Entry;
import com.bolatu.rest.client.model.EntryImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.entry.CreateEntryResponse;

public class CreateEntryResponseImpl extends BaseServiceResponseImpl implements CreateEntryResponse {

	private EntryImpl entry;
	
	public CreateEntryResponseImpl() {
		
	}
	
	@Override
	public Entry getEntry() {
		return entry;
	}

}
