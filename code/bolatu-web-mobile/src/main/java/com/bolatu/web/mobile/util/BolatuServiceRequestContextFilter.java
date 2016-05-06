package com.bolatu.web.mobile.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;

import com.bolatu.rest.client.service.request.BolatuServiceRequestContext;
import com.bolatu.rest.client.service.request.ServiceRequestInfoImpl;
import com.bolatu.service.api.request.ServiceRequestInfo;
import com.bolatu.util.StringUtil;
import com.bolatu.util.enumaration.BolatuSite;

/**
 * Servlet Filter implementation class BolatuServiceRequestContextFilter
 */
@WebFilter("/*")
public class BolatuServiceRequestContextFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BolatuServiceRequestContextFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if (!StringUtil.isNullOrEmpty(((HttpServletRequest)request).getRequestURI()) && 
				!((HttpServletRequest)request).getRequestURI().contains("javax.faces.resource")) {			
			ServiceRequestInfo serviceRequestInfo = new ServiceRequestInfoImpl();
			serviceRequestInfo.setIp(request.getRemoteAddr());
			serviceRequestInfo.setSite(BolatuSite.MOBILE.getSiteCode());
			
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				serviceRequestInfo.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			}
			
			BolatuServiceRequestContext.getCurrentInstance().setServiceRequestInfo(serviceRequestInfo);
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
