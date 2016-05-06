package com.bolatu.util.test;

import org.junit.Assert;
import org.junit.Test;

import com.bolatu.util.HashingUtil;

public class HashingUtilTest extends BaseTestConfig {
		
	@Test
	public void testGenerateSalt() {
		Assert.assertNotNull(HashingUtil.generateSalt());
	}
	
	@Test
	public void testGenerateSecurePassword() {
		Assert.assertNotNull(HashingUtil.generateSecurePassword("password", HashingUtil.generateSalt()));
	}
	
	@Test
	public void testGenerateGenerateHashFor() {
		Assert.assertNotNull(HashingUtil.generateHashFor("value"));
	}
	
	@Test
	public void testBCrypt() {
		Assert.assertNotEquals(HashingUtil.generateBCryptedHash("abaza31"), HashingUtil.generateBCryptedHash("abaza31"));
	}
	

}
