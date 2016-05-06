package com.bolatu.db.api.criteria;

import java.util.List;

public interface ResetPasswordCodeCriteria extends BaseCriteria {
	
	public void addEmail(String email);
	
	public void setEmailList(List<String> emailList);
	
	public List<String> getEmailList();
	
	public void setCode(String code);
	
	public String getCode();
	
	public void addType(char type);
	
	public void setTypeList(List<Character> typeList);
	
	public List<Character> getTypeList();
}