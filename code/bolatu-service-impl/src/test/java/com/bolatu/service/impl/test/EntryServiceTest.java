package com.bolatu.service.impl.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.model.Entry;
import com.bolatu.db.impl.model.EntryImpl;
import com.bolatu.service.api.request.entry.CreateEntryRequest;
import com.bolatu.service.api.request.entry.DeleteEntryRequest;
import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.service.api.response.entry.CreateEntryResponse;
import com.bolatu.service.api.response.entry.DeleteEntryResponse;
import com.bolatu.service.api.response.entry.EntryQueryResponse;
import com.bolatu.service.api.service.EntryService;
import com.bolatu.service.impl.request.entry.CreateEntryRequestImpl;
import com.bolatu.service.impl.request.entry.DeleteEntryRequestImpl;
import com.bolatu.service.impl.request.entry.EntryQueryRequestImpl;
import com.bolatu.util.constant.BolatuServiceReturnCodes;

public class EntryServiceTest extends BaseTestConfig {
	
	@Autowired
	private EntryService entryService;
	
	@Test
	public void createEntryTest() {		
		Entry entry = new EntryImpl();
		entry.setText("test text");
		
		CreateEntryRequest cer = new CreateEntryRequestImpl(entry, "abaza6931");
		
		CreateEntryResponse response = entryService.createEntry(cer);
		
		Assert.assertNotNull(response);
	}
	
	@Test
	public void queryEntryTest() {
		EntryQueryRequest eqr = new EntryQueryRequestImpl();
		
		EntryQueryResponse response = entryService.queryEntry(eqr);
		
		Assert.assertNotEquals(0, response.getEntryList());
	}
	
	@Test
	public void deleteEntryTest() {
		
		Entry entry = entryService.queryEntry(new EntryQueryRequestImpl()).
				getEntryList().get(0);
		
		
		DeleteEntryRequest request = new DeleteEntryRequestImpl();
		request.setEntryId(entry.getId());
		
		DeleteEntryResponse response = entryService.deleteEntry(request);
		
		Assert.assertEquals(response.getResultCode(), BolatuServiceReturnCodes.ENTRY_NOT_FOUND);
	}
}
