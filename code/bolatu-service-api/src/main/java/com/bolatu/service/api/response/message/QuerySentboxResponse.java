package com.bolatu.service.api.response.message;

import java.util.List;

import com.bolatu.db.api.model.Message;
import com.bolatu.service.api.request.message.QuerySentboxRequest;
import com.bolatu.service.api.response.BaseServiceResponse;
import com.bolatu.service.api.response.PageableResponse;

public interface QuerySentboxResponse extends BaseServiceResponse, PageableResponse {
	
	public void setQuerySentboxRequest(QuerySentboxRequest request);
	public QuerySentboxRequest getQuerySentboxRequest();
	
	public void setMessageList(List<? extends Message> messageList);
	public List<? extends Message> getMessageList();
	
}
