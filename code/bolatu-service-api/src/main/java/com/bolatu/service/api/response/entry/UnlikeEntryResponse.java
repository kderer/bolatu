package com.bolatu.service.api.response.entry;

import com.bolatu.service.api.request.entry.UnlikeEntryRequest;
import com.bolatu.service.api.response.BaseServiceResponse;

public interface UnlikeEntryResponse extends BaseServiceResponse {
	
	public void setUnlikeEntryRequest(UnlikeEntryRequest request);
	
	public UnlikeEntryRequest getUnlikeEntryRequest();

}
