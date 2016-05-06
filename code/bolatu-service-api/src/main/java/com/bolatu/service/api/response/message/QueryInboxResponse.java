package com.bolatu.service.api.response.message;

import java.util.List;

import com.bolatu.db.api.model.Message;
import com.bolatu.service.api.request.message.QueryInboxRequest;
import com.bolatu.service.api.response.BaseServiceResponse;
import com.bolatu.service.api.response.PageableResponse;

public interface QueryInboxResponse extends BaseServiceResponse, PageableResponse {
	
	public void setQueryInboxRequest(QueryInboxRequest request);
	public QueryInboxRequest getQueryInboxRequest();
	
	public void setMessageList(List<? extends Message> messageList);
	public List<? extends Message> getMessageList();
	
}
