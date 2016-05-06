package com.bolatu.util.enumaration;

public enum SortDirection {
	
	ASC(null, "ASC"),
	DESC(null, "DESC");
	
	private String desc;
	private String i18nKey;
	
	private SortDirection(String i18nKey, String desc) {
		this.desc = desc;
		this.i18nKey = i18nKey;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getI18nKey() {
		return this.i18nKey;
	}

}
