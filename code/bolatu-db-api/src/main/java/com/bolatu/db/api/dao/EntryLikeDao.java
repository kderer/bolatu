package com.bolatu.db.api.dao;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.EntryLikeCriteria;
import com.bolatu.db.api.model.EntryLike;
import com.bolatu.util.data.PageRequest;
import com.bolatu.util.data.PageResult;

public interface EntryLikeDao extends BaseDao<EntryLike, String, EntryLikeCriteria> {
	
	public PageResult<EntryLike> findByEntryId(String entryId, PageRequest pageRequest) throws BolatuDbException;
	
	public void delete(String entryId, String username) throws BolatuDbException;

}
