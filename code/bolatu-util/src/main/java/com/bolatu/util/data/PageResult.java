package com.bolatu.util.data;

import java.util.List;

public class PageResult<T> {

	private long total;
	private int pageNumber;
	private int pageSize;
	private List<? extends T> resultList;	
	
	public PageResult(int pageNumber, int pageSize, long total, List<? extends T> resultList) {
		this.total = total;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.resultList = resultList;
	}
	
	public long getTotal() {
		return total;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public List<? extends T> getResultList() {
		return resultList;
	}

	public int getPageCount() {
		if (total <= 0) {
			return 0;
		}
		
		if (total > pageSize) {
			return (int)(total / pageSize) + 1;
		}
		
		return 1;
	}

}
