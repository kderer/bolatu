package com.bolatu.web.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bolatu.rest.client.service.request.user.UserAuthRequestImpl;
import com.bolatu.rest.client.service.service.UserServiceClient;
import com.bolatu.service.api.request.user.UserAuthRequest;
import com.bolatu.service.api.response.user.UserAuthResponse;
import com.bolatu.util.constant.BolatuServiceReturnCodes;

@Service
public class AuthenticationService implements AuthenticationProvider {
	
	@Autowired
	private UserServiceClient userServiceClient;
	
	private List<GrantedAuthority> authenticatedUserAuthList = AuthorityUtils.
			createAuthorityList(new String[]{"AUTH_USER"});
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {		

		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		UserAuthRequest userAuthRequest = new UserAuthRequestImpl(username, password);
		UserAuthResponse userAuthResponse = userServiceClient.authenticateUser(userAuthRequest);
		
		if (BolatuServiceReturnCodes.SUCCESS.equals(userAuthResponse.getResultCode())) {			
			return new UsernamePasswordAuthenticationToken(username, password, authenticatedUserAuthList);
		} else if (BolatuServiceReturnCodes.USER_DOES_NOT_EXIST.equals(userAuthResponse.getResultCode())) {
			throw new UsernameNotFoundException(userAuthResponse.getResultMessage());
		} else if (BolatuServiceReturnCodes.USER_STATUS_NOT_VALID.equals(userAuthResponse.getResultCode())) {
			throw new InsufficientAuthenticationException(userAuthResponse.getResultMessage());
		} else {
			throw new BadCredentialsException(userAuthResponse.getResultMessage());
		}
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	

}
