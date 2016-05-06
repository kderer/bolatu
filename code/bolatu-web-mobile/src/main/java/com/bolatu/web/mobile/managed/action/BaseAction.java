package com.bolatu.web.mobile.managed.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.util.ComponentUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.service.api.response.BaseServiceResponse;
import com.bolatu.util.StringUtil;
import com.bolatu.util.constant.BolatuServiceReturnCodes;
import com.bolatu.web.mobile.managed.SessionBean;

public abstract class BaseAction {

	private final static String SUCCESS_MESSAGE_LIST = "successMessageList";
	private final static String SHOW_RESULT_DIALOG = "showResultDialog";
	private final static String NAVIGATE_TO = "navigateTo";

	@Autowired
	protected SessionBean sessionBean;

	protected FacesContext facesContext = FacesContext.getCurrentInstance();
	protected HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();

	private List<String> successMessageList = new ArrayList<String>();

	public void addErrorMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public void addInfoMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public void forwardRequest(String uri) throws ServletException, IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher(uri);

		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());

		FacesContext.getCurrentInstance().responseComplete();
	}

	public String getI18NText(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle text = context.getApplication().evaluateExpressionGet(context, "#{i18n}", ResourceBundle.class);
		return text.getString(key);
	}

	protected void addSuccessMessage(String message) {
		successMessageList.add(message);

		request.setAttribute(SUCCESS_MESSAGE_LIST, successMessageList);
	}

	protected void prepareResult(BaseServiceResponse serviceResponse, boolean showResultDialog, String navigateTo) {
		if (!serviceResponse.getResultCode().equals(BolatuServiceReturnCodes.SUCCESS)) {
			addErrorMessage(serviceResponse.getResultMessage());
		} else if (showResultDialog) {
			addSuccessMessage(serviceResponse.getResultMessage());
		}

		if (!StringUtil.isNullOrEmpty(navigateTo)) {
			navigateTo = ComponentUtils.findNavigationCase(facesContext, navigateTo).getToViewId(facesContext);
		}

		request.setAttribute(SHOW_RESULT_DIALOG, showResultDialog);
		request.setAttribute(NAVIGATE_TO, navigateTo);
	}

}
