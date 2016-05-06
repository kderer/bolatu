package com.bolatu.db.api.criteria;

import java.util.List;

import com.bolatu.util.data.SortRequest;

public interface BaseCriteria {
	
	public void setPageSize(int pageSize);
	
	public int getPageSize();
	
	public void setPageNumber(int pageNumber);
	
	public int getPageNumber();
	
	public void addSortRequest(SortRequest sortRequest);
	
	public List<SortRequest> getSortRequestList();
	
	public void setSortRequestList(List<SortRequest> sortRequestList);
	
	public void resetCriteria();

}
