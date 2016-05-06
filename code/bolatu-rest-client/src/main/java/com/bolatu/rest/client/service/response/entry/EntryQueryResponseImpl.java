package com.bolatu.rest.client.service.response.entry;

import java.util.List;

import com.bolatu.db.api.model.Entry;
import com.bolatu.rest.client.model.EntryImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.response.entry.EntryQueryResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class EntryQueryResponseImpl extends BaseServiceResponseImpl implements EntryQueryResponse {
	
	private long totalRecordNumber;
	private int pageSize;
	private int pageNumber;
	private List<EntryImpl> entryList;
	
	public long getTotalRecordNumber() {
		return totalRecordNumber;
	}
	
	public void setTotalRecordNumber(long totalRecordNumber) {
		this.totalRecordNumber = totalRecordNumber;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public List<EntryImpl> getEntryList() {
		return entryList;
	}

	@SuppressWarnings("unchecked")
	@JsonDeserialize(contentAs = EntryImpl.class)
	public void setEntryList(List<? extends Entry> entryList) {
		this.entryList =  (List<EntryImpl>) entryList;		
	}	
}
