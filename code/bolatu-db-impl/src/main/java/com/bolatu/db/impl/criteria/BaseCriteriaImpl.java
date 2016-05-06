package com.bolatu.db.impl.criteria;

import java.util.ArrayList;
import java.util.List;

import com.bolatu.db.api.criteria.BaseCriteria;
import com.bolatu.util.data.SortRequest;

public abstract class BaseCriteriaImpl implements BaseCriteria {
	
	private int pageSize = 50;
	private int pageNumber;
	private List<SortRequest> sortRequestList;
	private String customQuery;
	
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
	
	public void addSortRequest(SortRequest sortRequest) {
		if (sortRequestList == null) {
			sortRequestList = new ArrayList<SortRequest>();
		}
		sortRequestList.add(sortRequest);
	}
	
	public List<SortRequest> getSortRequestList() {
		return sortRequestList;
	}
	
	public void setSortRequestList(List<SortRequest> sortRequestList) {
		this.sortRequestList = sortRequestList;
	}

	public String getCustomQuery() {
		return customQuery;
	}

	public void setCustomQuery(String customQuery) {
		this.customQuery = customQuery;
	}
	
}
