package com.bolatu.db.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.SignupConfirmationCriteria;
import com.bolatu.db.api.dao.SignupConfirmationDao;
import com.bolatu.db.api.model.SignupConfirmation;
import com.bolatu.db.impl.model.SignupConfirmationImpl;
import com.bolatu.db.impl.repository.SignupConfirmationRepository;
import com.bolatu.util.LogUtil;

@Service
public class SignupConfirmationDaoImpl extends BaseDaoImpl<SignupConfirmation, String, SignupConfirmationCriteria> implements SignupConfirmationDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private SignupConfirmationRepository signupConfirmationRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	protected SignupConfirmationRepository getCrudRepository() {
		return signupConfirmationRepository;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Override
	protected void preSave(SignupConfirmation t) {
		
	}
	
	@Override
	protected void postSave(SignupConfirmation t) {
		
	}
	
	@Override
	protected void preDelete(SignupConfirmation t) {
		
	}
	
	@Override
	protected void postDelete(SignupConfirmation t) {
		
	}

	@Override
	protected Query generateQueryFromCriteria(SignupConfirmationCriteria criteria) {
		Query query = new Query();
		return query;
	}

	@Override
	protected Class<? extends SignupConfirmation> getDocumentClass() {
		return SignupConfirmationImpl.class;
	}

	@Override
	protected String getDocumentName() {
		return SignupConfirmationImpl.SignupConfirmationField.collection.getField();
	}

	@Override
	public void deleteByUsername(String username) throws BolatuDbException {
		try {
			signupConfirmationRepository.deleteByUsername(username);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
	}	
	
}
