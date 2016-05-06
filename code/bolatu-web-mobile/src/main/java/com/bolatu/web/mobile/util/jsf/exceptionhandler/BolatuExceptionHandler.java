package com.bolatu.web.mobile.util.jsf.exceptionhandler;

import java.util.Iterator;

import javax.ejb.EJBException;
import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.util.UrlUtils;

public class BolatuExceptionHandler extends ExceptionHandlerWrapper {
	private final ExceptionHandler wrapped;

	public BolatuExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		for (final Iterator<ExceptionQueuedEvent> it = getUnhandledExceptionQueuedEvents().iterator(); it.hasNext();) {
			Throwable t = it.next().getContext().getException();
			
			while ((t instanceof FacesException || t instanceof EJBException || t instanceof ELException)
					&& t.getCause() != null) {
				t = t.getCause();
			}
			
			if (t instanceof AccessDeniedException) {
				final FacesContext facesContext = FacesContext.getCurrentInstance();
				final ExternalContext externalContext = facesContext.getExternalContext();
				HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
				HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

				String redirectUrl = calculateRedirectUrl(request.getContextPath(), "/login.xhtml");

				boolean ajaxRedirect = request.getHeader("faces-request") != null
						&& request.getHeader("faces-request").toLowerCase().indexOf("ajax") > -1;

				
				try {
					if (ajaxRedirect) {
						String ajaxRedirectXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
								+ "<partial-response><redirect url=\"" + redirectUrl + "\"></redirect></partial-response>";
						response.setContentType("text/xml");
						response.getWriter().write(ajaxRedirectXml);
					} else {
						response.sendRedirect(redirectUrl);
					}
	
					facesContext.responseComplete();
				}
				catch(Exception e) {
					e.printStackTrace();
				}				
			}
		}
	}

	private String calculateRedirectUrl(String contextPath, String url) {
		if (!UrlUtils.isAbsoluteUrl(url)) {
			return contextPath + url;
		}
		
		url = url.substring(url.indexOf("://") + 3); // strip off scheme
		url = url.substring(url.indexOf(contextPath) + contextPath.length());

		if (url.length() > 1 && url.charAt(0) == '/') {
			url = url.substring(1);
		}

		return url;
	}
}
