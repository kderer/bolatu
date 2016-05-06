package com.bolatu.web.mobile.managed.action;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.rest.client.service.request.user.ResetPasswordRequestImpl;
import com.bolatu.service.api.request.user.ResetPasswordRequest;
import com.bolatu.service.api.response.user.ResetPasswordResponse;
import com.bolatu.service.api.service.UserService;

@Component
@ManagedBean(name="resetPasswordAction")
@Scope("request")
public class ResetPasswordAction extends BaseAction {

	@Autowired
	private UserService userService;
	
	private String emailAddress;
	
	public void doResetPasswordAction() {
		ResetPasswordRequest request = new ResetPasswordRequestImpl();
		request.setEmail(emailAddress);
		ResetPasswordResponse response = userService.resetPassword(request);
		
		prepareResult(response, true, "/index.xhtml");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}	
}
