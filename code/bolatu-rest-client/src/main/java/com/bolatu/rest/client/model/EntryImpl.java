package com.bolatu.rest.client.model;

import java.util.Date;
import java.util.List;

import com.bolatu.db.api.model.Entry;
import com.bolatu.db.api.model.User;
import com.bolatu.util.enumaration.EntryStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntryImpl implements Entry {
	
	private String id;	
	private String title;
	private String text;
	private UserImpl user;
	private String targetGender;
	private char targetAgeRange;
	private String ip;
	private String selectedLocation;
	private String tags;
	private Date postDate;
	private char status = EntryStatus.APPROVED.getCode();
	private int likeCount;
	private List<String> likedUserList;
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public User getUser() {
		return user;
	}
	
	@Override
	@JsonDeserialize(as = UserImpl.class)
	public void setUser(User user) {
		this.user = (UserImpl)user;
	}
	
	@Override
	public String getTargetGender() {
		return targetGender;
	}
	
	@Override
	public void setTargetGender(String targetGender) {
		this.targetGender = targetGender;
	}
	
	@Override
	public char getTargetAgeRange() {
		return targetAgeRange;
	}
	
	@Override
	public void setTargetAgeRange(char targetAgeRange) {
		this.targetAgeRange = targetAgeRange;
	}
	
	@Override
	public String getIp() {
		return ip;
	}
	
	@Override
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String getSelectedLocation() {
		return selectedLocation;
	}
	
	@Override
	public void setSelectedLocation(String selectedLocation) {
		this.selectedLocation = selectedLocation;
	}
	
	@Override
	public String getTags() {
		return tags;
	}
	
	@Override
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	@Override
	public Date getPostDate() {
		return postDate;
	}
	
	@Override
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	@Override
	public char getStatus() {
		return status;
	}
	
	@Override
	public void setStatus(char status) {
		this.status = status;
	}
	
	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	@Override
	public List<String> getLikedUserList() {
		return likedUserList;
	}
	
	@Override
	public void setLikedUserList(List<String> likedUserList) {
		this.likedUserList = likedUserList;
	}
}