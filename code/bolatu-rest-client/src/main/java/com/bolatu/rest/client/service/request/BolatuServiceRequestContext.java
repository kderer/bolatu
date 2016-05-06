package com.bolatu.rest.client.service.request;

import com.bolatu.service.api.request.ServiceRequestInfo;

public class BolatuServiceRequestContext {
	
	private static ThreadLocal<BolatuServiceRequestContext> instance = new ThreadLocal<BolatuServiceRequestContext>(){
		@Override
		protected BolatuServiceRequestContext initialValue() {
			return new BolatuServiceRequestContext();
		}
	};
	
	private ServiceRequestInfo serviceRequestInfo;

	public static BolatuServiceRequestContext getCurrentInstance() {
		return instance.get();
	}

	public ServiceRequestInfo getServiceRequestInfo() {
		return serviceRequestInfo;
	}

	public void setServiceRequestInfo(ServiceRequestInfo serviceRequestInfo) {
		this.serviceRequestInfo = serviceRequestInfo;
	}

}
