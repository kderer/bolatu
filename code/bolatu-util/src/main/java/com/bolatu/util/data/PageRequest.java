package com.bolatu.util.data;


public class PageRequest {

	private int pageSize = 50;
	private int pageNumber;
	
	public PageRequest() {
		
	}
	
	public PageRequest(int pageSize, int pageNumber) {
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

}
