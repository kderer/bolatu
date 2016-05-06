package com.bolatu.rest.client.service.request;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.bolatu.service.api.request.BaseServiceRequest;
import com.bolatu.service.api.request.ServiceRequestInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public abstract class BaseServiceRequestImpl implements BaseServiceRequest {

	private ServiceRequestInfo serviceRequestInfo;	
	
	public BaseServiceRequestImpl() {		
		if(BolatuServiceRequestContext.getCurrentInstance() != null && 
				BolatuServiceRequestContext.getCurrentInstance().getServiceRequestInfo() != null) {
			
			ServiceRequestInfo serviceRequestInfo = BolatuServiceRequestContext.
					getCurrentInstance().getServiceRequestInfo();
			
			this.serviceRequestInfo = new ServiceRequestInfoImpl();
			this.serviceRequestInfo.setLanguage(serviceRequestInfo.getLanguage());
			this.serviceRequestInfo.setTimeZone(serviceRequestInfo.getTimeZone());
			this.serviceRequestInfo.setIp(serviceRequestInfo.getIp());
			this.serviceRequestInfo.setSite(serviceRequestInfo.getSite());
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();			
			if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) { 
				this.serviceRequestInfo.setUsername(authentication.getName());
			} 
		}
	}	
	
	@Override
	public ServiceRequestInfo getServiceRequestInfo() {
		return serviceRequestInfo;
	}

	@Override
	@JsonDeserialize(as = ServiceRequestInfoImpl.class)
	public void setServiceRequestInfo(ServiceRequestInfo requestInfo) {
		this.serviceRequestInfo = requestInfo;
	}

}
