package com.bolatu.db.api.model;

public interface ResetPasswordCode {
	
	public String getEmail();	
	public void setEmail(String email);
	
	public String getCode();
	public void setCode(String code);
	
	public char getType();
	public void setType(char type);
	
	public long getCreateTime();
	public void setCreateTime(long createTime);
	
	public String getRequestIp();
	public void setRequestIp(String requestIp);
	
}
