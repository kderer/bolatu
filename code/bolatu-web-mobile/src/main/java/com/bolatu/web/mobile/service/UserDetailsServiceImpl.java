package com.bolatu.web.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bolatu.rest.client.service.request.user.QueryUserAuthInfoRequestImpl;
import com.bolatu.rest.client.service.service.UserServiceClient;
import com.bolatu.service.api.request.user.QueryUserAuthInfoRequest;
import com.bolatu.service.api.response.user.QueryUserAuthInfoResponse;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserServiceClient userServiceClient;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		QueryUserAuthInfoRequest queryUserAuthInfoRequest = new QueryUserAuthInfoRequestImpl(username);
		QueryUserAuthInfoResponse response = userServiceClient.getUserAuthInfo(queryUserAuthInfoRequest);
		
		if(response.getUserAuthInfo() == null) {
			throw new UsernameNotFoundException(response.getResultMessage());
		}
				
		return new User(username, response.getUserAuthInfo().getPassword(), 
				AuthorityUtils.createAuthorityList(new String[]{"USER"}));
	}

}
