package com.bolatu.web.mobile.managed.action;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.rest.client.service.request.user.QueryResetPasswordRequestImpl;
import com.bolatu.rest.client.service.request.user.UpdatePasswordRequestImpl;
import com.bolatu.service.api.request.user.QueryResetPasswordRequest;
import com.bolatu.service.api.request.user.UpdatePasswordRequest;
import com.bolatu.service.api.response.user.QueryResetPasswordResponse;
import com.bolatu.service.api.response.user.UpdatePasswordResponse;
import com.bolatu.service.api.service.UserService;
import com.bolatu.util.constant.BolatuServiceReturnCodes;

@Component
@ManagedBean(name="updatePasswordAction")
@Scope("request")
public class UpdatePasswordAction extends BaseAction {

	@Autowired
	private UserService userService;
	
	private String password;
	private String code;
	private String email;
	
	public void onload() {
		QueryResetPasswordRequest request = new QueryResetPasswordRequestImpl();
		request.setEmail(email);
		request.setCode(code);
		
		QueryResetPasswordResponse response = userService.queryResetPasswordRequest(request);
		
		if (!BolatuServiceReturnCodes.SUCCESS.equals(response.getResultCode())) {
			addErrorMessage(response.getResultMessage());
		}
		else {
			code = response.getCode();
		}
	}
	
	public void updatePassword() {
		UpdatePasswordRequest request = new UpdatePasswordRequestImpl();
		request.setCode(code);
		request.setEmail(email);
		request.setPassword(password);
		
		UpdatePasswordResponse response = userService.updatePassword(request);
		
		prepareResult(response, true, "/index.xhtml");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
}
