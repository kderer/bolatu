package com.bolatu.db.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.UserCriteria;
import com.bolatu.db.api.dao.EntryDao;
import com.bolatu.db.api.dao.MessageDao;
import com.bolatu.db.api.dao.UserDao;
import com.bolatu.db.api.model.Entry;
import com.bolatu.db.api.model.Message;
import com.bolatu.db.api.model.User;
import com.bolatu.db.impl.model.UserImpl;
import com.bolatu.db.impl.model.UserImpl.UserField;
import com.bolatu.db.impl.repository.UserRepository;
import com.bolatu.util.LogUtil;

@Service
public class UserDaoImpl extends BaseDaoImpl<User, String, UserCriteria> implements UserDao {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private EntryDao entryDao;	
	
	@Override
	public User findMessageSender(Message message) throws BolatuDbException {
		return findByUsername(message.getSender());
	}
	
	@Override
	public User findSenderByMessageId(String messageId) throws BolatuDbException {
		Message message = messageDao.findById(messageId);
		return findMessageSender(message);
	}
	
	@Override
	public User findMessageReceiver(Message message) throws BolatuDbException {
		return findByUsername(message.getReceiver());
	}
	
	@Override
	public User findReceiverByMessageId(String messageId) throws BolatuDbException {
		return findMessageReceiver(messageDao.findById(messageId));
	}	

	@Override
	public User findEntryPublisher(Entry entry) throws BolatuDbException {
		return findByUsername(entry.getUser().getUsername());
	}

	@Override
	protected void preSave(User user) {
		
	}
	
	@Override
	protected void postSave(User user) {
		
	}
	
	@Override
	protected void preDelete(User user) {
		
	}
	
	@Override
	protected void postDelete(User user) {
		
	}

	@Override
	public User findPublisherByEntryId(String entryId) throws BolatuDbException {
		return findById(entryDao.findById(entryId).getUser().getUsername());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected UserRepository getCrudRepository() {
		return userRepository;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Override
	protected Query generateQueryFromCriteria(UserCriteria userCriteria) {
		Query query = new Query();
		
		if(!CollectionUtils.isEmpty(userCriteria.getGenderList())){
			query.addCriteria(Criteria.where(UserField.gender.getField()).in(userCriteria.getGenderList()));
		}
		
		if(!CollectionUtils.isEmpty(userCriteria.getUsernameList())){
			query.addCriteria(Criteria.where(UserField.username.getField()).in(userCriteria.getUsernameList()));
		}
		
		if(!CollectionUtils.isEmpty(userCriteria.getIdList())){
			query.addCriteria(Criteria.where(UserField.id.getField()).in(userCriteria.getIdList()));
		}
		
		if(!CollectionUtils.isEmpty(userCriteria.getLocationList())){
			query.addCriteria(Criteria.where(UserField.location.getField()).in(userCriteria.getLocationList()));
		}
		
		if(!CollectionUtils.isEmpty(userCriteria.getGenderList())){
			query.addCriteria(Criteria.where(UserField.gender.getField()).in(userCriteria.getGenderList()));
		}
		
		if(!CollectionUtils.isEmpty(userCriteria.getEmailList())){
			query.addCriteria(Criteria.where(UserField.email.getField()).in(userCriteria.getEmailList()));
		}
		
		return query;
	}

	@Override
	protected Class<? extends User> getDocumentClass() {
		return UserImpl.class;
	}

	@Override
	protected String getDocumentName() {
		return UserImpl.UserField.collection.getField();
	}

	@Override
	public User findByUsername(String username) throws BolatuDbException {
		try {
			return userRepository.findByUsername(username);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}

	@Override
	public User findByEmail(String email) throws BolatuDbException {
		try {
			return userRepository.findByEmail(email);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}

	@Override
	public void deleteByUsername(String username) throws BolatuDbException {
		try {
			userRepository.deleteByUsername(username);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}		
	}
	
}


