package com.bolatu.util.enumaration;

public enum UserType {
	
	VIP('V', null),
	NORMAL('N', null),
	PAID('P', null);
	
	private char code;
	private String i18nKey;
	
	private UserType(char code, String i18nKey) {
		this.code = code;
		this.i18nKey = i18nKey;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public String getI18nKey() {
		return this.i18nKey;
	}

}
