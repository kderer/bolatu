package com.bolatu.db.impl.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.dao.ResetPasswordCodeDao;
import com.bolatu.db.api.model.ResetPasswordCode;
import com.bolatu.db.impl.model.ResetPasswordCodeImpl;
import com.bolatu.db.impl.test.BaseTestConfig;
import com.bolatu.util.DateUtil;

public class ResetPasswordCodeTest extends BaseTestConfig {
	
	@Autowired
	private ResetPasswordCodeDao resetPasswordCodeDao;
	
	@Test
	public void testSave() throws Exception {
		ResetPasswordCode code = new ResetPasswordCodeImpl();
		code.setEmail("kderer@hotmail.com");
		code.setCode("sdfasdfsdfadsfswerertdfgdfg");
		code.setCreateTime(DateUtil.getCurrentTimeInMillis());
		code.setRequestIp("127.0.0.1");
		
		resetPasswordCodeDao.save(code);
		
		Assert.assertNotNull(resetPasswordCodeDao.findById(code.getEmail()));
	}
	
	@Test
	public void testDelete() throws Exception {
		resetPasswordCodeDao.deleteById("kderer@hotmail.com");
		
		Assert.assertNull(resetPasswordCodeDao.findById("kderer@hotmail.com"));
	}

}
