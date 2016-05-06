package com.bolatu.db.impl.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bolatu.db.api.criteria.EntryLikeCriteria;
import com.bolatu.db.api.criteria.ValueInterval;

public class EntryLikeCriteriaImpl extends BaseCriteriaImpl implements EntryLikeCriteria {
	
	private List<String> usernameList;
	private List<String> entryIdList;
	private ValueInterval<Date> likeDateInterval;
	
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
		return entryIdList;
	}
	
	public void setEntryIdList(List<String> entryIdList) {
		this.entryIdList = entryIdList;
	}
	
	public void addEntryId(String entryId) {
		if (entryIdList == null) {
			entryIdList = new ArrayList<String>();
		}
		entryIdList.add(entryId);
	}
	
	public ValueInterval<Date> getLikeDateInterval() {
		return likeDateInterval;
	}
	
	public void setLikeDateInterval(ValueInterval<Date> likeDateInterval) {
		this.likeDateInterval = likeDateInterval;
	}

	@Override
	public void resetCriteria() {
		
	}

}
