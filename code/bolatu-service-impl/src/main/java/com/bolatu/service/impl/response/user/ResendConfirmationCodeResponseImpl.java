package com.bolatu.service.impl.response.user;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.response.user.ResendConfirmationCodeResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class ResendConfirmationCodeResponseImpl extends BaseServiceResponseImpl implements ResendConfirmationCodeResponse {

	public ResendConfirmationCodeResponseImpl() {
		
	}
	
	public ResendConfirmationCodeResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
}
