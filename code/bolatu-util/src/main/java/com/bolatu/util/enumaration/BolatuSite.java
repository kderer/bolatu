package com.bolatu.util.enumaration;

public enum BolatuSite {
	
	WEB('W', null),
	MOBILE('M', null),
	ANDROID('A', null),
	IPHONE('I', null);
	
	private char siteCode;
	private String i18nKey;
	
	private BolatuSite(char siteCode, String i18nKey) {
		this.siteCode = siteCode;
		this.i18nKey = i18nKey;
	}
	
	public char getSiteCode() {
		return siteCode;
	}
	
	public String getI18nKey() {
		return i18nKey;
	}
	
}
