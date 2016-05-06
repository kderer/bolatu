package com.bolatu.db.api.dao;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.SignupConfirmationCriteria;
import com.bolatu.db.api.model.SignupConfirmation;

public interface SignupConfirmationDao extends BaseDao<SignupConfirmation, String, SignupConfirmationCriteria> {
	
	public void deleteByUsername(String username) throws BolatuDbException;
	
}
