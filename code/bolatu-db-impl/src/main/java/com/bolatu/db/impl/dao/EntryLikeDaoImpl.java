package com.bolatu.db.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.EntryLikeCriteria;
import com.bolatu.db.api.dao.EntryLikeDao;
import com.bolatu.db.api.model.EntryLike;
import com.bolatu.db.impl.criteria.EntryLikeCriteriaImpl;
import com.bolatu.db.impl.model.EntryLikeImpl;
import com.bolatu.db.impl.repository.EntryLikeRepository;
import com.bolatu.util.DateUtil;
import com.bolatu.util.data.PageRequest;
import com.bolatu.util.data.PageResult;

@Service
public class EntryLikeDaoImpl extends BaseDaoImpl<EntryLike, String, EntryLikeCriteria> implements EntryLikeDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private EntryLikeRepository entryLikeRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	protected EntryLikeRepository getCrudRepository() {
		return entryLikeRepository;
	}

	@Override
	protected MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	@Override
	protected void preSave(EntryLike entryLike) {
		entryLike.setLikeDate(DateUtil.getCurrentTime());
	}
	
	@Override
	protected void postSave(EntryLike t) {
		
	}
	
	@Override
	protected void preDelete(EntryLike entryLike) {
		
	}
	
	@Override
	protected void postDelete(EntryLike t) {
		
	}
	

	@Override
	protected Query generateQueryFromCriteria(EntryLikeCriteria criteria) {
		Query query = new Query();
		return query;
	}

	@Override
	protected Class<? extends EntryLike> getDocumentClass() {
		return EntryLikeImpl.class;
	}

	@Override
	protected String getDocumentName() {
		return EntryLikeImpl.EntryLikeField.collection.getField();
	}

	@Override
	public PageResult<EntryLike> findByEntryId(String entryId,
			PageRequest pageRequest) throws BolatuDbException {
		
		Pageable page = validateAndCreatePageRequest(pageRequest);
		Page<EntryLikeImpl> pageResult = entryLikeRepository.findByEntryId(entryId, page);
		
		return new PageResult<EntryLike>(pageResult.getNumber(), pageResult.getSize(),
				pageResult.getTotalElements(), pageResult.getContent());
	}

	@Override
	public void delete(String entryId, String username) throws BolatuDbException {
		EntryLikeCriteria criteria = new EntryLikeCriteriaImpl();
		criteria.addEntryId(entryId);
		criteria.addUsername(username);
		
		delete(findOneByCriteria(criteria));
	}	

}
