package com.bolatu.web.mobile.managed.action;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.db.api.model.Entry;
import com.bolatu.rest.client.service.request.entry.DeleteEntryRequestImpl;
import com.bolatu.rest.client.service.request.entry.EntryQueryRequestImpl;
import com.bolatu.service.api.request.entry.DeleteEntryRequest;
import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.service.api.response.entry.DeleteEntryResponse;
import com.bolatu.service.api.service.EntryService;
import com.bolatu.web.mobile.lazydata.LazyEntryFetcher;

@Component
@ManagedBean(name="personalEntryAction")
@Scope("view")
public class PersonalEntryAction extends BaseAction {

	@Autowired
	private EntryService entryService;
	
	private LazyEntryFetcher lazyEntryFetcher;
	private Entry entryToDelete;	
	
	@PostConstruct
	public void init() {
		EntryQueryRequest entryQueryRequest = new EntryQueryRequestImpl();
		entryQueryRequest.addUsername(sessionBean.getLoggedInUsername());
		
		lazyEntryFetcher = new LazyEntryFetcher(entryService, entryQueryRequest);		
	}
	
	public void deleteEntry() {
		DeleteEntryRequest request = new DeleteEntryRequestImpl();
		request.setEntryId(entryToDelete.getId());
		request.setUsername(sessionBean.getLoggedInUsername());
		
		DeleteEntryResponse response = entryService.deleteEntry(request);
		
		prepareResult(response, false, null);
	}
	
	public LazyEntryFetcher getLazyEntryFetcher() {
		return lazyEntryFetcher;
	}

	public Entry getEntryToDelete() {
		return entryToDelete;
	}

	public void setEntryToDelete(Entry entryToDelete) {
		this.entryToDelete = entryToDelete;
	}
	
}
