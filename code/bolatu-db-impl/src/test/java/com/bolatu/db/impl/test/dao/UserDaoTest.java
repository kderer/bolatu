package com.bolatu.db.impl.test.dao;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.UserCriteria;
import com.bolatu.db.api.dao.UserDao;
import com.bolatu.db.api.model.User;
import com.bolatu.db.impl.criteria.UserCriteriaImpl;
import com.bolatu.db.impl.model.UserImpl;
import com.bolatu.db.impl.test.BaseTestConfig;
import com.bolatu.util.data.PageResult;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.Gender;
import com.bolatu.util.enumaration.SortDirection;
import com.bolatu.util.enumaration.UserStatus;
import com.bolatu.util.enumaration.UserType;

public class UserDaoTest extends BaseTestConfig {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testFindOneByCriteria() throws Exception {
		UserCriteria criteria = new UserCriteriaImpl();
		criteria.addEmail("asd12345@asd.com");		
		
		Assert.assertNotNull(userDao.findOneByCriteria(criteria));
	}
	
	@Test
	public void testFindByCriteria() throws Exception {
		UserCriteria criteria = new UserCriteriaImpl();
		criteria.setPageNumber(1);
		criteria.setPageSize(5);
		criteria.addSortRequest(new SortRequest("email", SortDirection.ASC));
		
		PageResult<User> result = userDao.findByCriteria(criteria);
		
		Assert.assertEquals(6, result.getTotal(), 0);
		Assert.assertEquals(1, result.getPageNumber(), 0);
		Assert.assertEquals(5, result.getPageSize(), 0);
		Assert.assertEquals(1, result.getResultList().size());
	}
	
	@Test
	public void testSaveUser() throws BolatuDbException {
		Calendar ageCalendar = Calendar.getInstance();
		ageCalendar.add(Calendar.YEAR, -31);
		
		Calendar signupCalendar = Calendar.getInstance();
		signupCalendar.add(Calendar.DAY_OF_YEAR, -69);
		
		User user = new UserImpl();		
		user.setUsername("abaza6931");
		user.setEmail("asd1234@asd.com");
		user.setBirthday(ageCalendar.getTime());
		user.setGender(Gender.BI.getCode());
		user.setPhone("13916781345");
		user.setSignupDate(signupCalendar.getTime());
		user.setStatus(UserStatus.ACTIVE.getCode());
		user.setUserType(UserType.VIP.getCode());
		
		userDao.save(user);	
		
		Assert.assertNotNull(user.getId());
	}
	
	@Test
	public void testFindByUsername() throws BolatuDbException {
		Assert.assertNotNull(userDao.findByUsername("abaza6931"));
	}
	
	@Test
	public void testFindByEmail() throws BolatuDbException {
		Assert.assertNotNull(userDao.findByEmail("asd12345@asd.com"));
	}
	
	@Test
	public void testDeleteByUsername() throws BolatuDbException {
		UserCriteria criteria = new UserCriteriaImpl();
		criteria.addUsername("abaza6931");
		
		PageResult<User> result = userDao.findByCriteria(criteria);
		
		for (User user : result.getResultList()) {
			userDao.delete(user);
		}
		
		//userDao.deleteByUsername("abaza6932");
	}
	
	@Test
	public void testUpdateStatus() throws BolatuDbException {
		User user = userDao.findByUsername("abaza31");
		user.setStatus(UserStatus.ACTIVE.getCode());
		
		userDao.save(user);
	}

}
