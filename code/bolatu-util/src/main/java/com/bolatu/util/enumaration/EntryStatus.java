package com.bolatu.util.enumaration;

public enum EntryStatus {
	
	PENDING(null, 'P'),
	APPROVED(null, 'A'),
	REJECTED(null, 'R');
	
	private char code;
	private String i18nKey;
	
	private EntryStatus(String i18nKey, char code) {
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
