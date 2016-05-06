package com.bolatu.rest.client.service.request.entry;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.entry.UnlikeEntryRequest;

public class UnlikeEntryRequestImpl extends BaseServiceRequestImpl implements UnlikeEntryRequest {

	private String entryId;
	private String userNickname;
	
	public UnlikeEntryRequestImpl() {
	
	}
	
	public UnlikeEntryRequestImpl(String entryId, String userNickname) {
		this.entryId = entryId;
		this.userNickname = userNickname;
	}
	
	@Override
	public void setEntryId(String id) {
		this.entryId = id;
	}

	@Override
	public String getEntryId() {
		return entryId;
	}

	@Override
	public void setUsername(String username) {
		this.userNickname = username;
	}

	@Override
	public String getUsername() {
		return userNickname;
	}

}
