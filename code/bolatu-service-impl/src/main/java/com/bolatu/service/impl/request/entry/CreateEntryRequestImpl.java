package com.bolatu.service.impl.request.entry;

import com.bolatu.db.api.model.Entry;
import com.bolatu.db.impl.model.EntryImpl;
import com.bolatu.service.api.request.entry.CreateEntryRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class CreateEntryRequestImpl extends BaseServiceRequestImpl implements CreateEntryRequest {
	
	private String username;
	private Entry entry;
	
	public CreateEntryRequestImpl() {
		
	}
	
	public CreateEntryRequestImpl(Entry entry, String username) {
		this.username = username;
		this.entry = (EntryImpl)entry;
	}

	@Override
	@JsonDeserialize(as = EntryImpl.class)
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
