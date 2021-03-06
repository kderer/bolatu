package com.bolatu.db.impl.model.helper;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.bolatu.db.api.model.User;

public class EntryUser implements User {
	
	private String id;
	private String username;
	private String email;
	private String phone;
	private String location;
	private Date birthday;
	private String gender;
	private char status;
	private char userType;
	private Date signupDate;
	private int rank;
	
	public EntryUser() {
		
	}
	
	public EntryUser(User user) {
		BeanUtils.copyProperties(user, this);
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
}
