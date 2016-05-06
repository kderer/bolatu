package com.bolatu.db.api.model;

import java.util.Date;

public interface UserLogin {	
	
	public String getId();
	
	public String getUsername();
	public void setUsername(String username);
	
	public Date getLoginDate();
	public void setLoginDate(Date loginDate);
	
	public String getLoginLocation();
	public void setLoginLocation(String loginLocation);
	
	public char getLoginSite();
	public void setLoginSite(char lastLoginSite);
	
	public String getSessionId();
	public void setSessionId(String sessionId);
	
	public String getLoginIp();
	public void setLoginIp(String loginIp);
	
	public Date getLogoutDate();
	public void setLogoutDate(Date logoutDate);
}
