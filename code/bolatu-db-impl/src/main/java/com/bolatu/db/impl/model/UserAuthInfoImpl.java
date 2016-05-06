package com.bolatu.db.impl.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolatu.db.api.model.UserAuthInfo;

@Document(collection = "userAuthInfo")
public class UserAuthInfoImpl implements UserAuthInfo {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String username;
	
	private String password;
	
	private Date passwordLastUpdateDate;
	
	private String passwordLastUpdateIp;
	
	private Date lastLoginDate;
	
	private String lastLoginIp;
	
	private char lastLoginSite;
	
	private String lastLoginLocation;
	
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
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Date getPasswordLastUpdateDate() {
		return passwordLastUpdateDate;
	}

	@Override
	public void setPasswordLastUpdateDate(Date passwordLastUpdateDate) {
		this.passwordLastUpdateDate = passwordLastUpdateDate;
	}

	@Override
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	
	@Override
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public char getLastLoginSite() {
		return lastLoginSite;
	}

	@Override
	public void setLastLoginSite(char lastLoginSite) {
		this.lastLoginSite = lastLoginSite;
	}

	@Override
	public String getLastLoginLocation() {
		return lastLoginLocation;
	}

	@Override
	public void setLastLoginLocation(String lastLoginLocation) {
		this.lastLoginLocation = lastLoginLocation;
	}
	
	@Override
	public String getPasswordLastUpdateIp() {
		return passwordLastUpdateIp;
	}

	@Override
	public void setPasswordLastUpdateIp(String ip) {
		this.passwordLastUpdateIp = ip;
	}	
	
	public static enum UserAuthInfoField {		
		id("id"),
		username("username"),
		password("password"),
		passwordLastUpdateDate("passwordLastUpdateDate"),
		passwordLastUpdateIp("passwordLastUpdateIp"),
		lastLoginDate("lastLoginDate"),
		lastLoginIp("lastLoginIp"),
		lastLoginSite("lastLoginSite"),
		lastLoginLocation("lastLoginLocation"),
		collection("userAuthInfo");
		
		private final String field;
		
		private UserAuthInfoField(String field){
			this.field = field;
		}
		
		public String getField(){
			return field;
		}		
	}	
	
}
