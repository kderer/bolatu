package com.bolatu.rest.client.service.request.entry;

import com.bolatu.db.api.model.Entry;
import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.entry.CreateEntryRequest;

public class CreateEntryRequestImpl extends BaseServiceRequestImpl implements CreateEntryRequest {
	
	private String username;
	private Entry entry;
	
	public CreateEntryRequestImpl(Entry entry, String username) {
		this.username = username;
		this.entry = entry;
	}

	@Override
	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	@Override
	public Entry getEntry() {
		return entry;
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
