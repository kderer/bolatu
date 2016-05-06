package com.bolatu.db.api.criteria;

import java.util.Date;
import java.util.List;

public interface UserLoginCriteria extends BaseCriteria {
	
	public List<String> getIdList();
	
	public void setIdList(List<String> idList);
	
	public List<String> getUsernameList();
	
	public void setUsernameList(List<String> usernameList);
	
	public ValueInterval<Date> getLoginDateInterval();

	public void setLoginDateInterval(ValueInterval<Date> loginDateInterval);

	public List<String> getLoginLocationList();
	
	public void setLoginLocationList(List<String> loginLocationList);
	
	public List<Character> getLoginSiteList();
	
	public void setLoginSiteList(List<Character> loginSiteList);
	
	public List<String> getLoginIpList();
	
	public void setLoginIpList(List<String> loginIpList);
	
	public List<String> getSessionIdList();
	
	public void setSessionIdList(List<String> sessionIdList);
	
	public Date getLogoutDateStart();
	
	public void setLogoutDateStart(Date logoutDateStart);
	
	public Date getLogoutDateEnd();
	
	public void setLogoutDateEnd(Date logoutDateEnd);

}
