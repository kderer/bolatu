package com.bolatu.service.api.service;

import com.bolatu.service.api.request.message.DeleteInboxMessageRequest;
import com.bolatu.service.api.request.message.DeleteSentMessageRequest;
import com.bolatu.service.api.request.message.QueryInboxRequest;
import com.bolatu.service.api.request.message.QuerySentboxRequest;
import com.bolatu.service.api.request.message.ReadMessageRequest;
import com.bolatu.service.api.request.message.SendMessageRequest;
import com.bolatu.service.api.response.message.DeleteInboxMessageResponse;
import com.bolatu.service.api.response.message.DeleteSentMessageResponse;
import com.bolatu.service.api.response.message.QueryInboxResponse;
import com.bolatu.service.api.response.message.QuerySentboxResponse;
import com.bolatu.service.api.response.message.ReadMessageResponse;
import com.bolatu.service.api.response.message.SendMessageResponse;

public interface MessageService {
	
	public SendMessageResponse sendMessage(SendMessageRequest sendMessageRequest);
	
	public ReadMessageResponse readMessage(ReadMessageRequest queryMessageRequest);
	
	public QueryInboxResponse queryInbox(QueryInboxRequest queryInboxRequest);
	
	public QuerySentboxResponse querySentbox(QuerySentboxRequest querySentboxRequest);
	
	public DeleteInboxMessageResponse deleteInboxMessage(DeleteInboxMessageRequest deleteInboxMessageRequest);
	
	public DeleteSentMessageResponse deleteSentMessage(DeleteSentMessageRequest deleteSentMessageRequest);

}
