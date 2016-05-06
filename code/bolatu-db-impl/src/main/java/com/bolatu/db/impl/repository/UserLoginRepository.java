package com.bolatu.db.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.impl.model.UserLoginImpl;

public interface UserLoginRepository extends CrudRepository<UserLoginImpl, String> {

}
