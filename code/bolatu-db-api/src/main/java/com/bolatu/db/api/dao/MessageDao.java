package com.bolatu.db.api.dao;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.MessageCriteria;
import com.bolatu.db.api.model.Message;
import com.bolatu.util.enumaration.MessageStatus;

public interface MessageDao extends BaseDao<Message, String, MessageCriteria> {

	public void updateStatus(String messageId, MessageStatus status) throws BolatuDbException;
	
	public void deleteFromInbox(String messageId, String userId) throws BolatuDbException;
	
	public void deleteFromSent(String messageId, String userId) throws BolatuDbException;

}