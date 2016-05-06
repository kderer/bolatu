package com.bolatu.db.impl.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolatu.db.api.model.User;

@Document(collection = "user")
public class UserImpl implements User {
	
	@Id
	private String id;
	
	@Indexed(unique = true, sparse = true)
	private String username;
	
	@Indexed(unique = true, sparse = true)
	private String email;
	
	private String phone;
	
	@Indexed
	private String location;
	
	private Date birthday;
	
	private String gender;//m/f/l/g/b/t
	
	private char status;
	
	private char userType;
	
	private Date signupDate;
	
	private int rank;
	
	public UserImpl() {
		
	}	
	
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
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String getLocation() {
		return location;
	}
	
	@Override
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public Date getBirthday() {
		return birthday;
	}
	
	@Override
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
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
	public int getRank() {
		return rank;
	}

	@Override
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public char getUserType() {
		return userType;
	}

	@Override
	public void setUserType(char userType) {
		this.userType = userType;
	}

	@Override
	public Date getSignupDate() {
		return signupDate;
	}

	@Override
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public static enum UserField {		
		id("id"),
		username("username"),
		email("email"),
		phone("phone"),
		location("location"),
		birthday("birthday"),
		gender("gender"),
		status("status"),
		signupDate("signupDate"),
		userType("userType"),
		rank("rank"),
		collection("user");
		
		private final String field;
		
		private UserField(String field){
			this.field = field;
		}
		
		public String getField(){
			return field;
		}		
	}
}
