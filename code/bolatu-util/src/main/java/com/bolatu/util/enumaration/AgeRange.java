package com.bolatu.util.enumaration;

public enum AgeRange {
	NONE('N', null),
	UNDER18('A', null),
	F18T25('B', null),
	F25T30('C', null),
	F30T40('D', null),
	F40T50('E', null),
	OVER50('F', null);
	
	private char code;
	private String i18nKey;
	
	private AgeRange(char siteCode, String i18nKey) {
		this.code = siteCode;
		this.i18nKey = i18nKey;
	}
	
	public char getCode() {
		return code;
	}
	
	public String getI18nKey() {
		return i18nKey;
	}
	
}
