package com.bolatu.web.mobile.lazydata;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.bolatu.rest.client.model.EntryImpl;
import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.service.api.response.entry.EntryQueryResponse;
import com.bolatu.service.api.service.EntryService;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.SortDirection;

public class LazyEntryFetcher extends LazyDataModel<EntryImpl> {

	private static final long serialVersionUID = -8506745923699410288L;
	
	private EntryService entryService;
	private EntryQueryRequest entryQueryRequest;
	
	private List<EntryImpl> entryList;
	
	public LazyEntryFetcher(EntryService entryService, EntryQueryRequest request) {
		this.entryService = entryService;
		this.entryQueryRequest = request;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntryImpl> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {		
		entryQueryRequest.addSortRequest(new SortRequest("postDate", SortDirection.DESC));
		entryQueryRequest.setPageSize(pageSize);
		entryQueryRequest.setPageNumber(first / pageSize);		
		
		EntryQueryResponse response = entryService.queryEntry(entryQueryRequest);
		
		entryList = (List<EntryImpl>) response.getEntryList();
		setRowCount((int)response.getTotalRecordNumber());
		
		return entryList;
	}

	public List<EntryImpl> getEntryList() {
		return entryList;
	}

}
