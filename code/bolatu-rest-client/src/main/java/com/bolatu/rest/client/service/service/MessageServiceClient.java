package com.bolatu.rest.client.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.bolatu.rest.client.BolatuRestClient;
import com.bolatu.rest.client.service.response.message.DeleteInboxMessageResponseImpl;
import com.bolatu.rest.client.service.response.message.DeleteSentMessageResponseImpl;
import com.bolatu.rest.client.service.response.message.QueryInboxResponseImpl;
import com.bolatu.rest.client.service.response.message.QuerySentboxResponseImpl;
import com.bolatu.rest.client.service.response.message.ReadMessageResponseImpl;
import com.bolatu.rest.client.service.response.message.SendMessageResponseImpl;
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
import com.bolatu.service.api.service.MessageService;
import com.bolatu.util.I18NUtil;
import com.bolatu.util.constant.BolatuRestClientExceptionCodes;

@Service
public class MessageServiceClient implements MessageService {

	@Autowired
	private BolatuRestClient restClient;
	
	@Override
	public SendMessageResponse sendMessage(SendMessageRequest sendMessageRequest) {		
		String url = restClient.createUrl("message/send");		
		SendMessageResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					sendMessageRequest, SendMessageResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new SendMessageResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new SendMessageResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public ReadMessageResponse readMessage(
			ReadMessageRequest readMessageRequest) {		
		String url = restClient.createUrl("message/read");		
		ReadMessageResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					readMessageRequest, ReadMessageResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new ReadMessageResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new ReadMessageResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public QueryInboxResponse queryInbox(QueryInboxRequest queryInboxRequest) {		
		String url = restClient.createUrl("message/inbox");		
		QueryInboxResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					queryInboxRequest, QueryInboxResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new QueryInboxResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new QueryInboxResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}
	
	@Override
	public QuerySentboxResponse querySentbox(QuerySentboxRequest querySentboxRequest) {
		String url = restClient.createUrl("message/sentbox");		
		QuerySentboxResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					querySentboxRequest, QuerySentboxResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new QuerySentboxResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new QuerySentboxResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public DeleteInboxMessageResponse deleteInboxMessage(DeleteInboxMessageRequest deleteInboxMessageRequest) {		
		String url = restClient.createUrl("message/deleteInboxMessage");		
		DeleteInboxMessageResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					deleteInboxMessageRequest, DeleteInboxMessageResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new DeleteInboxMessageResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new DeleteInboxMessageResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public DeleteSentMessageResponse deleteSentMessage(DeleteSentMessageRequest deleteSentMessageRequest) {
		String url = restClient.createUrl("message/deleteSentMessage");		
		DeleteSentMessageResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					deleteSentMessageRequest, DeleteSentMessageResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new DeleteSentMessageResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new DeleteSentMessageResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

}
