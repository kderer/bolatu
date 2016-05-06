package com.bolatu.service.impl.response;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.response.BaseServiceResponse;
import com.bolatu.util.I18NUtil;
import com.bolatu.util.constant.BolatuServiceReturnCodes;


public abstract class BaseServiceResponseImpl implements BaseServiceResponse {
	
	private String resultCode = BolatuServiceReturnCodes.SUCCESS;
	private String resultMessage;
	
	public BaseServiceResponseImpl() {
		
	}
	
	public BaseServiceResponseImpl(BolatuDbException dbException) {
		resultCode = dbException.getDbExceptionCode();
		resultMessage = I18NUtil.getMessage("message.service.generic.dbexceptionoccured");
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
