package com.bolatu.rest.client.service.response.entry;

import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.request.entry.UnlikeEntryRequest;
import com.bolatu.service.api.response.entry.UnlikeEntryResponse;

public class UnlikeEntryResponseImpl extends BaseServiceResponseImpl implements UnlikeEntryResponse {

	private UnlikeEntryRequest unlikeEntryRequest;
	
	public UnlikeEntryResponseImpl() {

	}
	
	@Override
	public void setUnlikeEntryRequest(UnlikeEntryRequest request) {
		this.unlikeEntryRequest = request;
	}

	@Override
	public UnlikeEntryRequest getUnlikeEntryRequest() {
		return unlikeEntryRequest;
	}
	
}
