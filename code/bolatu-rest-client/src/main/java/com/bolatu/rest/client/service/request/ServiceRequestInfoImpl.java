package com.bolatu.rest.client.service.request;

import com.bolatu.service.api.request.ServiceRequestInfo;

public class ServiceRequestInfoImpl implements ServiceRequestInfo {

	private String language;
	private String timeZone;
	private String ip;
	private char site;
	private String username;
	
	@Override
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String getLanguage() {
		return language;
	}

	@Override
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public String getTimeZone() {
		return timeZone;
	}

	@Override
	public String getIp() {
		return ip;
	}

	@Override
	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public char getSite() {
		return site;
	}

	@Override
	public void setSite(char site) {
		this.site = site;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
