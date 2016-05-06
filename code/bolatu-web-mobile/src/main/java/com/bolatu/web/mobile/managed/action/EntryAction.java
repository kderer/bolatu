package com.bolatu.web.mobile.managed.action;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.db.api.model.Entry;
import com.bolatu.rest.client.model.EntryImpl;
import com.bolatu.rest.client.service.request.entry.CreateEntryRequestImpl;
import com.bolatu.service.api.request.entry.CreateEntryRequest;
import com.bolatu.service.api.response.entry.CreateEntryResponse;
import com.bolatu.service.api.service.EntryService;

@Component
@ManagedBean(name="entryAction")
@Scope("request")
public class EntryAction extends BaseAction {

	@Autowired
	private EntryService entryService;
	
	private Entry entry;
	
	public void doSaveAction() {
		entry.setPostDate(Calendar.getInstance().getTime());
		entry.setSelectedLocation(sessionBean.getUserLocation());
		
		CreateEntryRequest request = new CreateEntryRequestImpl(entry, sessionBean.getLoggedInUsername());
		
		CreateEntryResponse response = entryService.createEntry(request);
		prepareResult(response, true, "/index.xhtml");
	}	

	public Entry getEntry() {
		if (entry == null) {
			entry = new EntryImpl();
		}
		
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}
}
