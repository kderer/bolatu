package com.bolatu.db.api.model;

import java.util.Date;

public interface Message {
	
	public String getId();
	
	public void setSender(String sender);
	public String getSender();
	
	public void setReceiver(String receiver);
	public String getReceiver();
	
	public void setTitle(String title);
	public String getTitle();
	
	public void setContent(String content);
	public String getContent();
	
	public void setSentDate(Date sentDate);
	public Date getSentDate();
	
	public void setStatus(char status);
	public char getStatus();
	
	public void setDeletedFromInbox(char inboxDeleted);
	public char getDeletedFromInbox();
	
	public void setDeletedFromSent(char inboxDeleted);
	public char getDeletedFromSent();
	
	public Date getReadDate();
	public void setReadDate(Date readDate);
	
	public String getParentId();
	public void setParentId(String parentId);
	
	public String getTopLevelId();
	public void setTopLevelId(String topLevelId);

}
