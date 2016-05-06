package com.bolatu.web.mobile.managed.action;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.rest.client.service.request.user.UserConfirmationRequestImpl;
import com.bolatu.service.api.request.user.UserConfirmationRequest;
import com.bolatu.service.api.response.user.UserConfirmationResponse;
import com.bolatu.service.api.service.UserService;
import com.bolatu.util.constant.BolatuServiceReturnCodes;

@Component
@ManagedBean(name="confirmationAction")
@Scope("request")
public class ConfirmationAction extends BaseAction {
	
	@Autowired
	private UserService userService;
	
	private String username;
	private String confirmationCode;
	private String confirmationResultMessage;
	private boolean successful;	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
	
	public void onload() {
		UserConfirmationRequest request = new UserConfirmationRequestImpl(username, confirmationCode);
		UserConfirmationResponse response = userService.validateConfirmation(request);
		
		confirmationResultMessage = response.getResultMessage();
		
		if (!BolatuServiceReturnCodes.SUCCESS.equals(response.getResultCode())) {
			successful = false;
		} else {
			successful = true;
		}
	}

	public String getConfirmationResultMessage() {
		return confirmationResultMessage;
	}

	public void setConfirmationResultMessage(String confirmationResultMessage) {
		this.confirmationResultMessage = confirmationResultMessage;
	}

	public boolean isSuccessful() {
		return successful;
	}
	
}
