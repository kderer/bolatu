package com.bolatu.db.impl.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolatu.db.api.model.Entry;
import com.bolatu.db.api.model.User;
import com.bolatu.db.impl.model.helper.EntryUser;
import com.bolatu.util.StringUtil;

@Document(collection = "entry")
public class EntryImpl implements Entry {
	
	@Id
	private String id;
	
	private String title;
	private String text;
	//This should be an implementation since spring directly instantiate
	//object from the data and should have a default constructor
	//Also, used a helper model here because unique indexes in UserImpl class
	//are inherited to Entry document and cannot insert more than one entry of same user
	private EntryUser user;
	private String targetGender;
	private char targetAgeRange;
	private String ip;
	private GeoJsonPoint geoJsonLoc;
	
	@Transient
	private String selectedLocation;
	
	private String tags;
	private Date postDate;
	private char status;
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
	public void setUser(User user) {
		if (user instanceof EntryUser) {
			this.user = (EntryUser)user;
		}
		else if (user != null){
			this.user = new EntryUser(user);
		}		
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
		if (geoJsonLoc != null) {
			selectedLocation = geoJsonLoc.getX() + "," + geoJsonLoc.getY(); 		
		}
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

	@Override
	public List<String> getLikedUserList() {
		return likedUserList != null ? likedUserList : new ArrayList<String>();
	}
	
	@Override
	public void setLikedUserList(List<String> likedUserList) {
		this.likedUserList = likedUserList;
	}
	
	public GeoJsonPoint getGeoJsonLoc() {
		if (geoJsonLoc == null && !StringUtil.isNullOrEmpty(selectedLocation)) {
			String[] coordinates = selectedLocation.split(",");
			if (coordinates.length == 2) {
				geoJsonLoc = new GeoJsonPoint(Double.parseDouble(coordinates[0]),
					Double.parseDouble(coordinates[0]));
			}
		}
		
		return geoJsonLoc;
	}

	public void setGeoJsonLoc(GeoJsonPoint geoJsonLoc) {
		this.geoJsonLoc = geoJsonLoc;
	}
	
	public static enum EntryField {		
		id("id"),
		title("title"),
		text("text"),
		user("user"),
		targetGender("targetGender"),
		targetAgeRange("targetAgeRange"),
		ip("ip"),
		selectedLocation("selectedLocation"),
		geoJsonLoc("geoJsonLoc"),
		tags("tags"),
		postDate("postDate"),
		status("status"),
		likedCount("likedCount"),
		likedUserList("likedUserList"),
		collection("entry");
		
		private final String field;
		
		private EntryField(String field) {
			this.field = field;
		}
		
		public String getField(){
			return field;
		}		
	}
	
}