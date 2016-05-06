package com.bolatu.util.enumaration;

public enum MailTemplate {
	SIGNUP("signup.ftl", true),
	RESET_PASSWORD("reset_password.ftl", true),
	UPDATE_PASSWORD("update_password.ftl", true);
	
	private String fileName;
	private boolean isHtml;
	
	private MailTemplate(String fileName, boolean isHtml) {
		this.fileName = fileName;
		this.isHtml = isHtml;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public boolean isHtml() {
		return isHtml;
	}
	
}
