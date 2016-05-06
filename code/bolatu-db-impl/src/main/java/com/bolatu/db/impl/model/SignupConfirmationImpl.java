package com.bolatu.db.impl.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolatu.db.api.model.SignupConfirmation;

@Document(collection = "signupConfirmation")
public class SignupConfirmationImpl implements SignupConfirmation {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String username;
	
	@Indexed(unique = true)
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
