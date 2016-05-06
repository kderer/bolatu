package com.bolatu.service.impl.response.entry;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.request.entry.LikeEntryRequest;
import com.bolatu.service.api.response.entry.LikeEntryResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class LikeEntryResponseImpl extends BaseServiceResponseImpl implements LikeEntryResponse {

	private LikeEntryRequest likeEntryRequest;
	
	public LikeEntryResponseImpl() {

	}
	
	public LikeEntryResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
	
	@Override
	public void setLikeEntryRequest(LikeEntryRequest request) {
		this.likeEntryRequest = request;
	}

	@Override
	public LikeEntryRequest getLikeEntryRequest() {
		return likeEntryRequest;
	}
	
}
