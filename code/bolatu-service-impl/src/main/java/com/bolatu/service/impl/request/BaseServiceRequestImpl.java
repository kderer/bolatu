package com.bolatu.service.impl.request;

import com.bolatu.service.api.request.BaseServiceRequest;
import com.bolatu.service.api.request.ServiceRequestInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseServiceRequestImpl implements BaseServiceRequest {

	private ServiceRequestInfo serviceRequestInfo;	
	
	public BaseServiceRequestImpl() {		
		
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
