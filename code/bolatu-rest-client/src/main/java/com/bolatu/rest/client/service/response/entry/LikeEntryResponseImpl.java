package com.bolatu.rest.client.service.response.entry;

import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.request.entry.LikeEntryRequest;
import com.bolatu.service.api.response.entry.LikeEntryResponse;

public class LikeEntryResponseImpl extends BaseServiceResponseImpl implements LikeEntryResponse {

	private LikeEntryRequest likeEntryRequest;
	
	@Override
	public void setLikeEntryRequest(LikeEntryRequest request) {
		this.likeEntryRequest = request;
	}

	@Override
	public LikeEntryRequest getLikeEntryRequest() {
		return likeEntryRequest;
	}
	
}
