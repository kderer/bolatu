package com.bolatu.service.impl.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.service.api.request.user.QueryResetPasswordRequest;
import com.bolatu.service.api.request.user.QueryUserAuthInfoRequest;
import com.bolatu.service.api.request.user.ResetPasswordRequest;
import com.bolatu.service.api.request.user.UpdatePasswordRequest;
import com.bolatu.service.api.request.user.UserAuthRequest;
import com.bolatu.service.api.request.user.UserConfirmationRequest;
import com.bolatu.service.api.request.user.UserSignupRequest;
import com.bolatu.service.api.response.user.QueryResetPasswordResponse;
import com.bolatu.service.api.response.user.ResetPasswordResponse;
import com.bolatu.service.api.response.user.UpdatePasswordResponse;
import com.bolatu.service.api.response.user.UserAuthResponse;
import com.bolatu.service.api.response.user.UserConfirmationResponse;
import com.bolatu.service.api.response.user.UserSignupResponse;
import com.bolatu.service.api.service.UserService;
import com.bolatu.service.impl.request.user.QueryResetPasswordRequestImpl;
import com.bolatu.service.impl.request.user.QueryUserAuthInfoRequestImpl;
import com.bolatu.service.impl.request.user.ResetPasswordRequestImpl;
import com.bolatu.service.impl.request.user.UpdatePasswordRequestImpl;
import com.bolatu.service.impl.request.user.UserAuthRequestImpl;
import com.bolatu.service.impl.request.user.UserConfirmationRequestImpl;
import com.bolatu.service.impl.request.user.UserSignupRequestImpl;
import com.bolatu.util.constant.BolatuServiceReturnCodes;

public class UserServiceTest extends BaseTestConfig {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testSignup() {
		UserSignupRequest request = new UserSignupRequestImpl();
		request.setUsername("abaza31");
		request.setEmail("sanalized@hotmail.com");
		request.setPassword("3169");
		
		UserSignupResponse response = userService.signup(request);
		
		Assert.assertNotNull(response.getUser());
	}
	
	@Test
	public void testUserAuthentication() {
		UserAuthRequest req = new UserAuthRequestImpl("abaza31", "3169");
		
		UserAuthResponse response = userService.authenticateUser(req);
		
		Assert.assertNotEquals(response.getResultCode(), BolatuServiceReturnCodes.USER_STATUS_NOT_VALID);
	}
	
	@Test 
	public void testConfirmation() {
		UserConfirmationRequest request = new UserConfirmationRequestImpl("abaza31",
				"9c86d59d3bfa16819fe5384c8d143ddc");
		UserConfirmationResponse response = userService.validateConfirmation(request);
		
		Assert.assertNotNull(response.getResultCode());
	}
	
	@Test
	public void testQueryUserAuthInfo() {
		QueryUserAuthInfoRequest request = new QueryUserAuthInfoRequestImpl("abaza6931");
		
		Assert.assertNotNull(userService.getUserAuthInfo(request).getUserAuthInfo());
	}
	
	@Test
	public void testResetPasswordRequest() {
		ResetPasswordRequest request = new ResetPasswordRequestImpl();
		request.setEmail("kderer@hotmail.com");
		request.setServiceRequestInfo(getDefaultServiceRequestInfo());
		
		ResetPasswordResponse response = userService.resetPassword(request);
		
		Assert.assertEquals(BolatuServiceReturnCodes.SUCCESS, response.getResultCode());		
	}
	
	@Test
	public void testQueryResetPasswordRequest() {
		QueryResetPasswordRequest request = new QueryResetPasswordRequestImpl();
		request.setEmail("kderer@hotmail.com");
		request.setCode("c6e50cb364034cc09b6960f95db04805e55b46e535a34eff9fb7e575c23e83612e5a7b195f0c4fe9a9f0f9d500a18781");
		request.setServiceRequestInfo(getDefaultServiceRequestInfo());
		
		QueryResetPasswordResponse response = userService.queryResetPasswordRequest(request);
		
		Assert.assertEquals(BolatuServiceReturnCodes.SUCCESS, response.getResultCode());		
	}
	
	@Test
	public void testUpdatePassword() {		
		UpdatePasswordRequest request = new UpdatePasswordRequestImpl();
		request.setServiceRequestInfo(getDefaultServiceRequestInfo());
		request.setEmail("kderer@hotmail.com");
		request.setCode("152aaae8-2b85-4f99-a58e-b85fe3c2d6416f6674b3-3672-465b-b233-b48cc789a1b8");
		request.setPassword("123456");
		
		UpdatePasswordResponse response = userService.updatePassword(request);
		
		Assert.assertEquals(BolatuServiceReturnCodes.RESET_PASSWORD_REQUEST_NOT_FOUND, response.getResultCode());		
	}

}
