package com.bolatu.rest.client.service.request.message;

import java.util.ArrayList;
import java.util.List;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.message.QueryInboxRequest;
import com.bolatu.util.data.SortRequest;

public class QueryInboxRequestImpl extends BaseServiceRequestImpl implements QueryInboxRequest {

	private String userName;
	private Character status;
	private int pageSize;
	private int pageNumber;
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
	public void setStatus(Character status) {
		this.status = status;
	}

	@Override
	public Character getStatus() {
		return status;
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
