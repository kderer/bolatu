package com.bolatu.service.impl.request.message;

import java.util.ArrayList;
import java.util.List;

import com.bolatu.service.api.request.message.QuerySentboxRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;
import com.bolatu.util.data.SortRequest;

public class QuerySentboxRequestImpl extends BaseServiceRequestImpl implements QuerySentboxRequest {

	private int pageSize;
	private int pageNumber;
	private String userName;
	private List<SortRequest> sortRequestList;
	
	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public void setUsername(String userName) {
		this.userName = userName;
	}

	@Override
	public String getUsername() {
		return userName;
	}
	
	@Override
	public List<SortRequest> getSortRequestList() {
		return sortRequestList;
	}
	
	@Override
	public void setSortRequestList(List<SortRequest> sortRequestList) {
		this.sortRequestList = sortRequestList;
	}	
	
	@Override
	public void addSortRequest(SortRequest sortRequest) {
		if (sortRequestList == null) {
			sortRequestList = new ArrayList<SortRequest>();
		}
		
		sortRequestList.add((SortRequest)sortRequest);
	}
	
}
