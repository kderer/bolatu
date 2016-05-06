package com.bolatu.util.enumaration;

public enum MessageStatus {
	
	ALL(null, 'A'),
	UNREAD(null, 'U'),
	READ(null, 'R'),
	DELETED(null, 'D'),
	NEW(null, 'N');
	
	private char code;
	private String i18nKey;
	
	private MessageStatus(String i18nKey, char code) {
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
