package com.bolatu.web.mobile.managed.action;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@ManagedBean(name="logoutAction")
@Scope("request")
public class LogoutAction extends BaseAction {
	
	public String doLogoutAction() throws ServletException, IOException {
		forwardRequest("/logout.xhtml");
		return null;
	}
}
