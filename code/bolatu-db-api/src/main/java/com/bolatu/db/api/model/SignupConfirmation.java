package com.bolatu.db.api.model;

import java.util.Date;

public interface SignupConfirmation {	
	
	public String getId();
	
	public String getUsername();
	public void setUsername(String username);
	
	public String getEmail();
	public void setEmail(String email);
	
	public String getConfirmationCode();
	public void setConfirmationCode(String confirmationCode);
	
	public Date getCreateDate();
	public void setCreateDate(Date createDate);

}
