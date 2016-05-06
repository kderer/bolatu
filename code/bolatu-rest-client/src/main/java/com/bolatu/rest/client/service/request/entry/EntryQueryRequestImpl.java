package com.bolatu.rest.client.service.request.entry;

import java.util.ArrayList;
import java.util.List;

import com.bolatu.rest.client.service.request.BaseServiceRequestImpl;
import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.util.data.SortRequest;

public class EntryQueryRequestImpl extends BaseServiceRequestImpl implements EntryQueryRequest {
	
	private List<String> usernameList;
	private List<String> entryIdList;
	private List<String> locationList;
	private List<String> tagList;
	private List<Character> statusList;
	private List<SortRequest> sortRequestList;
	private int pageNumber;
	private int pageSize;
	
	public EntryQueryRequestImpl() {
		
	}
	
	public EntryQueryRequestImpl(String entryId){
		addEntryId(entryId);
	}
	
	public List<String> getUsernameList() {
		return usernameList;
	}
	
	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}
	
	@Override
	public void addUsername(String username) {
		if (usernameList == null) {
			usernameList = new ArrayList<String>();
		}
		
		usernameList.add(username);
	}
	
	public List<String> getEntryIdList() {
		return entryIdList;
	}
	
	public void setEntryIdList(List<String> entryIdList) {
		this.entryIdList = entryIdList;
	}
	
	@Override
	public void addEntryId(String entryId) {
		if (entryIdList == null) {
			entryIdList = new ArrayList<String>();
		}
		
		entryIdList.add(entryId);
	}
	
	public List<String> getLocationList() {
		return locationList;
	}
	
	public void setLocationList(List<String> locationList) {
		this.locationList = locationList;
	}
	
	@Override
	public void addLocation(String location) {
		if (locationList == null) {
			locationList = new ArrayList<String>();
		}
		
		locationList.add(location);
	}
	
	public List<String> getTagList() {
		return tagList;
	}
	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public void addSortRequest(SortRequest sortRequest) {
		if (sortRequestList == null) {
			sortRequestList = new ArrayList<SortRequest>();
		}
		
		sortRequestList.add((SortRequest)sortRequest);
	}	

	@Override
	public List<Character> getStatusList() {
		return statusList;
	}

	@Override
	public void setStatusList(List<Character> statusList) {
		this.statusList = statusList;
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
	public void addStatus(Character status) {
		if (statusList == null) {
			statusList = new ArrayList<Character>();
		}
		
		statusList.add(status);
	}

}
