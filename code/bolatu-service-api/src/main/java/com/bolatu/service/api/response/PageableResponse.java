package com.bolatu.service.api.response;

public interface PageableResponse {
	
	public long getTotalRecordNumber();
	
	public void setTotalRecordNumber(long totalRecordNumber);
	
	public int getPageSize();
	
	public void setPageSize(int pageSize);
	
	public int getPageNumber();
	
	public void setPageNumber(int pageNumber);

}
