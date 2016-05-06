package com.bolatu.db.api.model;

import java.util.Date;

public interface EntryLike {
	
	public void setUsername(String username);
	public String getUsername();
	
	public void setEntryId(String entryId);
	public String getEntryId();
	
	public void setLikeDate(Date likeDate);
	public Date getLikeDate();

}
