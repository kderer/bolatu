package com.bolatu.service.impl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.ResetPasswordCodeCriteria;
import com.bolatu.db.api.criteria.SignupConfirmationCriteria;
import com.bolatu.db.api.dao.ResetPasswordCodeDao;
import com.bolatu.db.api.dao.SignupConfirmationDao;
import com.bolatu.db.api.dao.UserAuthInfoDao;
import com.bolatu.db.api.dao.UserDao;
import com.bolatu.db.api.dao.UserLoginDao;
import com.bolatu.db.api.model.ResetPasswordCode;
import com.bolatu.db.api.model.SignupConfirmation;
import com.bolatu.db.api.model.User;
import com.bolatu.db.api.model.UserAuthInfo;
import com.bolatu.db.api.model.UserLogin;
import com.bolatu.db.impl.criteria.ResetPasswordCodeCriteriaImpl;
import com.bolatu.db.impl.criteria.SignupConfirmationCriteriaImpl;
import com.bolatu.db.impl.model.ResetPasswordCodeImpl;
import com.bolatu.db.impl.model.SignupConfirmationImpl;
import com.bolatu.db.impl.model.UserAuthInfoImpl;
import com.bolatu.db.impl.model.UserImpl;
import com.bolatu.db.impl.model.UserLoginImpl;
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
import com.bolatu.service.api.service.NotificationService;
import com.bolatu.service.api.service.UserService;
import com.bolatu.service.impl.response.user.QueryResetPasswordResponseImpl;
import com.bolatu.service.impl.response.user.QueryUserAuthInfoResponseImpl;
import com.bolatu.service.impl.response.user.ResendConfirmationCodeResponseImpl;
import com.bolatu.service.impl.response.user.ResetPasswordResponseImpl;
import com.bolatu.service.impl.response.user.UpdatePasswordResponseImpl;
import com.bolatu.service.impl.response.user.UpdateProfileResponseImpl;
import com.bolatu.service.impl.response.user.UserAuthResponseImpl;
import com.bolatu.service.impl.response.user.UserConfirmationResponseImpl;
import com.bolatu.service.impl.response.user.UserProfileResponseImpl;
import com.bolatu.service.impl.response.user.UserSignupResponseImpl;
import com.bolatu.util.DateUtil;
import com.bolatu.util.HashingUtil;
import com.bolatu.util.I18NUtil;
import com.bolatu.util.LogUtil;
import com.bolatu.util.StringUtil;
import com.bolatu.util.constant.BolatuServiceReturnCodes;
import com.bolatu.util.enumaration.ResetPasswordCodeType;
import com.bolatu.util.enumaration.UserStatus;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SignupConfirmationDao signupConfirmationDao;
	
	@Autowired
	private UserAuthInfoDao userAuthInfoDao;
	
	@Autowired
	private UserLoginDao userLoginDao;
	
	@Autowired
	private ResetPasswordCodeDao resetPasswordCodeDao;
	
	@Autowired
	private NotificationService notification;
		
	@Override
	public UserProfileResponse getUserProfile(UserProfileRequest userProfileRequest) {		
		User user;
		
		try {
			user = userDao.findByUsername(userProfileRequest.getUsername());		
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UserProfileResponseImpl(dbEx);
		}
		
		UserProfileResponse profileResp = new UserProfileResponseImpl();		
		if(user == null) {
			profileResp.setResultCode(BolatuServiceReturnCodes.USER_DOES_NOT_EXIST);
			profileResp.setResultMessage(I18NUtil.getMessage("message.user.notfound"));
		} else {
			profileResp.setUser(user);
			profileResp.setResultMessage("User is authenticated");
		}
		
		return profileResp;
	}
	
	public UserAuthResponse authenticateUser(UserAuthRequest userAuthRequest) {
		UserAuthInfo userAuthInfo;		
		try {
			userAuthInfo = userAuthInfoDao.findByUsername(userAuthRequest.getUsername());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UserAuthResponseImpl(dbEx);
		}
		
		UserAuthResponse response = new UserAuthResponseImpl();		
		if(userAuthInfo == null) {
			response.setResultCode(BolatuServiceReturnCodes.USER_DOES_NOT_EXIST);				
			response.setResultMessage(I18NUtil.getMessage("message.user.usernameorpasswordwrong"));
		} else {
			if (HashingUtil.getBCryptPasswordEncoder().matches(userAuthRequest.getPassword(),
					userAuthInfo.getPassword())) {
				User user;
				try {
					user = userDao.findByUsername(userAuthRequest.getUsername());
				} catch (BolatuDbException dbEx) {
					LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
					return new UserAuthResponseImpl(dbEx);
				}
				if (user.getStatus() != UserStatus.ACTIVE.getCode()) {
					response.setResultCode(BolatuServiceReturnCodes.USER_STATUS_NOT_VALID);				
					response.setResultMessage(I18NUtil.getMessage("message.user.login.status.invalid"));
				} else {
					response.setUser(user);	
					response.setResultMessage("User is authenticated");
					
					saveUserLogin(userAuthRequest);
				}
			} else {
				response.setResultCode(BolatuServiceReturnCodes.USERNAME_OR_PASSWORD_WRONG);				
				response.setResultMessage(I18NUtil.getMessage("message.user.usernameorpasswordwrong"));
			}			
		}
		return response;
	}

	@Override
	public UserSignupResponse signup(UserSignupRequest userSignupRequest) {		
		LogUtil.SERVICELOGGER.info("User sign up request will be handled: {}", userSignupRequest);
		
		User existingUser;
		try {
			existingUser = userDao.findByUsername(userSignupRequest.getUsername());						
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UserSignupResponseImpl(dbEx);
		}
		
		UserSignupResponse userSignupResponse = new UserSignupResponseImpl();
		if(existingUser != null) {				
			userSignupResponse.setUser(existingUser);
			userSignupResponse.setResultCode(BolatuServiceReturnCodes.USER_ALREADY_EXIST);
			userSignupResponse.setResultMessage(I18NUtil.getMessage("message.signup.userexist"));
		} else {
			User userToSignup = new UserImpl();
			userToSignup.setUsername(userSignupRequest.getUsername());
			userToSignup.setStatus(UserStatus.PENDING.getCode());
			userToSignup.setEmail(userSignupRequest.getEmail());
			
			SignupConfirmation confirmation;
			try {
				userDao.save(userToSignup);
				saveUserAuthInfo(userSignupRequest);
				confirmation = saveSignupConfirmation(userSignupRequest);
			} catch (BolatuDbException dbEx) {
				LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
				return new UserSignupResponseImpl(dbEx);
			}
			
			userSignupResponse.setUser(userToSignup);
			userSignupResponse.setResultMessage(I18NUtil.getMessage("message.signup.success"));
			notification.sendConfirmation(confirmation);
		}
		
		LogUtil.SERVICELOGGER.info("User sign up request is handled. Request: {}, Response: {}", userSignupRequest, userSignupResponse);
		return userSignupResponse;
	}	
	
	public UserConfirmationResponse validateConfirmation(UserConfirmationRequest userConfirmationRequest) {
		LogUtil.SERVICELOGGER.info("Signup confirmation request will be handled: {}", userConfirmationRequest);
		
		SignupConfirmationCriteria signupConfirmationCriteria = new SignupConfirmationCriteriaImpl();
		signupConfirmationCriteria.addUsername(userConfirmationRequest.getUsername());
		signupConfirmationCriteria.addConfirmationCode(userConfirmationRequest.getConfirmationHash());	
		
		SignupConfirmation signupConfirmation;		
		try {
			signupConfirmation = signupConfirmationDao.findOneByCriteria(signupConfirmationCriteria);
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UserConfirmationResponseImpl(dbEx);
		}
		
		UserConfirmationResponse response = new UserConfirmationResponseImpl();
		if (signupConfirmation != null) {
			User signedUpUser;
			try {
				signupConfirmationDao.delete(signupConfirmation);
				signedUpUser = userDao.findByUsername(userConfirmationRequest.getUsername());	
				signedUpUser.setStatus(UserStatus.ACTIVE.getCode());
				userDao.save(signedUpUser);
			} catch (BolatuDbException dbEx) {
				LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
				return new UserConfirmationResponseImpl(dbEx);
			}
			
			response.setResultCode(BolatuServiceReturnCodes.SUCCESS);
			response.setResultMessage(I18NUtil.getMessage("message.user.confirmation.success"));
			response.setUser(signedUpUser);
		} else {
			response.setResultCode(BolatuServiceReturnCodes.CONFIRMATION_REQUEST_NOT_FOUND);
			response.setResultMessage(I18NUtil.getMessage("message.user.confirmation.request.notfound"));					
		}
		
		LogUtil.SERVICELOGGER.info("Signup confirmation request is handled. Request: {}, Response: {}", 
				userConfirmationRequest, response);
		return response;
	}
	
	private void saveUserAuthInfo(UserSignupRequest userSignupRequest) throws BolatuDbException {		
		String hashedPassword = HashingUtil.generateBCryptedHash(userSignupRequest.getPassword()); 
		
		UserAuthInfo userAuthInfo = new UserAuthInfoImpl();
		userAuthInfo.setPassword(hashedPassword);
		userAuthInfo.setUsername(userSignupRequest.getUsername());
		userAuthInfo.setPasswordLastUpdateDate(DateUtil.getCurrentTime());
		
		userAuthInfoDao.save(userAuthInfo);
	}
	
	private SignupConfirmation saveSignupConfirmation(UserSignupRequest userSignupRequest) throws BolatuDbException {
		String confirmationCode = HashingUtil.generateHashFor(userSignupRequest.getEmail());
		SignupConfirmation signupConfirmation = new SignupConfirmationImpl();
		signupConfirmation.setConfirmationCode(confirmationCode);
		signupConfirmation.setEmail(userSignupRequest.getEmail());
		signupConfirmation.setUsername(userSignupRequest.getUsername());
		
		signupConfirmationDao.save(signupConfirmation);
		
		return signupConfirmation;
	}
	
	private void saveUserLogin(UserAuthRequest request) {
		UserLogin userLogin = new UserLoginImpl();
		userLogin.setUsername(request.getUsername());
		userLogin.setLoginIp(request.getServiceRequestInfo().getIp());
		userLogin.setLoginSite(request.getServiceRequestInfo().getSite());
		
		try {
			userLoginDao.save(userLogin);
			userAuthInfoDao.updateLastLogin(request.getUsername(), 
					request.getServiceRequestInfo().getIp(), request.getServiceRequestInfo().getSite());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
		}
	}

	@Override
	public QueryUserAuthInfoResponse getUserAuthInfo(
			QueryUserAuthInfoRequest queryUserAuthInfoRequest) {

		UserAuthInfo userAuthInfo = null;
		try {
			userAuthInfo = userAuthInfoDao.findByUsername(queryUserAuthInfoRequest.getUsername());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new QueryUserAuthInfoResponseImpl(dbEx);
		}
		
		return new QueryUserAuthInfoResponseImpl(userAuthInfo);
	}

	@Override
	public ResendConfirmationCodeResponse resendConfirmationCode(
			ResendConfirmationCodeRequest resendConfirmationCodeRequest) {
		
		SignupConfirmationCriteria criteria = new SignupConfirmationCriteriaImpl();
		criteria.addUsername(resendConfirmationCodeRequest.getUsername());
		
		SignupConfirmation confirmation;
		try {
			confirmation = signupConfirmationDao.findOneByCriteria(criteria);
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new ResendConfirmationCodeResponseImpl(dbEx);
		}
		
		ResendConfirmationCodeResponse response = new ResendConfirmationCodeResponseImpl();		
		if (confirmation != null) {
			notification.sendConfirmation(confirmation);
			response.setResultMessage(I18NUtil.getMessage("message.user.confirmation.resend.success"));			
		} else {
			response.setResultCode(BolatuServiceReturnCodes.CONFIRMATION_REQUEST_NOT_FOUND);
			response.setResultMessage(I18NUtil.getMessage("message.user.confirmation.request.notfound"));
		}
		
		return response;
	}

	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
		ResetPasswordCode resetPasswordCode;
		try {
			ResetPasswordCodeCriteria criteria = new ResetPasswordCodeCriteriaImpl();
			criteria.addEmail(resetPasswordRequest.getEmail());
			criteria.addType(ResetPasswordCodeType.RESET.getCode());
			
			resetPasswordCode = resetPasswordCodeDao.findOneByCriteria(criteria);
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new ResetPasswordResponseImpl(dbEx);
		}
		
		if (resetPasswordCode != null) {
			if (DateUtil.getElapsedTimeInMinutes(resetPasswordCode.getCreateTime()) >= 5) {
				notification.sendResetPasswordCode(resetPasswordCode);
			}
			
			ResetPasswordResponse response = new ResetPasswordResponseImpl();
			response.setResultMessage(I18NUtil.getMessage("message.user.reset.password.send.successful"));
			
			return response;			
		} 
		
		User user;
		try {
			user = userDao.findByEmail(resetPasswordRequest.getEmail());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new ResetPasswordResponseImpl(dbEx);
		}
		
		if (user == null) {
			ResetPasswordResponse response = new ResetPasswordResponseImpl();
			response.setResultCode(BolatuServiceReturnCodes.USER_DOES_NOT_EXIST);
			response.setResultMessage(I18NUtil.getMessage("message.user.notfound"));
			
			return response;
		}
		
		resetPasswordCode = new ResetPasswordCodeImpl();
		resetPasswordCode.setEmail(resetPasswordRequest.getEmail());
		resetPasswordCode.setRequestIp(resetPasswordRequest.getServiceRequestInfo().getIp());
		resetPasswordCode.setCode(HashingUtil.generateResetPasswordCode());
		resetPasswordCode.setCreateTime(DateUtil.getCurrentTimeInMillis());
		resetPasswordCode.setType(ResetPasswordCodeType.RESET.getCode());
		
		try {
			resetPasswordCodeDao.save(resetPasswordCode);
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new ResetPasswordResponseImpl(dbEx);
		}
		
		notification.sendResetPasswordCode(resetPasswordCode);
		
		ResetPasswordResponse response = new ResetPasswordResponseImpl();
		response.setResultMessage(I18NUtil.getMessage("message.user.reset.password.send.successful"));
		
		return response;
	}

	@Override
	public QueryResetPasswordResponse queryResetPasswordRequest(QueryResetPasswordRequest queryResetPasswordRequest) {
		if (StringUtil.isNullOrEmpty(queryResetPasswordRequest.getCode())) {
			queryResetPasswordRequest.setCode(" ");
		}
		
		ResetPasswordCode resetPasswordCode;
		try {
			ResetPasswordCodeCriteria criteria = new ResetPasswordCodeCriteriaImpl();
			criteria.addEmail(queryResetPasswordRequest.getEmail());
			criteria.setCode(queryResetPasswordRequest.getCode());
			
			resetPasswordCode = resetPasswordCodeDao.findOneByCriteria(criteria);			
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new QueryResetPasswordResponseImpl(dbEx);
		}
		
		QueryResetPasswordResponse response = new QueryResetPasswordResponseImpl();
		
		if (resetPasswordCode == null) {
			response.setResultCode(BolatuServiceReturnCodes.RESET_PASSWORD_REQUEST_NOT_FOUND);
			response.setResultMessage(I18NUtil.getMessage("message.user.reset.password.request.notfound"));
			return response;
		}
		
		resetPasswordCode.setCode(HashingUtil.generateUpdatePasswordCode());
		resetPasswordCode.setType(ResetPasswordCodeType.UPDATE.getCode());
		
		try {
			resetPasswordCodeDao.save(resetPasswordCode);			
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new QueryResetPasswordResponseImpl(dbEx);
		}
		
		response.setCode(resetPasswordCode.getCode());
		response.setResultMessage(I18NUtil.getMessage("message.user.reset.password.request.found"));
		
		return response;		
	}

	@Override
	public UpdatePasswordResponse updatePassword(UpdatePasswordRequest updatePasswordRequest) {		
		if (StringUtil.isNullOrEmpty(updatePasswordRequest.getCode())) {
			updatePasswordRequest.setCode(" ");
		}
		
		ResetPasswordCode resetPasswordCode;
		try {
			ResetPasswordCodeCriteria criteria = new ResetPasswordCodeCriteriaImpl();
			criteria.addEmail(updatePasswordRequest.getEmail());
			criteria.setCode(updatePasswordRequest.getCode());
			
			resetPasswordCode = resetPasswordCodeDao.findOneByCriteria(criteria);
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UpdatePasswordResponseImpl(dbEx);
		}
		
		UpdatePasswordResponse response = new UpdatePasswordResponseImpl();
		
		if (resetPasswordCode == null) {
			response.setResultCode(BolatuServiceReturnCodes.RESET_PASSWORD_REQUEST_NOT_FOUND);
			response.setResultMessage(I18NUtil.getMessage("message.user.reset.password.request.notfound"));
			return response;
		}
		
		User user;
		try {
			user = userDao.findByEmail(updatePasswordRequest.getEmail());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UpdatePasswordResponseImpl(dbEx);
		}
		
		if (user == null) {
			response.setResultCode(BolatuServiceReturnCodes.USER_DOES_NOT_EXIST);
			response.setResultMessage(I18NUtil.getMessage("message.user.notfound"));
			return response;
		}
		
		UserAuthInfo authInfo;
		try {
			authInfo = userAuthInfoDao.findByUsername(user.getUsername());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UpdatePasswordResponseImpl(dbEx);
		}
		
		if (authInfo == null) {
			response.setResultCode(BolatuServiceReturnCodes.USER_AUTHINFO_NOT_FOUND);
			response.setResultMessage(I18NUtil.getMessage("message.user.authinfo.notfound"));
			return response;
		}
		
		authInfo.setPasswordLastUpdateDate(DateUtil.getCurrentTime());
		authInfo.setPassword(HashingUtil.generateBCryptedHash(updatePasswordRequest.getPassword()));
		authInfo.setPasswordLastUpdateIp(updatePasswordRequest.getServiceRequestInfo().getIp());
		
		try {
			userAuthInfoDao.save(authInfo);
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UpdatePasswordResponseImpl(dbEx);
		}
		
		try {
			resetPasswordCodeDao.delete(resetPasswordCode);
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
		}
		
		notification.sentUpdatePasswordResult(updatePasswordRequest.getEmail(),
				updatePasswordRequest.getServiceRequestInfo().getIp(), authInfo.getPasswordLastUpdateDate());
		
		response.setResultMessage(I18NUtil.getMessage("message.user.update.password.successful"));
				
		return response;
	}

	@Override
	public UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest) {
		try {
			userDao.save(updateProfileRequest.getUser());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new UpdateProfileResponseImpl(dbEx);
		}
		
		UpdateProfileResponse response = new UpdateProfileResponseImpl(updateProfileRequest.getUser());
		response.setResultMessage(I18NUtil.getMessage("message.user.profile.update.successful"));
		
		return response;
	}
	
}
