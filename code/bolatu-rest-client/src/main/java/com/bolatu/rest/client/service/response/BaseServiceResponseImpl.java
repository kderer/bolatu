package com.bolatu.rest.client.service.response;

import com.bolatu.service.api.response.BaseServiceResponse;
import com.bolatu.util.constant.BolatuServiceReturnCodes;


public abstract class BaseServiceResponseImpl implements BaseServiceResponse {
	
	private String resultCode = BolatuServiceReturnCodes.SUCCESS;
	private String resultMessage;
	
	public BaseServiceResponseImpl() {
		
	}
	
	public String getResultCode() {
		return resultCode;
	}
	
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}
	
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

}
