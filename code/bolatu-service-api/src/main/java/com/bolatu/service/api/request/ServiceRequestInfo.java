package com.bolatu.service.api.request;

public interface ServiceRequestInfo {
	
	public void setLanguage(String language);
	
	public String getLanguage();
	
	public void setTimeZone(String timeZone);
	
	public String getTimeZone();
	
	public void setIp(String ip);
	
	public String getIp();
	
	public void setSite(char site);
	
	public char getSite();
	
	public String getUsername();
	
	public void setUsername(String username);
}
