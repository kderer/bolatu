package com.bolatu.db.impl.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.SignupConfirmationCriteria;
import com.bolatu.db.api.dao.SignupConfirmationDao;
import com.bolatu.db.api.model.SignupConfirmation;
import com.bolatu.db.impl.criteria.SignupConfirmationCriteriaImpl;
import com.bolatu.db.impl.model.SignupConfirmationImpl;
import com.bolatu.db.impl.test.BaseTestConfig;

public class SignupConfirmationDaoTest extends BaseTestConfig {

	@Autowired
	private SignupConfirmationDao signupConfirmationDao;
	
	@Test
	public void testSave() throws BolatuDbException {
		SignupConfirmation signupConfirmation = new SignupConfirmationImpl();
		signupConfirmation.setUsername("asdasd");
		signupConfirmation.setEmail("kderer.hotmail.com");
		signupConfirmation.setConfirmationCode("ASDdEdfsdfYghj1232dfs4%$#$%#");
		
		signupConfirmationDao.save(signupConfirmation);
		
		Assert.assertNotNull(signupConfirmation);		
	}
	
	@Test
	public void testDelete() throws BolatuDbException {
		signupConfirmationDao.deleteByUsername("asdasd");		
	}
	
	@Test
	public void testFindByCriteria() throws BolatuDbException {
		SignupConfirmationCriteria criteria = new SignupConfirmationCriteriaImpl();
		criteria.addEmail("sanalized@hotmail.com");
		
		System.out.println(signupConfirmationDao.findOneByCriteria(criteria).getConfirmationCode());
	}
}
