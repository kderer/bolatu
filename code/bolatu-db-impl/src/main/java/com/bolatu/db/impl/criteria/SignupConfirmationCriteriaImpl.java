package com.bolatu.db.impl.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bolatu.db.api.criteria.SignupConfirmationCriteria;

public class SignupConfirmationCriteriaImpl extends BaseCriteriaImpl implements SignupConfirmationCriteria {

	private List<String> idList;
	private List<String> usernameList;
	private List<String> emailList;	
	private List<String> confirmationCodeList;	
	private Date createDateStart;
	private Date createDateEnd;
	
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

	public List<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}

	public List<String> getConfirmationCodeList() {
		return confirmationCodeList;
	}

	public void setConfirmationCode(List<String> confirmationCodeList) {
		this.confirmationCodeList = confirmationCodeList;
	}

	public Date getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(Date createDateStart) {
		this.createDateStart = createDateStart;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	@Override
	public void resetCriteria() {
		
	}

	@Override
	public void addId(String id) {
		if (idList == null) {
			idList = new ArrayList<String>();
		}
		idList.add(id);
	}

	@Override
	public void addUsername(String username) {
		if (usernameList == null) {
			usernameList = new ArrayList<String>();
		}
		usernameList.add(username);		
	}

	@Override
	public void addEmail(String email) {
		if (emailList == null) {
			emailList = new ArrayList<String>();
		}
		emailList.add(email);		
	}

	@Override
	public void addConfirmationCode(String confirmationCode) {
		if (confirmationCodeList == null) {
			confirmationCodeList = new ArrayList<String>();
		}
		confirmationCodeList.add(confirmationCode);		
	}
	
}
