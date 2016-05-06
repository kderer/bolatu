package com.bolatu.db.api.criteria;

import java.util.Date;
import java.util.List;

public interface MessageCriteria extends BaseCriteria {
	
	public void addSenderUsername(String senderNickname);
	public List<String> getSenderUserNickNameList();
	
	public void addReceiverUsername(String receiverNickname);
	public List<String> getReceiverUserNicknameList();
	
	public void addMessageTitle(String messageTitle);
	public List<String> getMessageTitleList();
	
	public void addMessageText(String messageText);
	public List<String> getMessageTextList();
	
	public void setSentDateStart(Date sentDate);
	public Date getSentDateStart();
	
	public void setSentDateEnd(Date sentDate);
	public Date getSentDateEnd();
	
	public void addStatus(Character status);
	public List<Character> getStatusList();
	
	public void setDeletedFromSent(boolean deletedFromSent);
	public Boolean isDeletedFromSent();
	
	public void setDeletedFromInbox(boolean deletedFromInbox);
	public Boolean isDeletedFromInbox();
	
	public void addId(String id);	
	public void addIds(List<String> idList);
	public List<String> getIds();

}
