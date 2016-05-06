package com.bolatu.rest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolatu.service.api.request.user.QueryUserAuthInfoRequest;
import com.bolatu.service.api.request.user.UserProfileRequest;
import com.bolatu.service.api.response.user.QueryResetPasswordResponse;
import com.bolatu.service.api.response.user.QueryUserAuthInfoResponse;
import com.bolatu.service.api.response.user.ResetPasswordResponse;
import com.bolatu.service.api.response.user.UpdatePasswordResponse;
import com.bolatu.service.api.response.user.UpdateProfileResponse;
import com.bolatu.service.api.response.user.UserAuthResponse;
import com.bolatu.service.api.response.user.UserConfirmationResponse;
import com.bolatu.service.api.response.user.UserProfileResponse;
import com.bolatu.service.api.response.user.UserSignupResponse;
import com.bolatu.service.api.service.UserService;
import com.bolatu.service.impl.request.user.QueryResetPasswordRequestImpl;
import com.bolatu.service.impl.request.user.QueryUserAuthInfoRequestImpl;
import com.bolatu.service.impl.request.user.ResetPasswordRequestImpl;
import com.bolatu.service.impl.request.user.UpdatePasswordRequestImpl;
import com.bolatu.service.impl.request.user.UpdateProfileRequestImpl;
import com.bolatu.service.impl.request.user.UserAuthRequestImpl;
import com.bolatu.service.impl.request.user.UserConfirmationRequestImpl;
import com.bolatu.service.impl.request.user.UserProfileRequestImpl;
import com.bolatu.service.impl.request.user.UserSignupRequestImpl;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserAuthResponse authenticate(@RequestBody UserAuthRequestImpl userAuthRequest) {		
		return userService.authenticateUser(userAuthRequest);
	}
	
	@RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
	public UserProfileResponse userProfile(@PathVariable("username") String username) {
		UserProfileRequest request = new UserProfileRequestImpl(username);
		return userService.getUserProfile(request);
	}
	
	@RequestMapping(value = "/authInfo/{username}", method = RequestMethod.GET)
	public QueryUserAuthInfoResponse userAuthInfo(@PathVariable("username") String username) {
		QueryUserAuthInfoRequest request = new QueryUserAuthInfoRequestImpl(username);
		return userService.getUserAuthInfo(request);
	} 
		
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public UserSignupResponse userSignup(@RequestBody UserSignupRequestImpl userSignupRequest) {		
		return userService.signup(userSignupRequest);
	}	
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public UserConfirmationResponse signupConfirmation(@RequestBody UserConfirmationRequestImpl
			userConfirmationRequestImpl) {
		return userService.validateConfirmation(userConfirmationRequestImpl);
	}
	
	@RequestMapping(value = "/password/reset", method = RequestMethod.POST)
	public ResetPasswordResponse resetPassword(@RequestBody ResetPasswordRequestImpl
			resetPasswordRequestImpl) {
		return userService.resetPassword(resetPasswordRequestImpl);
	}
	
	@RequestMapping(value = "/password/reset/query", method = RequestMethod.POST)
	public QueryResetPasswordResponse queryResetPassword(@RequestBody QueryResetPasswordRequestImpl
			queryResetPasswordRequestImpl) {
		return userService.queryResetPasswordRequest(queryResetPasswordRequestImpl);
	}
	
	@RequestMapping(value = "/password/update", method = RequestMethod.POST)
	public UpdatePasswordResponse updatePassword(@RequestBody UpdatePasswordRequestImpl
			updatePasswordRequestImpl) {
		return userService.updatePassword(updatePasswordRequestImpl);
	}
	
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	public UpdateProfileResponse updateProfile(@RequestBody UpdateProfileRequestImpl
			updateProfileRequestImpl) {
		return userService.updateProfile(updateProfileRequestImpl);
	}

}
