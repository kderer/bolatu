package com.bolatu.db.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bolatu.db.api.criteria.ResetPasswordCodeCriteria;
import com.bolatu.db.api.dao.ResetPasswordCodeDao;
import com.bolatu.db.api.model.ResetPasswordCode;
import com.bolatu.db.impl.model.ResetPasswordCodeImpl;
import com.bolatu.db.impl.model.ResetPasswordCodeImpl.ResetPasswordCodeField;
import com.bolatu.db.impl.repository.ResetPasswordCodeRepository;
import com.bolatu.util.StringUtil;

@Service
public class ResetPasswordCodeDaoImpl extends BaseDaoImpl<ResetPasswordCode, String, ResetPasswordCodeCriteria> implements ResetPasswordCodeDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private ResetPasswordCodeRepository resetPasswordCodeRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	protected ResetPasswordCodeRepository getCrudRepository() {
		return resetPasswordCodeRepository;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Override
	protected void preSave(ResetPasswordCode t) {
		
	}
	
	@Override
	protected void postSave(ResetPasswordCode t) {
		
	}
	
	@Override
	protected void preDelete(ResetPasswordCode t) {
		
	}
	
	@Override
	protected void postDelete(ResetPasswordCode t) {
		
	}

	@Override
	protected Query generateQueryFromCriteria(ResetPasswordCodeCriteria criteria) {
		Query query = new Query();
		
		if (!CollectionUtils.isEmpty(criteria.getEmailList())) {
			query.addCriteria(Criteria.where(ResetPasswordCodeField.email.getField()).in(criteria.getEmailList()));
		}
		
		if (!StringUtil.isNullOrEmpty(criteria.getCode())) {
			query.addCriteria(Criteria.where(ResetPasswordCodeField.code.getField()).is(criteria.getCode()));
		}
		
		if (!CollectionUtils.isEmpty(criteria.getTypeList())) {
			query.addCriteria(Criteria.where(ResetPasswordCodeField.type.getField()).in(criteria.getTypeList()));
		}
		
		return query;
	}

	@Override
	protected Class<? extends ResetPasswordCode> getDocumentClass() {
		return ResetPasswordCodeImpl.class;
	}

	@Override
	protected String getDocumentName() {
		return ResetPasswordCodeImpl.ResetPasswordCodeField.collection.getField();
	}	
	
}
