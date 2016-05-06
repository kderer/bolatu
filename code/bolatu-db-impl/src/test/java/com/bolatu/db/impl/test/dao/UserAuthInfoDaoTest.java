package com.bolatu.db.impl.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.dao.UserAuthInfoDao;
import com.bolatu.db.api.model.UserAuthInfo;
import com.bolatu.db.impl.model.UserAuthInfoImpl;
import com.bolatu.db.impl.test.BaseTestConfig;
import com.bolatu.util.enumaration.BolatuSite;

public class UserAuthInfoDaoTest extends BaseTestConfig {
	
	@Autowired
	private UserAuthInfoDao userAuthInfoDao;
	
	@Test
	public void testSave() throws BolatuDbException {
		UserAuthInfo userAuthInfo = new UserAuthInfoImpl();
		
		userAuthInfo.setUsername("abaza69");
		userAuthInfo.setPassword("amgotmeme");
		
		userAuthInfoDao.save(userAuthInfo);
		
		Assert.assertNotNull(userAuthInfo.getId());		
	}
	
	@Test
	public void testFindByUsername() throws BolatuDbException {
		Assert.assertNotNull(userAuthInfoDao.findByUsername("abaza69"));
	}
	
	@Test
	public void testUpdateLastLoginInfo() throws BolatuDbException {
		userAuthInfoDao.updateLastLogin("abaza31", "31.31.31.31", BolatuSite.IPHONE.getSiteCode());
		
		System.out.println(userAuthInfoDao.findByUsername("abaza31").getLastLoginDate());
	}
	
	

}
