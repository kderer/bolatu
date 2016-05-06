package com.bolatu.rest.client.service.request.entry;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.entry.LikeEntryRequest;

public class LikeEntryRequestImpl extends BaseServiceRequestImpl implements LikeEntryRequest {

	private String entryId;
	private String userNickname;
	
	@Override
	public void setEntryId(String id) {
		this.entryId = id;
	}

	@Override
	public String getEntryId() {
		return entryId;
	}

	@Override
	public void setUsername(String userNickname) {
		this.userNickname = userNickname;
	}

	@Override
	public String getUsername() {
		return userNickname;
	}

}
