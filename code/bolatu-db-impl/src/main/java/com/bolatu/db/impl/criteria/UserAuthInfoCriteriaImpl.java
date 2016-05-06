package com.bolatu.db.impl.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bolatu.db.api.criteria.UserAuthInfoCriteria;
import com.bolatu.db.api.criteria.ValueInterval;

public class UserAuthInfoCriteriaImpl extends BaseCriteriaImpl implements UserAuthInfoCriteria {
	
	private List<String> idList;
	private List<String> usernameList;
	private ValueInterval<Date> passwordLastUpdateDateInterval;
	private ValueInterval<Date> lastLoginDateInterval;
	private List<String> lastLoginIpList;
	private List<Character> lastLoginSiteList;
	private List<String> lastLoginLocationList;
	
	public List<String> getIdList() {
		return idList;
	}
	
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	
	public void addId(String id) {
		if (idList == null) {
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
		if (usernameList == null) {
			usernameList = new ArrayList<String>();
		}
		usernameList.add(username);
	}
	
	public ValueInterval<Date> getPasswordLastUpdateDateInterval() {
		return passwordLastUpdateDateInterval;
	}
	
	public void setPasswordLastUpdateDateInterval(
			ValueInterval<Date> passwordLastUpdateDateInterval) {
		this.passwordLastUpdateDateInterval = passwordLastUpdateDateInterval;
	}
	
	public ValueInterval<Date> getLastLoginDateInterval() {
		return lastLoginDateInterval;
	}
	public void setLastLoginDateInterval(ValueInterval<Date> lastLoginDateInterval) {
		this.lastLoginDateInterval = lastLoginDateInterval;
	}
	
	public List<String> getLastLoginIpList() {
		return lastLoginIpList;
	}
	
	public void setLastLoginIpList(List<String> lastLoginIpList) {
		this.lastLoginIpList = lastLoginIpList;
	}
	
	public void addLastLoginIp(String lastLoginIp) {
		if (lastLoginIpList == null) {
			lastLoginIpList = new ArrayList<String>();
		}
		lastLoginIpList.add(lastLoginIp);
	}
	
	public List<Character> getLastLoginSiteList() {
		return lastLoginSiteList;
	}
	
	public void setLastLoginSiteList(List<Character> lastLoginSiteList) {
		this.lastLoginSiteList = lastLoginSiteList;
	}
	
	public void addLastLoginSite(Character lastLoginSite) {
		if (lastLoginSiteList == null) {
			lastLoginSiteList = new ArrayList<Character>();
		}
		lastLoginSiteList.add(lastLoginSite);
	}
	
	public List<String> getLastLoginLocationList() {
		return lastLoginLocationList;
	}
	
	public void setLastLoginLocationList(List<String> lastLoginLocationList) {
		this.lastLoginLocationList = lastLoginLocationList;
	}

	@Override
	public void resetCriteria() {
		// TODO Auto-generated method stub
		
	}	
	
	
}
