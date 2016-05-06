package com.bolatu.rest.client.service.response.message;

import java.util.List;

import com.bolatu.db.api.model.Message;
import com.bolatu.rest.client.model.MessageImpl;
import com.bolatu.rest.client.service.request.message.QuerySentboxRequestImpl;
import com.bolatu.rest.client.service.response.BaseServiceResponseImpl;
import com.bolatu.service.api.request.message.QuerySentboxRequest;
import com.bolatu.service.api.response.message.QuerySentboxResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class QuerySentboxResponseImpl extends BaseServiceResponseImpl implements QuerySentboxResponse {
	
	private long totalRecordNumber;
	private int pageSize;
	private int pageNumber;
	private QuerySentboxRequest querySentboxRequest;	
	private List<MessageImpl> messageList;

	public QuerySentboxResponseImpl() {
		
	}
	
	@SuppressWarnings("unchecked")
	public QuerySentboxResponseImpl(QuerySentboxRequest querySentboxRequest,
			List<? extends Message> messageList) {
		this.messageList = (List<MessageImpl>) messageList;
		this.querySentboxRequest = querySentboxRequest;
	}	

	@SuppressWarnings("unchecked")
	@Override
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

	public QuerySentboxRequest getQuerySentboxRequest() {
		return querySentboxRequest;
	}

	@JsonDeserialize(as = QuerySentboxRequestImpl.class)
	public void setQuerySentboxRequest(QuerySentboxRequest querySentboxRequest) {
		this.querySentboxRequest = querySentboxRequest;
	}
	
}
