package com.bolatu.web.mobile.lazydata;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.bolatu.rest.client.model.MessageImpl;
import com.bolatu.rest.client.service.request.message.QuerySentboxRequestImpl;
import com.bolatu.service.api.request.message.QuerySentboxRequest;
import com.bolatu.service.api.response.message.QuerySentboxResponse;
import com.bolatu.service.api.service.MessageService;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.SortDirection;

public class LazySentboxFetcher extends LazyDataModel<MessageImpl> {
	
	private static final long serialVersionUID = -8506745923699410288L;
	private String username;
	private MessageService messageService;	
	private List<MessageImpl> messageList;
	
	public LazySentboxFetcher(MessageService messageService, String username) {
		this.username = username;
		this.messageService = messageService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageImpl> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		QuerySentboxRequest querySentboxRequest = new QuerySentboxRequestImpl();
		querySentboxRequest.setUsername(username);
		querySentboxRequest.addSortRequest(new SortRequest("sentDate", SortDirection.DESC));
		querySentboxRequest.setPageSize(pageSize);
		querySentboxRequest.setPageNumber(first / pageSize);		
		
		QuerySentboxResponse response = messageService.querySentbox(querySentboxRequest);
		
		messageList = (List<MessageImpl>) response.getMessageList();
		setRowCount((int)response.getTotalRecordNumber());
		
		return messageList;
	}

	public List<MessageImpl> getMessageList() {
		return messageList;
	}
}
