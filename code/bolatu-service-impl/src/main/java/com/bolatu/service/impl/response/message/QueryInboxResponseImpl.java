package com.bolatu.service.impl.response.message;

import java.util.List;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.model.Message;
import com.bolatu.db.impl.model.MessageImpl;
import com.bolatu.service.api.request.message.QueryInboxRequest;
import com.bolatu.service.api.response.message.QueryInboxResponse;
import com.bolatu.service.impl.response.BaseServiceResponseImpl;

public class QueryInboxResponseImpl extends BaseServiceResponseImpl implements QueryInboxResponse {
	
	private long totalRecordNumber;
	private int pageSize;
	private int pageNumber;
	private QueryInboxRequest queryInboxRequest;	
	private List<MessageImpl> messageList;

	public QueryInboxResponseImpl() {
		
	}
	
	@SuppressWarnings("unchecked")
	public QueryInboxResponseImpl(QueryInboxRequest queryInboxRequest,
			List<? extends Message> messageList) {
		this.messageList = (List<MessageImpl>) messageList;
		this.queryInboxRequest = queryInboxRequest;
	}
	
	public QueryInboxResponseImpl(BolatuDbException dbEx) {
		super(dbEx);
	}	

	@SuppressWarnings("unchecked")
	@Override
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

	public void setQueryInboxRequest(QueryInboxRequest queryInboxRequest) {
		this.queryInboxRequest = queryInboxRequest;
	}
	
}
