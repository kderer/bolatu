package com.bolatu.db.api.dao;

import java.util.List;

import com.bolatu.db.api.BolatuDbException;
import com.bolatu.db.api.criteria.EntryCriteria;
import com.bolatu.db.api.model.Entry;
import com.bolatu.util.enumaration.EntryStatus;

public interface EntryDao extends BaseDao<Entry, String, EntryCriteria> {
	
	public void updateStatus(String entryId, EntryStatus status) throws BolatuDbException;
	
	public void saveLike(String entryId, String username) throws BolatuDbException;
	
	public void deleteLike(String entryId, String username) throws BolatuDbException;
	
	public List<? extends Entry> findMostLiked() throws BolatuDbException;
}
