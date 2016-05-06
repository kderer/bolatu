package com.bolatu.rest.client.model;

import java.util.Date;

import com.bolatu.db.api.model.SignupConfirmation;

public class SignupConfirmationImpl implements SignupConfirmation {
	
	private String id;
	private String username;
	private String email;
	private String confirmationCode;
	private Date createDate;
	
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
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getConfirmationCode() {
		return confirmationCode;
	}
	
	@Override
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
	
	@Override
	public Date getCreateDate() {
		return createDate;
	}
	
	@Override
	public void setCreateDate(Date createdate) {
		this.createDate = createdate;
	}
	
	public static enum SignupConfirmationField {		
		id("id"),
		username("username"),
		email("email"),
		confirmationCode("confirmationCode"),
		createDate("createDate"),
		collection("signupConfirmation");
		
		private final String field;
		
		private SignupConfirmationField(String field){
			this.field = field;
		}
		
		public String getField(){
			return field;
		}		
	}

}
