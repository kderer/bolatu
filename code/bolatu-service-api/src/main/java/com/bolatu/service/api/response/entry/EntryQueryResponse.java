package com.bolatu.service.api.response.entry;

import java.util.List;

import com.bolatu.db.api.model.Entry;
import com.bolatu.service.api.response.BaseServiceResponse;
import com.bolatu.service.api.response.PageableResponse;

public interface EntryQueryResponse extends BaseServiceResponse, PageableResponse {	
	
	public List<? extends Entry> getEntryList();
	
	public void setEntryList(List<? extends Entry> entryList);
	
}
