package com.bolatu.web.mobile.lazydata;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.bolatu.rest.client.model.MessageImpl;
import com.bolatu.rest.client.service.request.message.QueryInboxRequestImpl;
import com.bolatu.service.api.request.message.QueryInboxRequest;
import com.bolatu.service.api.response.message.QueryInboxResponse;
import com.bolatu.service.api.service.MessageService;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.SortDirection;

public class LazyInboxFetcher extends LazyDataModel<MessageImpl> {
	
	private static final long serialVersionUID = -8506745923699410288L;
	private String username;
	private MessageService messageService;	
	private List<MessageImpl> messageList;
	
	public LazyInboxFetcher(MessageService messageService, String username) {
		this.username = username;
		this.messageService = messageService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageImpl> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		QueryInboxRequest queryInboxRequest = new QueryInboxRequestImpl();
		queryInboxRequest.setUsername(username);
		queryInboxRequest.addSortRequest(new SortRequest("sentDate", SortDirection.DESC));
		queryInboxRequest.setPageSize(pageSize);
		queryInboxRequest.setPageNumber(first / pageSize);		
		
		QueryInboxResponse response = messageService.queryInbox(queryInboxRequest);
		
		messageList = (List<MessageImpl>) response.getMessageList();
		setRowCount((int)response.getTotalRecordNumber());
		
		return messageList;
	}

	public List<MessageImpl> getMessageList() {
		return messageList;
	}
}
