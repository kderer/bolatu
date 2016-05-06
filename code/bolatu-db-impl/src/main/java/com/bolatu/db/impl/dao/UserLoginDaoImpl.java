package com.bolatu.db.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.bolatu.db.api.criteria.UserLoginCriteria;
import com.bolatu.db.api.dao.UserLoginDao;
import com.bolatu.db.api.model.UserLogin;
import com.bolatu.db.impl.model.UserLoginImpl;
import com.bolatu.db.impl.repository.UserLoginRepository;
import com.bolatu.util.DateUtil;

@Service
public class UserLoginDaoImpl extends BaseDaoImpl<UserLogin, String, UserLoginCriteria> implements UserLoginDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private UserLoginRepository userLoginRepository;

	@SuppressWarnings("unchecked")
	@Override
	protected UserLoginRepository getCrudRepository() {
		return userLoginRepository;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Override
	protected void preSave(UserLogin t) {
		t.setLoginDate(DateUtil.getCurrentTime());
	}
	
	@Override
	protected void postSave(UserLogin t) {
		
	}
	
	@Override
	protected void preDelete(UserLogin t) {
		
	}
	
	@Override
	protected void postDelete(UserLogin t) {
		
	}

	@Override
	protected Query generateQueryFromCriteria(UserLoginCriteria criteria) {
		Query query = new Query();
		return query;
	}

	@Override
	protected Class<? extends UserLogin> getDocumentClass() {
		return UserLoginImpl.class;
	}

	@Override
	protected String getDocumentName() {
		return UserLoginImpl.UserLoginField.collection.getField();
	}
}
