package com.bolatu.util.data;

import com.bolatu.util.enumaration.SortDirection;

public class SortRequest {
	
	private String sortField;
	private SortDirection sortDirection;
	
	public SortRequest() {
		
	}
	
	public SortRequest(String sortField, SortDirection sortDirection) {
		this.sortDirection = sortDirection;
		this.sortField = sortField;
	}

	public String getSortField() {
		return sortField;
	}
	
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortDirection() {
		return sortDirection.getDesc();
	}
	
	public void setSortDirection(SortDirection sortDirection) {
		this.sortDirection = sortDirection;
	}

}
