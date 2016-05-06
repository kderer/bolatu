package com.bolatu.service.api.response.entry;

import com.bolatu.service.api.request.entry.LikeEntryRequest;
import com.bolatu.service.api.response.BaseServiceResponse;

public interface LikeEntryResponse extends BaseServiceResponse {
	
	public void setLikeEntryRequest(LikeEntryRequest request);
	
	public LikeEntryRequest getLikeEntryRequest();

}
