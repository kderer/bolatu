package com.bolatu.rest.client.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.rest.client.service.request.user.QueryUserAuthInfoRequestImpl;
import com.bolatu.rest.client.service.request.user.UserSignupRequestImpl;
import com.bolatu.rest.client.test.BaseTestConfig;
import com.bolatu.service.api.request.user.QueryUserAuthInfoRequest;
import com.bolatu.service.api.request.user.UserSignupRequest;
import com.bolatu.service.api.response.user.UserSignupResponse;
import com.bolatu.service.api.service.UserService;

public class UserServiceClientTest extends BaseTestConfig {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void signupTest() {
		
		UserSignupRequest request = new UserSignupRequestImpl();
		request.setUsername("abaza31");
		request.setPassword("amgotmeme");
		request.setEmail("kderer@hotmail.com");
		
		UserSignupResponse response = userService.signup(request);
		
		Assert.assertNotNull(response.getUser().getEmail());
	}
	
	@Test
	public void testQueryUserAuthInfo() {
		QueryUserAuthInfoRequest request = new QueryUserAuthInfoRequestImpl("abaza31");
		
		Assert.assertNotNull(userService.getUserAuthInfo(request).getUserAuthInfo().getPassword());
		
	}

}
