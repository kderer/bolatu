package com.bolatu.db.impl.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolatu.db.api.model.EntryLike;

@Document(collection = "entryLike")
public class EntryLikeImpl implements EntryLike {
	
	@Id
	private String id;
	
	private String username;
	
	@Indexed
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
	
	public static enum EntryLikeField {		
		id("id"),
		username("username"),
		entryId("entryId"),
		likeDate("likeDate"),
		collection("entryLike");
		
		private final String field;
		
		private EntryLikeField(String field) {
			this.field = field;
		}
		
		public String getField(){
			return field;
		}		
	}
}
