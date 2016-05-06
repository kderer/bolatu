package com.bolatu.service.impl.request.entry;

import java.util.ArrayList;
import java.util.List;

import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.service.impl.request.BaseServiceRequestImpl;
import com.bolatu.util.data.SortRequest;

public class EntryQueryRequestImpl extends BaseServiceRequestImpl implements EntryQueryRequest {
	
	private List<String> usernameList;
	private List<String> entityIdList;
	private List<String> locationList;
	private List<String> tagList;
	private List<Character> statusList;
	private List<SortRequest> sortRequestList;
	private int pageNumber;
	private int pageSize;
	
	public EntryQueryRequestImpl() {
		
	}
	
	public EntryQueryRequestImpl(String entryId){
		this.entityIdList.add(entryId);
	}
	
	public List<String> getUsernameList() {
		return usernameList;
	}
	
	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}
	
	public void addUsername(String username) {
		if (usernameList == null) {
			usernameList = new ArrayList<String>();
		}
		
		usernameList.add(username);
	}
	
	public List<String> getEntryIdList() {
		return entityIdList;
	}
	
	public void setEntryIdList(List<String> entryIdList) {
		this.entityIdList = entryIdList;
	}
	
	public void addEntryId(String entryId) {
		if (entityIdList == null) {
			entityIdList = new ArrayList<String>();
		}
		
		entityIdList.add(entryId);
	}
	
	public List<String> getLocationList() {
		return locationList;
	}
	
	public void setLocationList(List<String> locationList) {
		this.locationList = locationList;
	}
	
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
	
	public void addTag(String tag) {
		if (tagList == null) {
			tagList = new ArrayList<String>();
		}
		
		tagList.add(tag);		
	}	
	
	public List<Character> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Character> statusList) {
		this.statusList = statusList;
	}
	
	public void addStatus(Character status) {
		if (statusList == null) {
			statusList = new ArrayList<Character>();
		}
		
		statusList.add(status);
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
