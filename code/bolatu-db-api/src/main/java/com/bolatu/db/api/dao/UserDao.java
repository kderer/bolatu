package com.bolatu.db.api.dao;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.UserCriteria;
import com.bolatu.db.api.model.Entry;
import com.bolatu.db.api.model.Message;
import com.bolatu.db.api.model.User;

public interface UserDao extends BaseDao<User, String, UserCriteria> {
	
	public User findByUsername(String username) throws BolatuDbException;
	
	public User findByEmail(String email) throws BolatuDbException;
	
	public User findMessageSender(Message message) throws BolatuDbException;
	
	public User findSenderByMessageId(String messageId) throws BolatuDbException;
	
	public User findMessageReceiver(Message message) throws BolatuDbException;
	
	public User findReceiverByMessageId(String messageId) throws BolatuDbException;
	
	public User findEntryPublisher(Entry entry) throws BolatuDbException;
	
	public User findPublisherByEntryId(String entryId) throws BolatuDbException;
	
	public void deleteByUsername(String username) throws BolatuDbException;
	
}
