package com.bolatu.util.enumaration;

public enum YesNo {
	
	YES('Y', null),
	NO('N', null);
	
	private char code;
	private String i18nKey;
	
	private YesNo(char code, String i18nKey) {
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
