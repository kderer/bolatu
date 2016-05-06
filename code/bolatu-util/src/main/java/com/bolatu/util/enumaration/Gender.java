package com.bolatu.util.enumaration;

public enum Gender {
	
	MALE(null, "M"),
	FEMALE(null, "F"),
	BI(null, "B"),
	GAY(null, "G"),
	LES(null, "L"),
	TRANNY(null, "T");
	
	private String code;
	private String i18nKey;
	
	private Gender(String i18nKey, String code) {
		this.code = code;
		this.i18nKey = i18nKey;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getI18nKey() {
		return this.i18nKey;
	}

}
