package com.bolatu.rest.client.service.request.entry;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.entry.DeleteEntryRequest;

public class DeleteEntryRequestImpl extends BaseServiceRequestImpl implements DeleteEntryRequest {	
	private String username;
	private String entryId;
	
	public DeleteEntryRequestImpl() {
		
	}
	
	public DeleteEntryRequestImpl(String entryId, String username) {
		this.username = username;
		this.entryId = entryId;
	}

	@Override
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	@Override
	public String getEntryId() {
		return entryId;
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
