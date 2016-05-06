package com.bolatu.service.api.service;

import com.bolatu.service.api.request.user.QueryResetPasswordRequest;
import com.bolatu.service.api.request.user.QueryUserAuthInfoRequest;
import com.bolatu.service.api.request.user.ResendConfirmationCodeRequest;
import com.bolatu.service.api.request.user.ResetPasswordRequest;
import com.bolatu.service.api.request.user.UpdatePasswordRequest;
import com.bolatu.service.api.request.user.UpdateProfileRequest;
import com.bolatu.service.api.request.user.UserAuthRequest;
import com.bolatu.service.api.request.user.UserConfirmationRequest;
import com.bolatu.service.api.request.user.UserProfileRequest;
import com.bolatu.service.api.request.user.UserSignupRequest;
import com.bolatu.service.api.response.user.QueryResetPasswordResponse;
import com.bolatu.service.api.response.user.QueryUserAuthInfoResponse;
import com.bolatu.service.api.response.user.ResendConfirmationCodeResponse;
import com.bolatu.service.api.response.user.ResetPasswordResponse;
import com.bolatu.service.api.response.user.UpdatePasswordResponse;
import com.bolatu.service.api.response.user.UpdateProfileResponse;
import com.bolatu.service.api.response.user.UserAuthResponse;
import com.bolatu.service.api.response.user.UserConfirmationResponse;
import com.bolatu.service.api.response.user.UserProfileResponse;
import com.bolatu.service.api.response.user.UserSignupResponse;


public interface UserService {
	
	public UserAuthResponse authenticateUser(UserAuthRequest userAuthRequest);
	
	public UserSignupResponse signup(UserSignupRequest userSignupRequest);
	
	public UserProfileResponse getUserProfile(UserProfileRequest userProfileRequest);
	
	public UserConfirmationResponse validateConfirmation(UserConfirmationRequest userConfirmationRequest);
	
	public QueryUserAuthInfoResponse getUserAuthInfo(QueryUserAuthInfoRequest queryUserAuthInfoRequest);
	
	public ResendConfirmationCodeResponse resendConfirmationCode(ResendConfirmationCodeRequest resendConfirmationCodeRequest);
	
	public ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest);
	
	public QueryResetPasswordResponse queryResetPasswordRequest(QueryResetPasswordRequest queryResetPasswordRequest);
	
	public UpdatePasswordResponse updatePassword(UpdatePasswordRequest updatePasswordRequest);
	
	public UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest);

}
