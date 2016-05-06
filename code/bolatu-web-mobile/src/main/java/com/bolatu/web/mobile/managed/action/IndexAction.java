package com.bolatu.web.mobile.managed.action;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.bolatu.rest.client.model.EntryImpl;
import com.bolatu.rest.client.service.request.entry.EntryQueryRequestImpl;
import com.bolatu.rest.client.service.request.entry.LikeEntryRequestImpl;
import com.bolatu.rest.client.service.request.entry.UnlikeEntryRequestImpl;
import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.service.api.request.entry.LikeEntryRequest;
import com.bolatu.service.api.request.entry.UnlikeEntryRequest;
import com.bolatu.service.api.service.EntryService;
import com.bolatu.util.enumaration.EntryStatus;
import com.bolatu.util.fileupload.FileUploadService;
import com.bolatu.web.mobile.lazydata.LazyEntryFetcher;

@Component
@ManagedBean(name="indexAction")
@Scope("view")
public class IndexAction extends BaseAction {

	@Autowired
	private EntryService entryService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	private LazyEntryFetcher lazyEntryFetcher;
	private int selectedEntryIndex;
	
	@PostConstruct
	public void init() {
		EntryQueryRequest entryQueryRequest = new EntryQueryRequestImpl();
		entryQueryRequest.addStatus(EntryStatus.APPROVED.getCode());
		
		lazyEntryFetcher = new LazyEntryFetcher(entryService, entryQueryRequest);		
	}
	
	@PreAuthorize("isAuthenticated()")
	public String sendMessage() {
		return "/message/send.xhtml";
	}
	
	@PreAuthorize("isAuthenticated()")
	public void doEntryLikeAction() {
		EntryImpl selectedEntry = lazyEntryFetcher.getEntryList().get(selectedEntryIndex);
		
		if (selectedEntry.getLikedUserList().contains(sessionBean.getLoggedInUsername())) {
			unlikeEntry(selectedEntry);
		}
		else {
			likeEntry(selectedEntry);
		}	
	}
	
	private void likeEntry(EntryImpl selectedEntry) {		
		LikeEntryRequest likeEntryRequest = new LikeEntryRequestImpl();
		likeEntryRequest.setEntryId(selectedEntry.getId());
		likeEntryRequest.setUsername(sessionBean.getLoggedInUsername());
		entryService.likeEntry(likeEntryRequest);
		
		selectedEntry = (EntryImpl)entryService.queryEntry(
				new EntryQueryRequestImpl(selectedEntry.getId())).getEntryList().get(0);
		
		lazyEntryFetcher.getEntryList().remove(selectedEntryIndex);
		lazyEntryFetcher.getEntryList().add(selectedEntryIndex, selectedEntry);
	}
	
	private void unlikeEntry(EntryImpl selectedEntry) {
		UnlikeEntryRequest unlikeEntryRequest = new UnlikeEntryRequestImpl();
		unlikeEntryRequest.setEntryId(selectedEntry.getId());
		unlikeEntryRequest.setUsername(sessionBean.getLoggedInUsername());
		entryService.unlikeEntry(unlikeEntryRequest);
		
		selectedEntry = (EntryImpl)entryService.queryEntry(
				new EntryQueryRequestImpl(selectedEntry.getId())).getEntryList().get(0);
		
		lazyEntryFetcher.getEntryList().remove(selectedEntryIndex);
		lazyEntryFetcher.getEntryList().add(selectedEntryIndex, selectedEntry);
	}

	public LazyEntryFetcher getLazyEntryFetcher() {
		return lazyEntryFetcher;
	}

	public int getSelectedEntryIndex() {
		return selectedEntryIndex;
	}

	public void setSelectedEntryIndex(int selectedEntryIndex) {
		this.selectedEntryIndex = selectedEntryIndex;
	}
	
	public String getProfilePhotoUrl() {
		return fileUploadService.getProfilePhotoFolderUrl();
	}
	
}
