package com.bolatu.db.impl.criteria;

import java.util.Date;
import java.util.List;

import com.bolatu.db.api.criteria.UserLoginCriteria;
import com.bolatu.db.api.criteria.ValueInterval;

public class UserLoginCriteriaImpl extends BaseCriteriaImpl implements UserLoginCriteria {

	private List<String> idList;
	private List<String> usernameList;	
	private ValueInterval<Date> loginDateInterval;
	private List<String> loginLocationList;	
	private List<Character> loginSiteList;	
	private List<String> loginIpList;
	private List<String> sessionIdList;
	private Date logoutDateStart;
	private Date logoutDateEnd;
	
	public List<String> getIdList() {
		return idList;
	}
	
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	
	public List<String> getUsernameList() {
		return usernameList;
	}
	
	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}
	
	public ValueInterval<Date> getLoginDateInterval() {
		return loginDateInterval;
	}

	public void setLoginDateInterval(ValueInterval<Date> loginDateInterval) {
		this.loginDateInterval = loginDateInterval;
	}

	public List<String> getLoginLocationList() {
		return loginLocationList;
	}
	
	public void setLoginLocationList(List<String> loginLocationList) {
		this.loginLocationList = loginLocationList;
	}
	
	public List<Character> getLoginSiteList() {
		return loginSiteList;
	}
	
	public void setLoginSiteList(List<Character> loginSiteList) {
		this.loginSiteList = loginSiteList;
	}
	
	public List<String> getLoginIpList() {
		return loginIpList;
	}
	
	public void setLoginIpList(List<String> loginIpList) {
		this.loginIpList = loginIpList;
	}
	
	public List<String> getSessionIdList() {
		return sessionIdList;
	}
	
	public void setSessionIdList(List<String> sessionIdList) {
		this.sessionIdList = sessionIdList;
	}
	
	public Date getLogoutDateStart() {
		return logoutDateStart;
	}
	
	public void setLogoutDateStart(Date logoutDateStart) {
		this.logoutDateStart = logoutDateStart;
	}
	
	public Date getLogoutDateEnd() {
		return logoutDateEnd;
	}
	
	public void setLogoutDateEnd(Date logoutDateEnd) {
		this.logoutDateEnd = logoutDateEnd;
	}

	@Override
	public void resetCriteria() {
		
	}
	
}
