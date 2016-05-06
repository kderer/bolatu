package com.bolatu.service.impl.response.entry;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.Entry;
import com.bolatu.service.api.response.entry.CreateEntryResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class CreateEntryResponseImpl extends BaseServiceResponseImpl implements CreateEntryResponse {

	private Entry entry;
	
	public CreateEntryResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}
	
	public CreateEntryResponseImpl(Entry entry) {
		this.entry = entry;
	}
	
	@Override
	public Entry getEntry() {
		return entry;
	}

}
