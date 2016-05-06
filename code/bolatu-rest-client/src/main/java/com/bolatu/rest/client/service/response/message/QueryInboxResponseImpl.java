package com.bolatu.rest.client.service.response.message;

import java.util.List;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.model.MessageImpl;
import com.bolatu.rest.client.service.request.message.QueryInboxRequestImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.request.message.QueryInboxRequest;
import com.bolatu.service.api.response.message.QueryInboxResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class QueryInboxResponseImpl extends BaseServiceResponseImpl implements QueryInboxResponse {
	
	private long totalRecordNumber;
	private int pageSize;
	private int pageNumber;
	private QueryInboxRequestImpl queryInboxRequest;	
	private List<MessageImpl> messageList;

	public QueryInboxResponseImpl() {
		
	}

	@SuppressWarnings("unchecked")
	@JsonDeserialize(contentAs = MessageImpl.class)
	public void setMessageList(List<? extends Message> messageList) {
		this.messageList = (List<MessageImpl>) messageList;
	}

	@Override
	public List<MessageImpl> getMessageList() {
		return messageList;
	}

	@Override
	public long getTotalRecordNumber() {
		return totalRecordNumber;
	}

	@Override
	public void setTotalRecordNumber(long totalRecordNumber) {
		this.totalRecordNumber = totalRecordNumber;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public QueryInboxRequest getQueryInboxRequest() {
		return queryInboxRequest;
	}

	@JsonDeserialize(as = QueryInboxRequestImpl.class)
	public void setQueryInboxRequest(QueryInboxRequest queryInboxRequest) {
		this.queryInboxRequest = (QueryInboxRequestImpl) queryInboxRequest;
	}
	
}
