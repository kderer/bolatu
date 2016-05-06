package com.bolatu.db.api.criteria;

import java.util.Date;
import java.util.List;

public interface SignupConfirmationCriteria extends BaseCriteria {
	public List<String> getIdList();
	
	public void setIdList(List<String> idList);
	
	public void addId(String id);
	
	public List<String> getUsernameList();

	public void setUsernameList(List<String> usernameList);
	
	public void addUsername(String username);

	public List<String> getEmailList();

	public void setEmailList(List<String> emailList);
	
	public void addEmail(String email);

	public List<String> getConfirmationCodeList();

	public void setConfirmationCode(List<String> confirmationCodeList);
	
	public void addConfirmationCode(String confirmationCode);

	public Date getCreateDateStart();

	public void setCreateDateStart(Date createDateStart);

	public Date getCreateDateEnd();

	public void setCreateDateEnd(Date createDateEnd);

	public void resetCriteria();
	
}
