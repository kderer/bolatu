package com.bolatu.db.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.impl.model.UserAuthInfoImpl;

public interface UserAuthInfoRepository extends CrudRepository<UserAuthInfoImpl, String> {
	
	public UserAuthInfoImpl findByUsername(String username);

}
