package com.bolatu.db.impl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.impl.model.EntryLikeImpl;

public interface EntryLikeRepository extends CrudRepository<EntryLikeImpl, String> {
	
	public Page<EntryLikeImpl> findByEntryId(String entryId, Pageable pageRequest);

}
