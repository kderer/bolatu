package com.bolatu.util.enumaration;

public enum ResetPasswordCodeType {
	
	RESET('R', null),
	UPDATE('U', null);
	
	private char siteCode;
	private String i18nKey;
	
	private ResetPasswordCodeType(char siteCode, String i18nKey) {
		this.siteCode = siteCode;
		this.i18nKey = i18nKey;
	}
	
	public char getCode() {
		return siteCode;
	}
	
	public String getI18nKey() {
		return i18nKey;
	}
	
}
