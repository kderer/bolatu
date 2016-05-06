package com.bolatu.rest.client.model;

import java.util.Date;

import com.bolatu.db.api.model.EntryLike;

public class EntryLikeImpl implements EntryLike {
	
	private String id;
	private String username;
	private String entryId;
	private Date likeDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
}
