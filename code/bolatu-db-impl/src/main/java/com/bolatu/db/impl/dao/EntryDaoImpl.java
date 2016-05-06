/**
 * 
 */
package com.bolatu.db.impl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.EntryCriteria;
import com.bolatu.db.api.dao.EntryDao;
import com.bolatu.db.api.dao.EntryLikeDao;
import com.bolatu.db.api.model.Entry;
import com.bolatu.db.api.model.EntryLike;
import com.bolatu.db.impl.criteria.EntryCriteriaImpl;
import com.bolatu.db.impl.model.EntryImpl;
import com.bolatu.db.impl.model.EntryImpl.EntryField;
import com.bolatu.db.impl.model.EntryLikeImpl;
import com.bolatu.db.impl.model.UserImpl.UserField;
import com.bolatu.db.impl.repository.EntryRepository;
import com.bolatu.util.DateUtil;
import com.bolatu.util.LogUtil;
import com.bolatu.util.data.SortRequest;
import com.bolatu.util.enumaration.EntryStatus;
import com.bolatu.util.enumaration.SortDirection;

/**
 * @author Kadir
 *
 */
@Service
public class EntryDaoImpl extends BaseDaoImpl<Entry, String, EntryCriteria> implements EntryDao {	

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private EntryLikeDao entryLikeDao;
	
	@Autowired
	private EntryRepository entryRepository;	

	@Override
	public void updateStatus(String entryId, EntryStatus status)
			throws BolatuDbException {
		Query query = createIsQuery(EntryField.id.getField(), entryId);
		Update update = new Update().set(EntryField.status.getField(), status.getCode());
		
		mongoOperations.findAndModify(query, update, getDocumentClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected EntryRepository getCrudRepository() {
		return entryRepository;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Override
	protected void preSave(Entry t) {
		
	}
	
	@Override
	protected void postSave(Entry t) {
		
	}
	
	@Override
	protected void preDelete(Entry t) {
		
	}
	
	@Override
	protected void postDelete(Entry t) {
		
	}

	@Override
	protected Query generateQueryFromCriteria(EntryCriteria entryCriteria) {
		Query query = new Query();
		
		if(!CollectionUtils.isEmpty(entryCriteria.getEntryIdList())) {
			query.addCriteria(Criteria.where(EntryField.id.getField()).in(entryCriteria.getEntryIdList()));
		}
		
		if(!CollectionUtils.isEmpty(entryCriteria.getIpList())) {
			query.addCriteria(Criteria.where(EntryField.ip.getField()).in(entryCriteria.getIpList()));
		}
		
		if(!CollectionUtils.isEmpty(entryCriteria.getSourceGenderList())) {
			query.addCriteria(Criteria.where(EntryField.user.getField() + "." + 
					UserField.gender.getField()).in(entryCriteria.getSourceGenderList()));
		}
		
		if(entryCriteria.getSourceAgeInterval() != null) {
			Criteria sourceAgeCriteria = Criteria.where(EntryField.user.getField() + "." + 
					UserField.birthday.getField());
			
			if (entryCriteria.getSourceAgeInterval().getStartValue() != null) {
				sourceAgeCriteria.lte(DateUtil.
					getDateForAge(entryCriteria.getSourceAgeInterval().getStartValue()));
			}
			
			if (entryCriteria.getSourceAgeInterval().getEndValue() != null) {
				sourceAgeCriteria.gte(DateUtil.
					getDateForAge(entryCriteria.getSourceAgeInterval().getEndValue()));
			}
			
			query.addCriteria(sourceAgeCriteria);
		}
		
		if(!CollectionUtils.isEmpty(entryCriteria.getTagList())) {
			query.addCriteria(Criteria.where(EntryField.tags.getField()).in(entryCriteria.getTagList()));
		}
		
		if (!CollectionUtils.isEmpty(entryCriteria.getTargetAgeRangeList())) {
			query.addCriteria(Criteria.where(EntryField.targetAgeRange.getField()).
					in(entryCriteria.getTargetAgeRangeList()));
		}
		
		if (!CollectionUtils.isEmpty(entryCriteria.getTargetGenderList())) {
			query.addCriteria(Criteria.where(EntryField.targetGender.getField()).
					in(entryCriteria.getTargetGenderList()));
		}
		
		if (!CollectionUtils.isEmpty(entryCriteria.getStatusList())) {
			query.addCriteria(Criteria.where(EntryField.status.getField()).
					in(entryCriteria.getStatusList()));
		}
		
		if (!CollectionUtils.isEmpty(entryCriteria.getUsernameList())) {
			query.addCriteria(Criteria.where(EntryField.user.getField() + "." + 
					UserField.username.getField()).in(entryCriteria.getUsernameList()));
		}
		
		return query;
	}

	@Override
	protected Class<EntryImpl> getDocumentClass() {
		return EntryImpl.class;
	}

	@Override
	protected String getDocumentName() {
		return EntryImpl.EntryField.collection.getField();
	}

	@Override
	public void saveLike(String entryId, String username) throws BolatuDbException {
		Query query = createIsQuery(EntryField.id.getField(), entryId);
		
		Update update = new Update();
		update.addToSet(EntryField.likedUserList.getField(), username);
		
		try {
			mongoOperations.findAndModify(query, update, getDocumentClass());			
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
		
		EntryLike entryLike = new EntryLikeImpl();
		entryLike.setEntryId(entryId);
		entryLike.setUsername(username);
		entryLike.setLikeDate(DateUtil.getCurrentTime());
		
		entryLikeDao.save(entryLike);
	}

	@Override
	public void deleteLike(String entryId, String username) throws BolatuDbException {
		Query query = createIsQuery(EntryField.id.getField(), entryId);
		
		Update update = new Update();
		update.pull(EntryField.likedUserList.getField(), username);
		
		try {
			mongoOperations.findAndModify(query, update, getDocumentClass());
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.DBLOGGER, e);
			throw new BolatuDbException(BolatuDbException.UNEXPECTED_EXCEPTION);
		}
		
		entryLikeDao.delete(entryId, username);
	}
	
	@Override
	public List<? extends Entry> findMostLiked() throws BolatuDbException {
		EntryCriteria criteria = new EntryCriteriaImpl();
		criteria.addStatus(EntryStatus.APPROVED.getCode());
		criteria.addSortRequest(new SortRequest(EntryField.likedUserList.getField() + ".size", SortDirection.DESC));
		
		
		return null;
	}
	
}
