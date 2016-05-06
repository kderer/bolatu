package com.bolatu.db.impl.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bolatu.db.api.criteria.MessageCriteria;

public class MessageCriteriaImpl extends BaseCriteriaImpl implements MessageCriteria {
	
	private final List<String> senderUserNicknameList = new ArrayList<String>();
	private final List<String> receiverUserNicknameList = new ArrayList<String>();
	private final List<String> messageTitleList = new ArrayList<String>();
	private final List<String> messageTextList = new ArrayList<String>();
	private Date sentDateStart;
	private Date sentDateEnd;
	private final List<Character> statusList = new ArrayList<Character>();
	private final List<String> ids = new ArrayList<String>();
	private Boolean isDeletedFromInbox;
	private Boolean isDeletedFromSent;
	
	@Override
	public void resetCriteria(){
		senderUserNicknameList.clear();
		receiverUserNicknameList.clear();
		messageTitleList.clear();
		messageTextList.clear();
		statusList.clear();
	}	
	
	@Override
	public void addSenderUsername(String senderNickname) {
		senderUserNicknameList.add(senderNickname);
	}
	
	@Override
	public List<String> getSenderUserNickNameList() {
		return senderUserNicknameList;
	}
	
	@Override
	public void addReceiverUsername(String receiverNickname) {
		receiverUserNicknameList.add(receiverNickname);
	}
	
	@Override
	public List<String> getReceiverUserNicknameList() {
		return receiverUserNicknameList;
	}
	
	@Override
	public void addMessageTitle(String messageTitle) {
		messageTitleList.add(messageTitle);
	}
	
	@Override
	public List<String> getMessageTitleList() {
		return messageTitleList;
	}
	
	@Override
	public void addMessageText(String messageText) {
		messageTextList.add(messageText);
	}
	
	@Override
	public List<String> getMessageTextList() {
		return messageTextList;
	}
	
	@Override
	public void setSentDateStart(Date sentDate) {
		this.sentDateStart = sentDate;
	}
	
	@Override
	public Date getSentDateStart() {
		return sentDateStart;
	}
	
	@Override
	public void setSentDateEnd(Date sentDate) {
		this.sentDateEnd = sentDate;
	}
	
	@Override
	public Date getSentDateEnd() {
		return sentDateEnd;
	}
	
	@Override
	public void addStatus(Character status) {
		if(status != null) {
			statusList.add(status);
		}		
	}
	
	@Override
	public List<Character> getStatusList() {
		return statusList;
	}

	@Override
	public void addId(String id) {
		ids.add(id);
	}

	@Override
	public void addIds(List<String> idList) {
		ids.addAll(idList);
	}
	
	@Override
	public List<String> getIds() {
		return ids;
	}

	@Override
	public void setDeletedFromSent(boolean deletedFromSent) {
		this.isDeletedFromSent = deletedFromSent;
	}

	@Override
	public Boolean isDeletedFromSent() {
		return isDeletedFromSent;
	}

	@Override
	public void setDeletedFromInbox(boolean deletedFromInbox) {
		this.isDeletedFromInbox = deletedFromInbox;
	}

	@Override
	public Boolean isDeletedFromInbox() {
		return isDeletedFromInbox;
	}

}
