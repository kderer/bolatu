package com.bolatu.service.impl.response.entry;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.service.api.response.entry.DeleteEntryResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class DeleteEntryResponseImpl extends BaseServiceResponseImpl implements DeleteEntryResponse {

	public DeleteEntryResponseImpl() {
		
	}
	
	public DeleteEntryResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}

}
