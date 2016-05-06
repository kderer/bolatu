package com.bolatu.service.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.EntryCriteria;
import com.bolatu.db.api.dao.EntryDao;
import com.bolatu.db.api.dao.UserDao;
import com.bolatu.db.api.model.Entry;
import com.bolatu.db.api.model.User;
import com.bolatu.db.impl.criteria.EntryCriteriaImpl;
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
import com.bolatu.service.impl.response.entry.CreateEntryResponseImpl;
import com.bolatu.service.impl.response.entry.DeleteEntryResponseImpl;
import com.bolatu.service.impl.response.entry.EntryQueryResponseImpl;
import com.bolatu.service.impl.response.entry.LikeEntryResponseImpl;
import com.bolatu.service.impl.response.entry.UnlikeEntryResponseImpl;
import com.bolatu.util.I18NUtil;
import com.bolatu.util.LogUtil;
import com.bolatu.util.constant.BolatuServiceReturnCodes;
import com.bolatu.util.data.PageResult;

@Service
public class EntryServiceImpl implements EntryService {
		
	@Autowired
	private EntryDao entryDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public EntryQueryResponse queryEntry(EntryQueryRequest entryQueryRequest) {
		
		PageResult<Entry> result;
		try {
			EntryCriteria criteria = new EntryCriteriaImpl();
			criteria.setEntryIdList(entryQueryRequest.getEntryIdList());
			criteria.setPageNumber(entryQueryRequest.getPageNumber());
			criteria.setPageSize(entryQueryRequest.getPageSize());
			criteria.setStatusList(entryQueryRequest.getStatusList());
			criteria.setSortRequestList(entryQueryRequest.getSortRequestList());
			criteria.setUsernameList(entryQueryRequest.getUsernameList());
			
			result = entryDao.findByCriteria(criteria);
		} catch (BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new EntryQueryResponseImpl(dbEx);
		}
		
		EntryQueryResponse response = new EntryQueryResponseImpl();
		response.setEntryList(result.getResultList());
		response.setTotalRecordNumber(result.getTotal());
		
		return response;
	}
	
	@Override
	public CreateEntryResponse createEntry(CreateEntryRequest createEntryRequest) {
		
		LogUtil.SERVICELOGGER.info("Create entry request will be handled: {}", createEntryRequest);
		
		Entry createdEntry;
		
		try {
			User user = userDao.findByUsername(createEntryRequest.getUsername());
			createEntryRequest.getEntry().setUser(user);
			createdEntry = entryDao.save(createEntryRequest.getEntry());
		} catch(BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			return new CreateEntryResponseImpl(dbEx);
		}
		
		CreateEntryResponse cer = new CreateEntryResponseImpl(createdEntry);
		cer.setResultMessage(I18NUtil.getMessage("message.entry.save.successful"));
		
		LogUtil.SERVICELOGGER.info("Create entry request is handled. Request: {}; Response: {}", createEntryRequest, cer); 
		
		return cer;
	}

	
	@Override
	public LikeEntryResponse likeEntry(LikeEntryRequest likeEntryRequest) {		
		LogUtil.SERVICELOGGER.info("Like entry request will be handled: {}", likeEntryRequest);
		
		try {
			entryDao.saveLike(likeEntryRequest.getEntryId(), likeEntryRequest.getUsername());
		} catch(BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			LikeEntryResponse response = new LikeEntryResponseImpl(dbEx);
			response.setLikeEntryRequest(likeEntryRequest);
			return response;
		}
		
		LikeEntryResponse response = new LikeEntryResponseImpl();
		response.setLikeEntryRequest(likeEntryRequest);
		
		LogUtil.SERVICELOGGER.info("Like entry request has been handled: {}", response);
		
		return response;
	}
	
	@Override
	public UnlikeEntryResponse unlikeEntry(UnlikeEntryRequest unlikeEntryRequest) {		
		LogUtil.SERVICELOGGER.info("Like entry request will be handled: {}", unlikeEntryRequest);
		try {
			entryDao.deleteLike(unlikeEntryRequest.getEntryId(), unlikeEntryRequest.getUsername());
		} catch(BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			UnlikeEntryResponse response = new UnlikeEntryResponseImpl(dbEx);
			response.setUnlikeEntryRequest(unlikeEntryRequest);
			return response;
		}
		
		UnlikeEntryResponse response = new UnlikeEntryResponseImpl();
		response.setUnlikeEntryRequest(unlikeEntryRequest);
		
		LogUtil.SERVICELOGGER.info("Like entry request has been handled: {}", response);
	
		return response;
	}

	@Override
	public DeleteEntryResponse deleteEntry(DeleteEntryRequest deleteEntryRequest) {
		EntryCriteria criteria = new EntryCriteriaImpl();
		criteria.addEntryId(deleteEntryRequest.getEntryId());
		criteria.addUserName(deleteEntryRequest.getUsername());
		
		Entry entry;
		try {
			entry = entryDao.findOneByCriteria(criteria);
		} catch(BolatuDbException dbEx) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
			DeleteEntryResponse response = new DeleteEntryResponseImpl(dbEx);
			return response;
		}
		
		if (entry == null) {
			DeleteEntryResponse response = new DeleteEntryResponseImpl();
			response.setResultCode(BolatuServiceReturnCodes.ENTRY_NOT_FOUND);
			response.setResultMessage(I18NUtil.getMessage("message.entry.notfound"));
			return response;
		}
		else {
			try {
				entryDao.delete(entry);
			} catch(BolatuDbException dbEx) {
				LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, dbEx);
				DeleteEntryResponse response = new DeleteEntryResponseImpl(dbEx);
				return response;
			}
		}
		
		DeleteEntryResponse response = new DeleteEntryResponseImpl();
		response.setResultMessage(I18NUtil.getMessage("message.entry.delete.successful"));
		return response;
	}
	
}
