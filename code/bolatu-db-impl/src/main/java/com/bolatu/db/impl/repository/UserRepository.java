package com.bolatu.db.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.impl.model.UserImpl;

public interface UserRepository extends CrudRepository<UserImpl, String> {
	
	public UserImpl findByEmail(String email);
	
	public UserImpl findByUsername(String username);
	
	public Long deleteByUsername(String username);

}
