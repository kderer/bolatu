package com.bolatu.db.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.impl.model.ResetPasswordCodeImpl;

public interface ResetPasswordCodeRepository extends CrudRepository<ResetPasswordCodeImpl, String> {

}
