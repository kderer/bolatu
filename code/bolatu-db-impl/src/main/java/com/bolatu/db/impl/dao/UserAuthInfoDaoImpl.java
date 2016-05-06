package com.bolatu.db.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.BaseCriteria;
import com.bolatu.db.api.dao.UserAuthInfoDao;
import com.bolatu.db.api.model.UserAuthInfo;
import com.bolatu.db.impl.model.UserAuthInfoImpl;
import com.bolatu.db.impl.model.UserAuthInfoImpl.UserAuthInfoField;
import com.bolatu.db.impl.repository.UserAuthInfoRepository;
import com.bolatu.util.DateUtil;
import com.bolatu.util.LogUtil;

@Service
public class UserAuthInfoDaoImpl extends BaseDaoImpl<UserAuthInfo, String, BaseCriteria> implements UserAuthInfoDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private UserAuthInfoRepository userAuthInfoRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	protected UserAuthInfoRepository getCrudRepository() {
		return userAuthInfoRepository;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Override
	protected void preSave(UserAuthInfo t) {
		
	}
	
	@Override
	protected void postSave(UserAuthInfo t) {
		
	}
	
	@Override
	protected void preDelete(UserAuthInfo t) {
		
	}
	
	@Override
	protected void postDelete(UserAuthInfo t) {
		
	}

	@Override
	protected Query generateQueryFromCriteria(BaseCriteria criteria) {
		Query query = new Query();
		return query;
	}

	@Override
	protected Class<? extends UserAuthInfo> getDocumentClass() {
		return UserAuthInfoImpl.class;
	}

	@Override
	protected String getDocumentName() {
		return UserAuthInfoImpl.UserAuthInfoField.collection.getField();
	}
	
	@Override
	public UserAuthInfo findByUsername(String username) throws BolatuDbException {
		try {
			return userAuthInfoRepository.findByUsername(username);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}

	@Override
	public void updateLastLogin(String username, String lastLoginIp,
			char lastLoginSite) throws BolatuDbException {
		Query query = new Query();
		query.addCriteria(Criteria.where(UserAuthInfoField.username.getField()).is(username));
		
		Update update = new Update();
		update.set(UserAuthInfoField.lastLoginIp.getField(), lastLoginIp);
		update.set(UserAuthInfoField.lastLoginSite.getField(), lastLoginSite);
		update.set(UserAuthInfoField.lastLoginDate.getField(), DateUtil.getCurrentTime());
		
		try {
			mongoOperations.findAndModify(query, update, getDocumentClass());
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}
}
