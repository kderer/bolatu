package com.bolatu.service.api.request.entry;

import java.util.List;

import com.bolatu.service.api.request.BaseServiceRequest;
import com.bolatu.service.api.request.PageableRequest;

public interface EntryQueryRequest extends PageableRequest, BaseServiceRequest {
	
	public List<String> getUsernameList();
	
	public void setUsernameList(List<String> usernameList);
	
	public void addUsername(String username);
	
	public List<String> getEntryIdList();
	
	public void setEntryIdList(List<String> entryIdList);
	
	public void addEntryId(String entryId);
	
	public List<String> getLocationList();
	
	public void setLocationList(List<String> locationList);
	
	public void addLocation(String location);
	
	public List<Character> getStatusList();
	
	public void setStatusList(List<Character> statusList);
	
	public void addStatus(Character status);
	
	public List<String> getTagList();
	
	public void setTagList(List<String> tagList);
	
}
