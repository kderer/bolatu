package com.bolatu.db.api.criteria;

import java.util.Date;
import java.util.List;

public interface UserCriteria extends BaseCriteria{
	
	public List<String> getIdList();
	
	public void setIdList(List<String> idList);
	
	public void addId(String id);
	
	public List<String> getUsernameList();
	
	public void setUsernameList(List<String> usernameList);
	
	public void addUsername(String username);
	
	public List<String> getEmailList();
	
	public void setEmailList(List<String> emailList);
	
	public void addEmail(String email);
	
	public List<String> getPhoneList();
	
	public void setPhoneList(List<String> phoneList);
	
	public void addPhone(String phone);
	
	public List<String> getLocationList();
	
	public void setLocationList(List<String> locationList);
	
	public void addLocation(String location);
	
	public ValueInterval<Date> getBirthdayInterval();

	public void setBirthdayInterval(ValueInterval<Date> birthdayInterval);
	
	public List<String> getGenderList();
	
	public void setGenderList(List<String> genderList);
	
	public void addGender(String gender);
	
	public List<Character> getStatusList();
	
	public void setStatusList(List<Character> statusList);
	
	public void addStatus(char status);
	
	public List<Character> getUserTypeList();

	public void setUserTypeList(List<Character> userTypeList);
	
	public void addUserType(char userType);
	
	public Date getSignupDateStart();
	
	public void setSignupDateStart(Date signupDateStart);
	
	public Date getSignupDateEnd();
	
	public void setSignupDateEnd(Date signupDateEnd);
	
	public List<Integer> getRankList();
	
	public void setRankList(List<Integer> rankList);
	
	public void addRank(Integer rank);
}
