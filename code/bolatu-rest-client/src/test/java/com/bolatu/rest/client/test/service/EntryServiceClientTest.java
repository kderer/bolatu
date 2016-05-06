package com.bolatu.rest.client.test.service;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.db.api.model.Entry;
import com.bolatu.rest.client.model.EntryImpl;
import com.bolatu.rest.client.service.request.entry.CreateEntryRequestImpl;
import com.bolatu.rest.client.service.request.entry.EntryQueryRequestImpl;
import com.bolatu.rest.client.service.request.entry.LikeEntryRequestImpl;
import com.bolatu.rest.client.service.service.EntryServiceClient;
import com.bolatu.rest.client.test.BaseTestConfig;
import com.bolatu.service.api.request.entry.CreateEntryRequest;
import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.service.api.request.entry.LikeEntryRequest;
import com.bolatu.service.api.response.entry.CreateEntryResponse;
import com.bolatu.service.api.response.entry.EntryQueryResponse;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.AgeRange;
import com.bolatu.util.enumaration.EntryStatus;
import com.bolatu.util.enumaration.Gender;
import com.bolatu.util.enumaration.SortDirection;

public class EntryServiceClientTest extends BaseTestConfig {
	
	@Autowired
	private EntryServiceClient entryServiceClient;
	
	@Test
	public void createEntryTest() {
		
		Entry entry = new EntryImpl();
		entry.setIp("112.16.94.153");
		entry.setPostDate(Calendar.getInstance().getTime());
		entry.setStatus(EntryStatus.APPROVED.getCode());
		entry.setTags("am got meme");
		entry.setTargetAgeRange(AgeRange.F30T40.getCode());
		entry.setTargetGender(Gender.GAY.getCode());
		entry.setText("我今天看到一个长头发大鼻子男人。很喜欢他");
		entry.setTitle("My Gay Love");
		
		CreateEntryRequest createEntryRequest = new CreateEntryRequestImpl(entry, "abaza31");
		
		CreateEntryResponse response = entryServiceClient.createEntry(createEntryRequest);
		
		Assert.assertTrue(response.getEntry().getUser().getUsername().equals("abaza31"));		
	}
	
	@Test
	public void queryEntryTest() {
		EntryQueryRequest entryQueryRequest = new EntryQueryRequestImpl();
		entryQueryRequest.addStatus(EntryStatus.APPROVED.getCode());
		entryQueryRequest.addSortRequest(new SortRequest("postDate", SortDirection.DESC));
		
		EntryQueryResponse response = entryServiceClient.queryEntry(entryQueryRequest);		
		
		Assert.assertNotEquals(0, response.getEntryList().size());
	}
	
	@Test
	public void testLikeEntry() {
		LikeEntryRequest request = new LikeEntryRequestImpl();
		request.setUsername("abaza31");
		request.setEntryId("562518deb2f0e15d7e03a557");
		
		entryServiceClient.likeEntry(request);
		
		Assert.assertEquals(1, entryServiceClient.queryEntry(new EntryQueryRequestImpl("562518deb2f0e15d7e03a557")).
				getEntryList().get(0).getLikedUserList().size());
	}

}
