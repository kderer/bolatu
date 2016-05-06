package com.bolatu.db.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.impl.model.EntryImpl;

public interface EntryRepository extends CrudRepository<EntryImpl, String> {

}
