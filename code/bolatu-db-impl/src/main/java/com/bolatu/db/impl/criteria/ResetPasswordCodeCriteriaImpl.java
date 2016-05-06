package com.bolatu.db.impl.criteria;

import java.util.ArrayList;
import java.util.List;

import com.bolatu.db.api.criteria.ResetPasswordCodeCriteria;

public class ResetPasswordCodeCriteriaImpl extends BaseCriteriaImpl implements ResetPasswordCodeCriteria {

	private List<String> emailList;
	private String code;
	private List<Character> typeList;

	@Override
	public List<String> getEmailList() {
		return emailList;
	}

	@Override
	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}

	@Override
	public void addEmail(String email) {
		if (emailList == null) {
			emailList = new ArrayList<String>();
		}
		emailList.add(email);		
	}

	@Override
	public void resetCriteria() {
		
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void addType(char type) {
		if (typeList == null) {
			typeList = new ArrayList<Character>();
		}
		
		typeList.add(type);
	}

	@Override
	public void setTypeList(List<Character> typeList) {
		this.typeList = typeList;
	}

	@Override
	public List<Character> getTypeList() {
		return typeList;
	}
}
