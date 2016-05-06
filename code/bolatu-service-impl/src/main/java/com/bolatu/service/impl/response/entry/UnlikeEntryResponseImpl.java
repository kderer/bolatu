package com.bolatu.service.impl.response.entry;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.request.entry.UnlikeEntryRequest;
import com.bolatu.service.api.response.entry.UnlikeEntryResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class UnlikeEntryResponseImpl extends BaseServiceResponseImpl implements UnlikeEntryResponse {

	private UnlikeEntryRequest unlikeEntryRequest;
	
	public UnlikeEntryResponseImpl() {

	}
	
	public UnlikeEntryResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
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
