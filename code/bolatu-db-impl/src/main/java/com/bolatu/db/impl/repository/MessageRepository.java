package com.bolatu.db.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolatu.db.impl.model.MessageImpl;

public interface MessageRepository extends CrudRepository<MessageImpl, String> {

}
