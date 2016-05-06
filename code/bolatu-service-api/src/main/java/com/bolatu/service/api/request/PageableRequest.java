package com.bolatu.service.api.request;


import java.util.List;

import com.bolatu.util.data.SortRequest;

public interface PageableRequest {
	
	public int getPageSize();
	
	public void setPageSize(int pageSize);
	
	public int getPageNumber();
	
	public void setPageNumber(int pageNumber);
	
	public void setSortRequestList(List<SortRequest> sortRequestList);
	
	public List<SortRequest> getSortRequestList();
	
	public void addSortRequest(SortRequest sortRequest);

}
