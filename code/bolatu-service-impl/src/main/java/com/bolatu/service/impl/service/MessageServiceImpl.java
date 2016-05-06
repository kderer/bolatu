package com.bolatu.service.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.MessageCriteria;
import com.bolatu.db.api.dao.MessageDao;
import com.bolatu.db.api.model.Message;
import com.bolatu.db.impl.criteria.MessageCriteriaImpl;
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
import com.bolatu.service.api.service.NotificationService;
import com.bolatu.service.impl.response.message.DeleteInboxMessageResponseImpl;
import com.bolatu.service.impl.response.message.DeleteSentMessageResponseImpl;
import com.bolatu.service.impl.response.message.QueryInboxResponseImpl;
import com.bolatu.service.impl.response.message.QuerySentboxResponseImpl;
import com.bolatu.service.impl.response.message.ReadMessageResponseImpl;
import com.bolatu.service.impl.response.message.SendMessageResponseImpl;
import com.bolatu.util.I18NUtil;
import com.bolatu.util.LogUtil;
import com.bolatu.util.data.PageResult;
import com.bolatu.util.enumaration.MessageStatus;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	
    @Autowired
    private NotificationService notification;
	
	@Override
	public SendMessageResponse sendMessage(SendMessageRequest sendMessageRequest) {		
		
        try {
			messageDao.save(sendMessageRequest.getMessage());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new SendMessageResponseImpl(dbEx);
		}
        
        notification.sendMessageNotification(sendMessageRequest.getMessage());
		
        SendMessageResponse response = new SendMessageResponseImpl();
		response.setResultMessage(I18NUtil.getMessage("message.message.send.success"));
		response.setMessage(sendMessageRequest.getMessage());		
		
		return response;
	}

	@Override
	public ReadMessageResponse readMessage(ReadMessageRequest readMessageRequest) {		
		String messageId = readMessageRequest.getMessageId();
		Message message;
		
		try {
			messageDao.updateStatus(messageId, MessageStatus.READ);		
			message = messageDao.findById(messageId);				
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new ReadMessageResponseImpl(dbEx);
		}
		
		return new ReadMessageResponseImpl(readMessageRequest, message);
	}

	@Override
	public QueryInboxResponse queryInbox(QueryInboxRequest queryInboxRequest) {
		MessageCriteria inboxCriteria = new MessageCriteriaImpl();
		inboxCriteria.addReceiverUsername(queryInboxRequest.getUsername());
		inboxCriteria.setPageNumber(queryInboxRequest.getPageNumber());
		inboxCriteria.setPageSize(queryInboxRequest.getPageSize());
		inboxCriteria.setSortRequestList(queryInboxRequest.getSortRequestList());
		inboxCriteria.setDeletedFromInbox(false);
		
		if (queryInboxRequest.getStatus() != null) {
			inboxCriteria.addStatus(queryInboxRequest.getStatus());
		}
		
		PageResult<Message> result;
		try {
			result = messageDao.findByCriteria(inboxCriteria);			
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new QueryInboxResponseImpl(dbEx);
		}
		
		QueryInboxResponse response = new QueryInboxResponseImpl(queryInboxRequest, result.getResultList());
		response.setTotalRecordNumber(result.getTotal());
		
		return response;
	}
	
	@Override
	public QuerySentboxResponse querySentbox(QuerySentboxRequest querySentboxRequest) {
		MessageCriteria sentboxCriteria = new MessageCriteriaImpl();
		sentboxCriteria.addSenderUsername(querySentboxRequest.getUsername());
		sentboxCriteria.setPageNumber(querySentboxRequest.getPageNumber());
		sentboxCriteria.setPageSize(querySentboxRequest.getPageSize());
		sentboxCriteria.setSortRequestList(querySentboxRequest.getSortRequestList());
		sentboxCriteria.setDeletedFromSent(false);
		
		PageResult<Message> result;
		try {
			result = messageDao.findByCriteria(sentboxCriteria);			
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new QuerySentboxResponseImpl(dbEx);
		}
		
		QuerySentboxResponse response = new QuerySentboxResponseImpl(querySentboxRequest, result.getResultList());
		response.setTotalRecordNumber(result.getTotal());
		
		return response;
	}

	@Override
	public DeleteInboxMessageResponse deleteInboxMessage(DeleteInboxMessageRequest deleteInboxMessageRequest) {
		DeleteInboxMessageResponse response = null;
		try {
			messageDao.deleteFromInbox(deleteInboxMessageRequest.getMessageId(), 
					deleteInboxMessageRequest.getServiceRequestInfo().getUsername());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new DeleteInboxMessageResponseImpl(dbEx);
		}
		
		response = new DeleteInboxMessageResponseImpl(deleteInboxMessageRequest.getMessageId());
		response.setResultMessage(I18NUtil.getMessage("message.message.delete.inbox.success"));
		
		return response;
	}

	@Override
	public DeleteSentMessageResponse deleteSentMessage(DeleteSentMessageRequest deleteSentMessageRequest) {
		DeleteSentMessageResponse response = null;
		try {
			messageDao.deleteFromSent(deleteSentMessageRequest.getMessageId(), 
					deleteSentMessageRequest.getServiceRequestInfo().getUsername());
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new DeleteSentMessageResponseImpl(dbEx);
		}
		
		response = new DeleteSentMessageResponseImpl(deleteSentMessageRequest.getMessageId());
		response.setResultMessage(I18NUtil.getMessage("message.message.delete.sent.success"));
		
		return response;
	}

}
