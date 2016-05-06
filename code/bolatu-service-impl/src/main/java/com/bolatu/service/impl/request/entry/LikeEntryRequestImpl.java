package com.bolatu.service.impl.request.entry;

import com.bolatu.service.api.request.entry.LikeEntryRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;

public class LikeEntryRequestImpl extends BaseServiceRequestImpl implements LikeEntryRequest {

	private String entryId;
	private String userNickname;
	
	public LikeEntryRequestImpl() {
	
	}
	
	public LikeEntryRequestImpl(String entryId, String userNickname) {
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
	public void setUsername(String userNickname) {
		this.userNickname = userNickname;
	}

	@Override
	public String getUsername() {
		return userNickname;
	}

}
