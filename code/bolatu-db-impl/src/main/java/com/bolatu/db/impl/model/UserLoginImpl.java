package com.bolatu.db.impl.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolatu.db.api.model.UserLogin;

@Document(collection = "userLogin")
public class UserLoginImpl implements UserLogin {
	
	@Id
	private String id;
	
	private String username;
	
	private Date loginDate;
	
	private String loginLocation;
	
	private char loginSite;
	
	private String loginIp;
	
	private String sessionId;
	
	private Date logoutDate;
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public Date getLoginDate() {
		return loginDate;
	}
	
	@Override
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	@Override
	public String getLoginLocation() {
		return loginLocation;
	}
	
	@Override
	public void setLoginLocation(String loginLocation) {
		this.loginLocation = loginLocation;
	}
	
	@Override
	public char getLoginSite() {
		return loginSite;
	}
	
	@Override
	public void setLoginSite(char loginSite) {
		this.loginSite = loginSite;
	}
	
	@Override
	public String getLoginIp() {
		return loginIp;
	}
	
	@Override
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	@Override
	public Date getLogoutDate() {
		return logoutDate;
	}
	
	@Override
	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}

	@Override
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public static enum UserLoginField {		
		id("id"),
		username("username"),
		loginDate("loginDate"),
		loginLocation("loginLocation"),
		loginSite("loginSite"),
		loginIp("loginIp"),
		sessionId("sessionId"),
		logoutDate("logoutDate"),
		collection("userLogin");
		
		private final String field;
		
		private UserLoginField(String field){
			this.field = field;
		}
		
		public String getField(){
			return field;
		}		
	}

}
