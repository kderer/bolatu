package com.bolatu.db.api.model;

import java.util.Date;

public interface UserAuthInfo {	
	
	public String getId();	
	
	public String getUsername();
	public void setUsername(String username);
	
	public String getPassword();
	public void setPassword(String password);
	
	public Date getPasswordLastUpdateDate();
	public void setPasswordLastUpdateDate(Date passwordLastUpdateDate);
	
	public String getPasswordLastUpdateIp();
	public void setPasswordLastUpdateIp(String ip);
	
	public Date getLastLoginDate();
	public void setLastLoginDate(Date date);
	
	public String getLastLoginIp();
	public void setLastLoginIp(String lastLoginIp);
	
	public String getLastLoginLocation();
	public void setLastLoginLocation(String lastLoginLocation);
	
	public char getLastLoginSite();
	public void setLastLoginSite(char lastLoginSite);
	
}
