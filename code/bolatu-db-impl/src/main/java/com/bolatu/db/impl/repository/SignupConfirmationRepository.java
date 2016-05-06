package com.bolatu.db.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.impl.model.SignupConfirmationImpl;

public interface SignupConfirmationRepository extends CrudRepository<SignupConfirmationImpl, String> {
	
	public long deleteByUsername(String username);

}
