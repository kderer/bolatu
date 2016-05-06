package com.bolatu.rest.client.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.bolatu.rest.client.BolatuRestClient;
import com.bolatu.rest.client.service.response.user.QueryResetPasswordResponseImpl;
import com.bolatu.rest.client.service.response.user.QueryUserAuthInfoResponseImpl;
import com.bolatu.rest.client.service.response.user.ResendConfirmationCodeResponseImpl;
import com.bolatu.rest.client.service.response.user.ResetPasswordResponseImpl;
import com.bolatu.rest.client.service.response.user.UpdatePasswordResponseImpl;
import com.bolatu.rest.client.service.response.user.UpdateProfileResponseImpl;
import com.bolatu.rest.client.service.response.user.UserAuthResponseImpl;
import com.bolatu.rest.client.service.response.user.UserConfirmationResponseImpl;
import com.bolatu.rest.client.service.response.user.UserProfileResponseImpl;
import com.bolatu.rest.client.service.response.user.UserSignupResponseImpl;
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
import com.bolatu.service.api.service.UserService;
import com.bolatu.util.I18NUtil;
import com.bolatu.util.constant.BolatuRestClientExceptionCodes;


@Service
public class UserServiceClient implements UserService {
	
	@Autowired
	private BolatuRestClient restClient;
	
	@Override
	public UserProfileResponse getUserProfile(UserProfileRequest userProfileRequest) {		
		String url = restClient.createUrl("user/profile/{username}");
		UserProfileResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().getForObject(url, UserProfileResponseImpl.class,
					userProfileRequest.getUsername());
		} catch(ResourceAccessException raEx) {
			response = new UserProfileResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new UserProfileResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}
	
	public UserAuthResponse authenticateUser(UserAuthRequest userAuthRequest) {		
		String url = restClient.createUrl("user/login");
		UserAuthResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					userAuthRequest, UserAuthResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new UserAuthResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new UserAuthResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public UserSignupResponse signup(UserSignupRequest userSignupRequest) {
		String url = restClient.createUrl("user/signup");
		UserSignupResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					userSignupRequest, UserSignupResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new UserSignupResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new UserSignupResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public UserConfirmationResponse validateConfirmation(
			UserConfirmationRequest userConfirmationRequest) {
		String url = restClient.createUrl("user/confirm");
		UserConfirmationResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					userConfirmationRequest, UserConfirmationResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new UserConfirmationResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new UserConfirmationResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public QueryUserAuthInfoResponse getUserAuthInfo(
			QueryUserAuthInfoRequest queryUserAuthInfoRequest) {
		String url = restClient.createUrl("user/authInfo/{username}");
		QueryUserAuthInfoResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().getForObject(url, QueryUserAuthInfoResponseImpl.class,
					queryUserAuthInfoRequest.getUsername());
		} catch(ResourceAccessException raEx) {
			response = new QueryUserAuthInfoResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new QueryUserAuthInfoResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public ResendConfirmationCodeResponse resendConfirmationCode(
			ResendConfirmationCodeRequest resendConfirmationCodeRequest) {
		String url = restClient.createUrl("user/resendConfirmationCode");
		ResendConfirmationCodeResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().getForObject(url, ResendConfirmationCodeResponseImpl.class,
					resendConfirmationCodeRequest.getUsername());
		} catch(ResourceAccessException raEx) {
			response = new ResendConfirmationCodeResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new ResendConfirmationCodeResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
		String url = restClient.createUrl("user/password/reset");
		ResetPasswordResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					resetPasswordRequest, ResetPasswordResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new ResetPasswordResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new ResetPasswordResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public QueryResetPasswordResponse queryResetPasswordRequest(QueryResetPasswordRequest queryResetPasswordRequest) {
		String url = restClient.createUrl("user/password/reset/query");
		QueryResetPasswordResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					queryResetPasswordRequest, QueryResetPasswordResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new QueryResetPasswordResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new QueryResetPasswordResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public UpdatePasswordResponse updatePassword(UpdatePasswordRequest updatePasswordRequest) {
		String url = restClient.createUrl("user/password/update");
		UpdatePasswordResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					updatePasswordRequest, UpdatePasswordResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new UpdatePasswordResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new UpdatePasswordResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest) {
		String url = restClient.createUrl("user/profile/update");
		UpdateProfileResponse response =  null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					updateProfileRequest, UpdateProfileResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new UpdateProfileResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new UpdateProfileResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}
}
