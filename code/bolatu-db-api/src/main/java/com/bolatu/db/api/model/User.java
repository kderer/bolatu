package com.bolatu.db.api.model;

import java.util.Date;


public interface User {	
	
	public String getId();	
	
	public String getUsername();
	public void setUsername(String username);
	
	public String getEmail();
	public void setEmail(String email);
	
	public char getUserType();
	public void setUserType(char userType);
	
	public String getPhone();
	public void setPhone(String phone);
	
	public String getLocation();
	public void setLocation(String Location);
	
	public Date getBirthday();
	public void setBirthday(Date birthday);
	
	public String getGender();
	public void setGender(String gender);
	
	public Date getSignupDate();
	public void setSignupDate(Date signupDate);
	
	public char getStatus();
	public void setStatus(char blocked);
	
	public int getRank();
	public void setRank(int rank);	
	
}
