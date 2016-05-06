package com.bolatu.service.api.service;

import com.bolatu.service.api.request.entry.CreateEntryRequest;
import com.bolatu.service.api.request.entry.DeleteEntryRequest;
import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.service.api.request.entry.LikeEntryRequest;
import com.bolatu.service.api.request.entry.UnlikeEntryRequest;
import com.bolatu.service.api.response.entry.CreateEntryResponse;
import com.bolatu.service.api.response.entry.DeleteEntryResponse;
import com.bolatu.service.api.response.entry.EntryQueryResponse;
import com.bolatu.service.api.response.entry.LikeEntryResponse;
import com.bolatu.service.api.response.entry.UnlikeEntryResponse;

public interface EntryService {
	
	public EntryQueryResponse queryEntry(EntryQueryRequest entryQueryRequest);

	public CreateEntryResponse createEntry(CreateEntryRequest createEntryRequest);
	
	public LikeEntryResponse likeEntry(LikeEntryRequest likeEntryRequest);
	
	public UnlikeEntryResponse unlikeEntry(UnlikeEntryRequest unlikeEntryRequest);

	public DeleteEntryResponse deleteEntry(DeleteEntryRequest deleteEntryRequest);	
	
}
