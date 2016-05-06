package com.bolatu.rest.client.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.bolatu.rest.client.BolatuRestClient;
import com.bolatu.rest.client.service.response.entry.CreateEntryResponseImpl;
import com.bolatu.rest.client.service.response.entry.DeleteEntryResponseImpl;
import com.bolatu.rest.client.service.response.entry.EntryQueryResponseImpl;
import com.bolatu.rest.client.service.response.entry.LikeEntryResponseImpl;
import com.bolatu.rest.client.service.response.entry.UnlikeEntryResponseImpl;
import com.bolatu.service.api.request.entry.CreateEntryRequest;
import com.bolatu.service.api.request.entry.DeleteEntryRequest;
import com.bolatu.service.api.request.entry.EntryQueryRequest;
import com.bolatu.service.api.request.entry.LikeEntryRequest;
import com.bolatu.service.api.request.entry.UnlikeEntryRequest;
import com.bolatu.service.api.response.entry.CreateEntryResponse;
import com.bolatu.service.api.response.entry.DeleteEntryResponse;
import com.bolatu.service.api.response.entry.EntryQueryResponse;
import com.bolatu.service.api.response.entry.LikeEntryResponse;
import com.bolatu.service.api.response.entry.UnlikeEntryResponse;
import com.bolatu.service.api.service.EntryService;
import com.bolatu.util.I18NUtil;
import com.bolatu.util.constant.BolatuRestClientExceptionCodes;

@Service
public class EntryServiceClient implements EntryService {

	@Autowired
	private BolatuRestClient restClient;

	@Override
	public EntryQueryResponse queryEntry(EntryQueryRequest entryQueryRequest) {
		String url = restClient.createUrl("entry");
		EntryQueryResponse response =  null;
		try {
			response = restClient.getRestTemplate().postForObject(url,
					entryQueryRequest, EntryQueryResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new EntryQueryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new EntryQueryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public CreateEntryResponse createEntry(CreateEntryRequest createEntryRequest) {
		String url = restClient.createUrl("entry/create");		
		CreateEntryResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					createEntryRequest, CreateEntryResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new CreateEntryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new CreateEntryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public LikeEntryResponse likeEntry(LikeEntryRequest likeEntryRequest) {

		String url = restClient.createUrl("entry/like");		
		LikeEntryResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					likeEntryRequest, LikeEntryResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new LikeEntryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new LikeEntryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public UnlikeEntryResponse unlikeEntry(UnlikeEntryRequest unlikeEntryRequest) {
		String url = restClient.createUrl("entry/unlike");		
		UnlikeEntryResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					unlikeEntryRequest, UnlikeEntryResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new UnlikeEntryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new UnlikeEntryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

	@Override
	public DeleteEntryResponse deleteEntry(DeleteEntryRequest deleteEntryRequest) {
		String url = restClient.createUrl("entry/delete");		
		DeleteEntryResponse response = null;
		
		try {
			response = restClient.getRestTemplate().postForObject(url,
					deleteEntryRequest, DeleteEntryResponseImpl.class);
		} catch(ResourceAccessException raEx) {
			response = new DeleteEntryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.CONNECTION_LOST);
			response.setResultMessage(I18NUtil.getMessage("client.message.connection.lost"));
		} catch(Exception ex) {
			response = new DeleteEntryResponseImpl();
			response.setResultCode(BolatuRestClientExceptionCodes.UNEXPECTED_EXCEPTION);
			response.setResultMessage(I18NUtil.getMessage("client.message.unexpectedexception"));
		}
		
		return response;
	}

}
