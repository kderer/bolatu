package com.bolatu.service.impl.response.entry;

import java.util.List;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.Entry;
import com.bolatu.db.impl.model.EntryImpl;
import com.bolatu.service.api.response.entry.EntryQueryResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class EntryQueryResponseImpl extends BaseServiceResponseImpl implements EntryQueryResponse {
	
	private long totalRecordNumber;
	private int pageSize;
	private int pageNumber;
	private List<EntryImpl> entryList;
	
	public EntryQueryResponseImpl() {
		
	}
	
	public EntryQueryResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
	
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
	@Override
	public void setEntryList(List<? extends Entry> entryList) {
		this.entryList = (List<EntryImpl>) entryList;		
	}
	
}
