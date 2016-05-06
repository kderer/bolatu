package com.bolatu.db.api.criteria;

import java.util.Date;
import java.util.List;

public interface EntryLikeCriteria extends BaseCriteria {
	
	public void setUsernameList(List<String> usernameList);
	public List<String> getUsernameList();
	public void addUsername(String username);
	
	public void setEntryIdList(List<String> entryIdList);
	public List<String> getEntryIdList();
	public void addEntryId(String entryId);
	
	public void setLikeDateInterval(ValueInterval<Date> likeDateInterval);
	public ValueInterval<Date> getLikeDateInterval();

}
