package com.bolatu.web.mobile.managed.action;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.rest.client.service.request.user.UserSignupRequestImpl;
import com.bolatu.service.api.request.user.UserSignupRequest;
import com.bolatu.service.api.response.user.UserSignupResponse;
import com.bolatu.service.api.service.UserService;

@Component
@ManagedBean(name="signupAction")
@Scope("request")
public class SignupAction extends BaseAction {
	
	@Autowired
	private UserService userService;
	
	private String username;
	private String password;
	private String rePassword;
	private String email;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void doSubmitAction() {
		UserSignupRequest userSignupRequest = new UserSignupRequestImpl();
		userSignupRequest.setUsername(username);
		userSignupRequest.setPassword(password);
		userSignupRequest.setEmail(email);
		UserSignupResponse response = userService.signup(userSignupRequest);
		
		prepareResult(response, true, "/index.xhtml");
	}
	
}
