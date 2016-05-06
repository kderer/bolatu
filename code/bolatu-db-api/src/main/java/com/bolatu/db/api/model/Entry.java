package com.bolatu.db.api.model;

import java.util.Date;
import java.util.List;

public interface Entry {

	public String getId();
	
	public String getTitle();
	public void setTitle(String title);
	
	public String getText();
	public void setText(String text);

	public User getUser();
	public void setUser(User user);
	
	public String getTargetGender();
	public void setTargetGender(String targetGender);

	public char getTargetAgeRange();
	public void setTargetAgeRange(char targetAgeRage);
	
	public String getIp();
	public void setIp(String ip);

	public String getSelectedLocation();
	public void setSelectedLocation(String selectedLocation);

	public String getTags();
	public void setTags(String tags);

	public Date getPostDate();
	public void setPostDate(Date postDate);
	
	public char getStatus();
	public void setStatus(char status);
	
	public List<String> getLikedUserList();
	public void setLikedUserList(List<String> likeUserList);
	
}
