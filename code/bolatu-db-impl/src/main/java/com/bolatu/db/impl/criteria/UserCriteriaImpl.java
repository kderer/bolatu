package com.bolatu.db.impl.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bolatu.db.api.criteria.UserCriteria;
import com.bolatu.db.api.criteria.ValueInterval;


public class UserCriteriaImpl extends BaseCriteriaImpl implements UserCriteria {	
	private List<String> idList;
	private List<String> usernameList;
	private List<String> emailList;
	private List<String> phoneList;
	private List<String> locationList;
	private ValueInterval<Date> birthdayInterval;
	private List<String> genderList;
	private List<Character> statusList;
	private List<Character> userTypeList;
	private Date signupDateStart;
	private Date signupDateEnd;
	private List<Integer> rankList;
	
	public List<String> getIdList() {
		return idList;
	}
	
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	
	public void addId(String id) {
		if(idList == null) {
			idList = new ArrayList<String>();
		}
		idList.add(id);
	}
	
	public List<String> getUsernameList() {
		return usernameList;
	}
	
	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}
	
	public void addUsername(String username) {
		if(usernameList == null) {
			usernameList = new ArrayList<String>();
		}
		usernameList.add(username);
	}
	
	public List<String> getEmailList() {
		return emailList;
	}
	
	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}
	
	public void addEmail(String email) {
		if(emailList == null) {
			emailList = new ArrayList<String>();
		}
		emailList.add(email);
	}
	
	public List<String> getPhoneList() {
		return phoneList;
	}
	
	public void setPhoneList(List<String> phoneList) {
		this.phoneList = phoneList;
	}
	
	public void addPhone(String phone) {
		if(phoneList == null) {
			phoneList = new ArrayList<String>();
		}
		phoneList.add(phone);
	}
	
	public List<String> getLocationList() {
		return locationList;
	}
	
	public void setLocationList(List<String> locationList) {
		this.locationList = locationList;
	}
	
	public void addLocation(String location) {
		if(locationList == null) {
			locationList = new ArrayList<String>();
		}
		locationList.add(location);
	}
	
	public ValueInterval<Date> getBirthdayInterval() {
		return birthdayInterval;
	}

	public void setBirthdayInterval(ValueInterval<Date> birthdayInterval) {
		this.birthdayInterval = birthdayInterval;
	}

	public List<String> getGenderList() {
		return genderList;
	}
	
	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}
	
	public void addGender(String gender) {
		if(genderList == null) {
			genderList = new ArrayList<String>();
		}
		genderList.add(gender);
	}
	
	public List<Character> getStatusList() {
		return statusList;
	}	
	
	public void setStatusList(List<Character> statusList) {
		this.statusList = statusList;
	}
	
	public void addStatus(char status) {
		if(statusList == null) {
			statusList = new ArrayList<Character>();
		}
		statusList.add(status);
	}
	
	public List<Character> getUserTypeList() {
		return userTypeList;
	}

	public void setUserTypeList(List<Character> userTypeList) {
		this.userTypeList = userTypeList;
	}
	
	public void addUserType(char userType) {
		if(userTypeList == null) {
			userTypeList = new ArrayList<Character>();
		}
		userTypeList.add(userType);
	}
	
	public Date getSignupDateStart() {
		return signupDateStart;
	}
	
	public void setSignupDateStart(Date signupDateStart) {
		this.signupDateStart = signupDateStart;
	}
	
	public Date getSignupDateEnd() {
		return signupDateEnd;
	}
	
	public void setSignupDateEnd(Date signupDateEnd) {
		this.signupDateEnd = signupDateEnd;
	}
	
	public List<Integer> getRankList() {
		return rankList;
	}
	
	public void setRankList(List<Integer> rankList) {
		this.rankList = rankList;
	}
	
	public void addRank(Integer rank) {
		if(rankList == null) {
			rankList = new ArrayList<Integer>();
		}
		rankList.add(rank);
	}
		
	@Override
	public void resetCriteria() {
		
	}
	
}

	
