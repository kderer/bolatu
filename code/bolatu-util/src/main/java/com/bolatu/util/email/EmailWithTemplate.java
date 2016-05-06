package com.bolatu.util.email;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bolatu.util.enumaration.MailTemplate;

public class EmailWithTemplate {
	
	private String from;
	private List<String> toList;
	private List<String> ccList;
	private String subject;
	private MailTemplate template;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private List<File> attachmentList;	
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getToList() {
		return toList;
	}
	
	public void setToList(List<String> toList) {
		this.toList = toList;
	}
	
	public void addToToList(String address) {
		if(toList == null) {
			toList = new ArrayList<String>();
		}
		
		toList.add(address);
	}
	
	public String[] getToListArray() {
		if(toList != null) {
			return toList.toArray(new String[toList.size()]);
		}
		
		return null;
	}
	
	public List<String> getCcList() {
		return ccList;
	}
	
	public void setCcList(List<String> ccList) {
		this.ccList = ccList;
	}
	
	public void addToCcList(String address) {
		if(ccList == null) {
			ccList = new ArrayList<String>();
		}
		
		ccList.add(address);
	}
	
	public String[] getCcListArray() {
		if(ccList != null) {
			return ccList.toArray(new String[ccList.size()]);
		}
		
		return null;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public List<File> getAttachmentList() {
		return attachmentList;
	}
	
	public void setAttachmentList(List<File> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
	public void addAttachment(File file) {
		if(attachmentList == null) {
			attachmentList = new ArrayList<File>();
		}
		
		attachmentList.add(file);
	}

	public MailTemplate getTemplate() {
		return template;
	}

	public void setTemplate(MailTemplate template) {
		this.template = template;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void putData(String key, Object data) {
		dataMap.put(key, data);
	}
	
}
