package com.bolatu.rest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolatu.service.api.response.entry.CreateEntryResponse;
import com.bolatu.service.api.response.entry.DeleteEntryResponse;
import com.bolatu.service.api.response.entry.EntryQueryResponse;
import com.bolatu.service.api.response.entry.LikeEntryResponse;
import com.bolatu.service.api.response.entry.UnlikeEntryResponse;
import com.bolatu.service.api.service.EntryService;
import com.bolatu.service.impl.request.entry.CreateEntryRequestImpl;
import com.bolatu.service.impl.request.entry.DeleteEntryRequestImpl;
import com.bolatu.service.impl.request.entry.EntryQueryRequestImpl;
import com.bolatu.service.impl.request.entry.LikeEntryRequestImpl;
import com.bolatu.service.impl.request.entry.UnlikeEntryRequestImpl;


@RestController
@RequestMapping("/entry")
public class EntryController {
	
	@Autowired
	private EntryService entryService;
	
	@RequestMapping(method = RequestMethod.POST)
	public EntryQueryResponse query(@RequestBody EntryQueryRequestImpl entryQueryRequest) {	
		return entryService.queryEntry(entryQueryRequest);
	}
		
	@RequestMapping(value = "/{entryId}", method = RequestMethod.GET)
	public EntryQueryResponse getEntry(@PathVariable(value="entryId") String entryId) {	
		return entryService.queryEntry(new EntryQueryRequestImpl(entryId));
	}	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CreateEntryResponse createEntry(@RequestBody CreateEntryRequestImpl createEntryRequest) {			
		return entryService.createEntry(createEntryRequest);	
	}
	
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public LikeEntryResponse likeEntry(@RequestBody LikeEntryRequestImpl likeEntryRequest) {			
		return entryService.likeEntry(likeEntryRequest);	
	}
	
	@RequestMapping(value = "/unlike", method = RequestMethod.POST)
	public UnlikeEntryResponse likeEntry(@RequestBody UnlikeEntryRequestImpl unlikeEntryRequest) {			
		return entryService.unlikeEntry(unlikeEntryRequest);	
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public DeleteEntryResponse deleteEntry(@RequestBody DeleteEntryRequestImpl deleteEntryRequest) {			
		return entryService.deleteEntry(deleteEntryRequest);	
	}
}
