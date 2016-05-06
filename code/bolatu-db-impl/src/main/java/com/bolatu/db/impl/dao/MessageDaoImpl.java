package com.bolatu.db.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.MessageCriteria;
import com.bolatu.db.api.dao.MessageDao;
import com.bolatu.db.api.model.Message;
import com.bolatu.db.impl.model.MessageImpl;
import com.bolatu.db.impl.model.MessageImpl.MessageField;
import com.bolatu.db.impl.repository.MessageRepository;
import com.bolatu.util.DateUtil;
import com.bolatu.util.enumaration.MessageStatus;
import com.bolatu.util.enumaration.YesNo;

@Service
public class MessageDaoImpl extends BaseDaoImpl<Message, String, MessageCriteria> implements MessageDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public void updateStatus(String messageId, MessageStatus status)
			throws BolatuDbException {
		Query query = createIsQuery(MessageField.id.getField(), messageId);
		Update update = new Update().set(MessageField.status.getField(), status.getCode());
		
		mongoOperations.findAndModify(query, update, getDocumentClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected MessageRepository getCrudRepository() {
		return messageRepository;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Override
	protected void preSave(Message message) {
		if(message.getId() == null) {
			message.setSentDate(DateUtil.getCurrentTime());
			message.setStatus(MessageStatus.UNREAD.getCode());
		}
	}
	
	@Override
	protected void postSave(Message t) {
		
	}
	
	@Override
	protected void preDelete(Message t) {
		
	}
	
	@Override
	protected void postDelete(Message t) {
		
	}

	@Override
	protected Query generateQueryFromCriteria(MessageCriteria messageCriteria) {
		Query query = new Query();
		
		if(!CollectionUtils.isEmpty(messageCriteria.getReceiverUserNicknameList())) {
			query.addCriteria(Criteria.where(MessageField.receiver.getField()).in(messageCriteria.getReceiverUserNicknameList()));
		}
		
		if(!CollectionUtils.isEmpty(messageCriteria.getSenderUserNickNameList())) {
			query.addCriteria(Criteria.where(MessageField.sender.getField()).in(messageCriteria.getSenderUserNickNameList()));
		}
		
		if(!CollectionUtils.isEmpty(messageCriteria.getStatusList())) {
			query.addCriteria(Criteria.where(MessageField.status.getField()).in(messageCriteria.getStatusList()));
		}
		
		if(!CollectionUtils.isEmpty(messageCriteria.getIds())) {
			query.addCriteria(Criteria.where(MessageField.id.getField()).in(messageCriteria.getIds()));
		}
		
		if(!CollectionUtils.isEmpty(messageCriteria.getMessageTitleList())) {
			query.addCriteria(Criteria.where(MessageField.title.getField()).in(messageCriteria.getMessageTitleList()));
		}
		
		if (messageCriteria.isDeletedFromInbox() != null) {
			if (messageCriteria.isDeletedFromInbox()) {
				query.addCriteria(Criteria.where(MessageField.deletedFromInbox.getField()).is(YesNo.YES.getCode()));
			}
			else {
				query.addCriteria(Criteria.where(MessageField.deletedFromInbox.getField()).ne(YesNo.YES.getCode()));
			}
		}
		
		if (messageCriteria.isDeletedFromSent() != null) {
			if (messageCriteria.isDeletedFromSent()) {
				query.addCriteria(Criteria.where(MessageField.deletedFromSent.getField()).is(YesNo.YES.getCode()));
			}
			else {
				query.addCriteria(Criteria.where(MessageField.deletedFromSent.getField()).ne(YesNo.YES.getCode()));
			}
		}
		
		return query;
	}

	@Override
	protected Class<? extends Message> getDocumentClass() {
		return MessageImpl.class;
	}

	@Override
	protected String getDocumentName() {
		return MessageImpl.MessageField.collection.getField();
	}

	@Override
	public void deleteFromInbox(String messageId, String userId) throws BolatuDbException {
		Query query = createIsQuery(MessageField.id.getField(), messageId);
		query.addCriteria(Criteria.where(MessageField.receiver.getField()).is(userId));
		
		Update update = new Update().set(MessageField.deletedFromInbox.getField(), YesNo.YES.getCode());
		
		mongoOperations.findAndModify(query, update, getDocumentClass());		
	}

	@Override
	public void deleteFromSent(String messageId, String userId) throws BolatuDbException {
		Query query = createIsQuery(MessageField.id.getField(), messageId);
		query.addCriteria(Criteria.where(MessageField.sender.getField()).is(userId));
		
		Update update = new Update().set(MessageField.deletedFromSent.getField(), YesNo.YES.getCode());
		
		mongoOperations.findAndModify(query, update, getDocumentClass());		
	}	
}
