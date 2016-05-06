package com.bolatu.web.mobile.managed.action;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@ManagedBean(name="loginAction")
@Scope("request")
public class LoginAction extends BaseAction {
	
	private String error;
		
	public String doLoginAction() throws ServletException, IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		 
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                 .getRequestDispatcher("/login");
 
        dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());
 
        FacesContext.getCurrentInstance().responseComplete();
        
        return null;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public void onload() {
		if (error != null) {
			addErrorMessage(getI18NText("message.login.error"));
		}
	}
	
}
